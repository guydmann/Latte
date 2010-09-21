/*
 * @author: Guy Mann 
 */
grammar Latte;

options {
  language = Java;
  output = AST;
  backtrack=true;
  memoize=true;
  ASTLabelType =LatteAST;
}

// Tokens for AST nodes that don't correspond to specific rules
tokens {
//    FCONST;             // floating-point constant
    UMINUS;             // unary minus
    DECL;               // declaration
    METH;               // method
    ARRAY;               // array
    METHCALL;               // method call
    INDEX;              //an index in an array
    SEQUENCE;           // a sequence of elements (expressions, variables, etc.)
    BLOCK;              // indicates the start of a compound statement
}

@lexer::header{
package latte.lexparse;
}

@parser::header{
package latte.lexparse;
import latte.ast.*;
import latte.lexparse.LatteException;
import java.io.*;
}

@lexer::members {
    /**
     * This method is taken from the ANTLR FAQ 
     * http://www.antlr.org/wiki/pages/viewpage.action?pageId=5341217. It should
     * provide the ability to catch lexical errors on unrecognized lexer input.
     */
  public Token nextToken() {
    while (true) {
      state.token = null;
      state.channel = Token.DEFAULT_CHANNEL;
      state.tokenStartCharIndex = input.index();
      state.tokenStartCharPositionInLine = input.getCharPositionInLine();
      state.tokenStartLine = input.getLine();
      state.text = null;
      if ( input.LA(1)==CharStream.EOF ) {
        return Token.EOF_TOKEN;
      }
      try {
        mTokens();
        if ( state.token==null ) {
          emit();
        }
        else if ( state.token==Token.SKIP_TOKEN ) {
          continue;
        }
        return state.token;
      }
      catch (RecognitionException re) {
        reportError(re);
        throw new LatteException("Invalid character(s) in the input: ", re);
      }
    }
  }
  
  public static LatteLexer makeLexer (String input)  throws LatteException
  {
    try {
      LatteLexer lexer = new LatteLexer(
        new ANTLRReaderStream(
            new java.io.StringReader(input)));
      //if (lexer.nextToken().getType() != EOF) {
      //    throw new LatteException("All output not consumed" );  
      //}
      return lexer;
     } catch (java.io.IOException e) {
      throw new LatteException("IOException while creating a lexer: " + e.getMessage());
    }
  }
  
}

@parser::members {
    /**
     * This method is taken from the ANTLR FAQ 
     * http://www.antlr.org/wiki/pages/viewpage.action?pageId=5341217. It should
     * provide the ability to catch lexical errors on unrecognized lexer input.
     */
  //public LatteAST startRule() {
  //

  public static LatteParser makeParser(String text) throws LatteException
  {
    try {
      LatteLexer lexer = new LatteLexer(
                  new ANTLRReaderStream(
                      new StringReader(text)));
      
      LatteParser p = new LatteParser(new CommonTokenStream( lexer ));
      p.setTreeAdaptor(new LatteTreeAdaptor());
      return p;
    } catch (IOException e) {
      throw new LatteException("IOException while creating a parser: " + e.getMessage());
    }
  }
  
      /**
     * When a persing error occurs, this method is called. This overrides
     * the default behavior.
     * See: <a href="http://www.antlr.org/wiki/display/ANTLR3/Error+reporting+and+recovery">
     * the ANTLR error and recovery page</a> for more information.
     */
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        throw new RuntimeException("(" + hdr + ") " + msg, e);
    }
}

@lexer::rulecatch { 
  catch (RecognitionException e) {
      throw e;
  } 
}

@parser::rulecatch { 
  catch (RecognitionException e) {
      throw e;
  } 
}




// ----------------------- Syntactic Rules -----------------------

compilation_unit: CLASS_ID ID LCURL (body+=declaration)* RCURL EOF -> ^(CLASS_ID[$ID] $body*) ;

declaration: field_declaration | method_declaration; 

field_declaration: variable_declaration;

variable_declaration: type (ids+=scalar_field_declaration | ids+=array_declaration) (COMMA (ids+=scalar_field_declaration | ids+=array_declaration))* SEMI -> ^(DECL[$type.tree.token] $ids+);

type: INT_ID | BOOL_ID | FLOAT_ID | CHAR_ID;

return_type: type | VOID_ID;

scalar_field_declaration: ID;

//array_declaration: ID LBRACE size=INTEGER RBRACE -> ^(ARRAY[$size] ID);
array_declaration: ID LBRACE expression RBRACE -> ^(ARRAY ID expression);

method_declaration: (return_type) methname=ID LPAR formal_parameter_list RPAR block -> ^(METH[$methname] return_type formal_parameter_list? block);
//method_declaration: (return_type) methname=ID LPAR formal_parameter_list RPAR block -> ^(METH[$methname] formal_parameter_list block);
//method_declaration: return_type ID LPAR formal_parameter_list RPAR block -> ^(METH[ID] return_type formal_parameter_list block);

formal_parameter_list: (fparam+=formal_parameter (COMMA fparam+=formal_parameter)* )? -> ^(SEQUENCE $fparam+)?;

formal_parameter: type ID -> ^(DECL[$type.tree.token] ID)
                | type ID LBRACE RBRACE -> ^(DECL[$type.tree.token] ^(ARRAY ID));

block: LCURL (body+=variable_declaration | body+=statement)* RCURL -> ^(BLOCK $body*);

statement: assignment SEMI!
        | method_call SEMI!
        | if_op
        | while_op
        | return_op SEMI!
        | block
        | input SEMI!
        | output SEMI! 
        ;
//^(ID ^(INDEX INTEGER)?)
assignment: ID (LBRACE n1=expression RBRACE)? ASSIGN n2=expression -> ^(ASSIGN ^(ID ^(INDEX $n1)?) ^($n2));

//method_call: methname+=ID (PERIOD methname+=ID)* LPAR argument_list RPAR; 
method_call: methname+=ID (PERIOD methname+=ID)* LPAR argument_list RPAR -> ^(METHCALL ^(SEQUENCE $methname+) argument_list?);
//method_declaration: (return_type) methname=ID LPAR formal_parameter_list RPAR block -> ^(METH[$methname] return_type formal_parameter_list? block);

argument_list: (expression (COMMA expression)* )? -> ^(SEQUENCE expression+)?;

if_op: IF LPAR expr=expression RPAR truepart=block  (ELSE falsepart=block)? -> ^(IF $expr $truepart ^(ELSE $falsepart)?) ; 

while_op: WHILE^ LPAR! expression RPAR! block;// -> ^(WHILE expression block);

//return_op: RETURN | ^(RETURN expression);
//return_op: ^(RETURN expression?);
return_op: RETURN^ expression?;

input: INPUT ids+=ID (COMMA ids+=ID)* -> ^(INPUT ^(SEQUENCE $ids+));

output: PRINT exps+=expression (COMMA exps+=expression)* -> ^(PRINT ^(SEQUENCE $exps+));

expression: or_expression;

//or_expression: and_expression 
//              | or_expression OR and_expression -> ^(OR or_expression and_expression);
//or_expression: (or_expression OR^)? and_expression;
or_expression: (and_expression OR^)* and_expression ;

//and_expression: (and_expression AND^)? equality_expression;
and_expression: (equality_expression AND^)* equality_expression;

equality_expression: relational_expression ((EQUAL | NOTEQUAL)^ relational_expression)?;

relational_expression: add_expression ((LT | GT | LTE | GTE)^ add_expression)?;

//add_expression: mult_expression 
//              | add_expression (op=PLUS | op=MINUS)^ mult_expression -> ^($op add_expression mult_expression);
//add_expression: (add_expression (op=PLUS | op=MINUS)^)? mult_expression ;
add_expression: (mult_expression (PLUS | MINUS)^)* mult_expression; 

//mult_expression:  (mult_expression (MULT | DIVIDE | MOD | DIV)^)? exp_expression;
mult_expression:  (exp_expression (MULT | DIVIDE | MOD | DIV)^)* exp_expression ;


//exp_expression: unary_expression 
//| unary_expression (EXPON^ exp_expression)?;
exp_expression: unary_expression (EXPON^ exp_expression)?;
//exp_expression: unary_expression (EXPON unary_expression)?;


unary_expression: MINUS unary_expression -> ^(UMINUS["-"] unary_expression)
        | NOT unary_expression  -> ^(NOT unary_expression)
        | primary_expression;

primary_expression: LPAR expression RPAR -> expression 
        | INTEGER 
        | FLOAT
        | BOOLEAN        
        | CHARLITERAL
        | method_call
        | ID (LBRACE expression RBRACE)? -> ^(ID ^(INDEX expression)?);
        


// ------------------------- Lexical Rules ----------------------



IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
INPUT: 'input';
PRINT: 'print';
VOID_ID: 'void';
CLASS_ID: 'class';
INT_ID: 'int';
FLOAT_ID: 'float';
BOOL_ID: 'boolean';
CHAR_ID: 'char';
ASSIGN: ':=';
PERIOD: '.';
SEMI: ';';
COMMA: ',';
NOT: '~';
EXPON: '^';
NOTEQUAL: '~=';
EQUAL: '=';
MOD: 'mod';
MULT: '*';
DIV: 'div';
DIVIDE: '/';
OR: '||';
AND: '&&';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';
MINUS: '-';
PLUS: '+';
LPAR: '(';
RPAR: ')';
LBRACE: '[';
RBRACE: ']';
LCURL: '{';
RCURL: '}';
fragment DIGIT : ('0'..'9');
fragment HEX_PREFIX : '0' ('x'|'X');
fragment HIGIT : DIGIT |'a'..'f'|'A'..'F';
fragment LETTER: (LOWER|UPPER);
fragment LOWER: 'a'..'z';
fragment UPPER: 'A'..'Z';


COMMENT: '#' COMMENT_CHAR* { $channel = HIDDEN; };
INTEGER: '-'? DIGIT+ | '-'? HEX_PREFIX HIGIT+;
FLOAT: '-'? DIGIT+ '.' DIGIT+;

//CHARLITERAL: '\'' (CHAR_CHAR)* '\'';
//CHARLITERAL: '\'' (CHAR_SLASH|CHAR_NEWLINE|CHAR_TAB|CHAR_APOS|CHAR_CHAR)* '\'';
CHARLITERAL: '\'' (CHAR_CHAR|CHAR_APOS)* '\'';
//CHARLITERAL: '\'' (CHAR_SPECIAL|CHAR_CHAR)* '\'';
BOOLEAN: 'true'|'false';
ID: LETTER (LETTER|DIGIT)*;
//fragment LETTER: 'a'..'z'|'A'..'Z';


//fragment COMMENT_CHAR: ('!'..'|'|'\u007E'..'\u00FF'|WHITESPACE) ;
fragment CHAR_CHAR: ~'\'';
fragment CHAR_APOS: '\\' '\'';
//fragment CHAR_SLASH: '\\' '\\';
//fragment CHAR_NEWLINE: '\\' 'n';
//fragment CHAR_TAB: '\\' 't';
//fragment CHAR_SPECIAL: CHAR_TAB|CHAR_NEWLINE|CHAR_SLASH|CHAR_APOS;
// Treat runs of newline characters as a single NEWLINE token.
// On some platforms, newlines are represented by a \n character.
// On others they are represented by a \r and a \n character.
NEWLINE: ('\r'? '\n')+ { $channel = HIDDEN; };

// Send runs of space and tab characters to the hidden channel.
// also NEWLINES are ignored.
// this could be simplified by combining newline and whitespace rules
// however, I like the seperation because it makes incremental improvements easier later  
WHITESPACE: (' ' | '\t')+ { $channel = HIDDEN; };
fragment COMMENT_CHAR: (~'\n');