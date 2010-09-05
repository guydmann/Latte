/**
 * Created on Sep. 2, 2010
 * 
 * Copyright (C) 2010, Gary Pollice, Worcester Polytechnic Institute, gpollice@cs.wpi.edu.
 * 
 * The program is provided under the terms and conditions of the Eclipse Public License Version 1.0
 * ("EPL"). A copy of the EPL is available at http://www.eclipse.org/org/documents/epl-v10.php.
 *
 * Lexical and syntactic analyzer for the base Dijkstra language. If tokens are added,
 * the dijkstra.util.TokenNames class may need to be modified.
 */
lexer grammar LatteLexer;

//options {
//}

@lexer::header{
package latte.lexparse;
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
        throw new LatteException("Oops!", re);
//        throw new DijkstraException("Invalid character(s) in the input: ", re);
      }
    }
  }
}

@lexer::rulecatch { 
  catch (RecognitionException e) {
      throw e;
  } 
}

// ------------------------- Lexical Rules ----------------------
INTEGER : '-'? DIGIT+ | '-'? HEX_PREFIX HIGIT+
    ;
    
fragment
DIGIT : ('0'..'9')
    ;
    
fragment
HEX_PREFIX : '0' ('x'|'X')
    ;

fragment
HIGIT : DIGIT | ('a'..'f''A'..'F')
    ;