/**
 * @author Guy Mann 
 */
package latte.lexparse;

import java.io.IOException;

import junit.framework.TestCase;
import org.antlr.runtime.Token;
import org.junit.Test;

/*
 * This class tests the lexer
 */
public class LatteLexerTest  extends TestCase {


	@Test
	public void testBOOLEAN1() throws IOException
	{
		String text = "true";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.BOOLEAN, token.getType());
		assertEquals("true", token.getText());
	}
	
	@Test
	public void testBOOLEAN2() throws IOException
	{
		String text = "false";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.BOOLEAN, token.getType());
		assertEquals("false", token.getText());
	}
	
	@Test
	public void testBOOLEAN3() throws IOException
	{
		String text = "something";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ID, token.getType());
		assertEquals("something", token.getText());
		assertTrue(LatteLexer.BOOLEAN!=token.getType());
	}
	
	@Test
	public void testBOOLEAN4() throws IOException
	{
		String text = "truesomething";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ID, token.getType());
		assertEquals("truesomething", token.getText());
		assertTrue(LatteLexer.BOOLEAN!=token.getType());
	}
	
	@Test
	public void testIF1() throws IOException
	{
		String text = "if";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.IF, token.getType());
		assertEquals("if", token.getText());
	}
	
	@Test
	public void testIF2() throws IOException
	{
		String text = "iff";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertFalse(LatteLexer.IF==token.getType());
		assertEquals("iff", token.getText());
	}
	
	@Test
	public void testIF3() throws IOException
	{
		String text = "if3";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertFalse(LatteLexer.IF==token.getType());
		assertEquals("if3", token.getText());
	}
	
	@Test
	public void testELSE1() throws IOException
	{
		String text = "else";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ELSE, token.getType());
		assertEquals("else", token.getText());
	}
	
	@Test
	public void testELSE2() throws IOException
	{
		String text = "else1";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertFalse(LatteLexer.ELSE==token.getType());
		assertEquals("else1", token.getText());
	}
	
	@Test
	public void testELSE3() throws IOException
	{
		String text = "elsea";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertFalse(LatteLexer.ELSE==token.getType());
		assertEquals("elsea", token.getText());
	}
	
	@Test
	public void testWHILE1() throws IOException
	{
		String text = "while";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.WHILE, token.getType());
		assertEquals("while", token.getText());
	}
	
	@Test
	public void testWHILE2() throws IOException
	{
		String text = "while123";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertFalse(LatteLexer.WHILE==token.getType());
		assertEquals("while123", token.getText());
	}
	
	@Test
	public void testWHILE3() throws IOException
	{
		String text = "whileasd";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertFalse(LatteLexer.WHILE==token.getType());
		assertEquals("whileasd", token.getText());
	}
	
	@Test
	public void testWHILE4() throws IOException
	{
		String text = "while;";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.WHILE,token.getType());
		assertEquals("while", token.getText());
	}
	
	@Test
	public void testRETURN() throws IOException
	{
		String text = "return";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.RETURN,token.getType());
		assertEquals("return", token.getText());
	}
	
	@Test
	public void testINPUT() throws IOException
	{
		String text = "input";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INPUT,token.getType());
		assertEquals("input", token.getText());
	}
	
	@Test
	public void testPRINT() throws IOException
	{
		String text = "print";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.PRINT,token.getType());
		assertEquals("print", token.getText());
	}
	
	@Test
	public void testVOID_ID() throws IOException
	{
		String text = "void";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.VOID_ID,token.getType());
		assertEquals("void", token.getText());
	}
	
	@Test
	public void testCLASS_ID() throws IOException
	{
		String text = "class";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CLASS_ID,token.getType());
		assertEquals("class", token.getText());
	}
	
	@Test
	public void testINT_ID() throws IOException
	{
		String text = "int";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INT_ID,token.getType());
		assertEquals("int", token.getText());
	}
	
	@Test
	public void testFLOAT_ID() throws IOException
	{
		String text = "float";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.FLOAT_ID,token.getType());
		assertEquals("float", token.getText());
	}
	
	@Test
	public void testBOOL_ID() throws IOException
	{
		String text = "boolean";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.BOOL_ID,token.getType());
		assertEquals("boolean", token.getText());
	}
	
	
	@Test
	public void testCHAR_ID() throws IOException
	{
		String text = "char";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHAR_ID,token.getType());
		assertEquals("char", token.getText());
	}
	
	@Test
	public void testASSIGN() throws IOException
	{
		String text = ":=";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ASSIGN,token.getType());
		assertEquals(":=", token.getText());
	}
	
	@Test
	public void testPERIOD() throws IOException
	{
		String text = ".";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.PERIOD,token.getType());
		assertEquals(".", token.getText());
	}
	
	@Test
	public void testSEMI() throws IOException
	{
		String text = ";";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.SEMI,token.getType());
		assertEquals(";", token.getText());
	}
	
	@Test
	public void testCOMMA() throws IOException
	{
		String text = ",";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.COMMA,token.getType());
		assertEquals(",", token.getText());
	}
	
	@Test
	public void testNOT() throws IOException
	{
		String text = "~";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.NOT,token.getType());
		assertEquals("~", token.getText());
	}
	
	@Test
	public void testEXPON() throws IOException
	{
		String text = "^";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.EXPON,token.getType());
		assertEquals("^", token.getText());
	}

	@Test
	public void testNOTEQUAL() throws IOException
	{
		String text = "~=";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.NOTEQUAL,token.getType());
		assertEquals("~=", token.getText());
	}
	
	@Test
	public void testEQUAL() throws IOException
	{
		String text = "=";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.EQUAL,token.getType());
		assertEquals("=", token.getText());
	}
	
	@Test
	public void testMOD() throws IOException
	{
		String text = "mod";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.MOD,token.getType());
		assertEquals("mod", token.getText());
	}
	
	@Test
	public void testMULT() throws IOException
	{
		String text = "*";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.MULT,token.getType());
		assertEquals("*", token.getText());
	}
	
	@Test
	public void testDIV() throws IOException
	{
		String text = "div";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.DIV,token.getType());
		assertEquals("div", token.getText());
	}
	
	@Test
	public void testDIVIDE() throws IOException
	{
		String text = "/";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.DIVIDE,token.getType());
		assertEquals("/", token.getText());
	}
	
	@Test
	public void testOR1() throws IOException
	{
		String text = "||";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.OR, token.getType());
		assertEquals("||", token.getText());
	}
	
	@Test
	public void testOR2() throws IOException
	{
		String text = "|||";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.OR, token.getType());
		assertEquals("||", token.getText());
		try {
//			lex = LatteLexer.makeLexer(text);
			token = lex.nextToken();
			assertFalse(1==1);
			//assertEquals(LatteLexer.INTEGER, token.getType());
			//assertEquals("0XA", token.getText());
		} catch (LatteException e) {
			// TODO Auto-generated catch block
			System.out.println("expected exception thrown for an unparsable character | after an ||(OR)");
			assertTrue(1==1);
		}
		
	}
	@Test
	public void testAND() throws IOException
	{
		String text = "&&";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.AND,token.getType());
		assertEquals("&&", token.getText());
	}

	@Test
	public void testGT() throws IOException
	{
		String text = ">";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.GT,token.getType());
		assertEquals(">", token.getText());
	}
	
	@Test
	public void testLT() throws IOException
	{
		String text = "<";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.LT,token.getType());
		assertEquals("<", token.getText());
	}
	
	
	@Test
	public void testGTE() throws IOException
	{
		String text = ">=";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.GTE,token.getType());
		assertEquals(">=", token.getText());
	}
	
	@Test
	public void testLTE() throws IOException
	{
		String text = "<=";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.LTE,token.getType());
		assertEquals("<=", token.getText());
	}
	
	@Test
	public void testMINUS() throws IOException
	{
		String text = "-";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.MINUS,token.getType());
		assertEquals("-", token.getText());
	}
	
	@Test
	public void testPLUS() throws IOException
	{
		String text = "+";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.PLUS,token.getType());
		assertEquals("+", token.getText());
	}
	
	@Test
	public void testLPAR() throws IOException
	{
		String text = "(";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.LPAR,token.getType());
		assertEquals("(", token.getText());
	}
	@Test
	public void testRPAR() throws IOException
	{
		String text = ")";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.RPAR,token.getType());
		assertEquals(")", token.getText());
	}
	
	@Test
	public void testLBRACE() throws IOException
	{
		String text = "[";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.LBRACE,token.getType());
		assertEquals("[", token.getText());
	}
	@Test
	public void testRBRACE() throws IOException
	{
		String text = "]";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.RBRACE,token.getType());
		assertEquals("]", token.getText());
	}
	
	@Test
	public void testLCURL() throws IOException
	{
		String text = "{";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.LCURL,token.getType());
		assertEquals("{", token.getText());
	}
	@Test
	public void testRCURL() throws IOException
	{
		String text = "}";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.RCURL,token.getType());
		assertEquals("}", token.getText());
	}
	
	@Test
	public void testFLOAT1() throws IOException
	{
		String text = "1.2";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.FLOAT, token.getType());
		assertEquals("1.2", token.getText());
	}
	
	@Test
	public void testFLOAT2() throws IOException
	{
		String text = "-1.2";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.FLOAT, token.getType());
		assertEquals("-1.2", token.getText());
	}
	@Test
	public void testINTEGER1() throws IOException
	{
		String text = "1364";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INTEGER, token.getType());
		assertEquals("1364", token.getText());
	}
	
	@Test
	public void testINTEGER2() throws IOException
	{
		String text = "1";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INTEGER, token.getType());
		assertEquals("1", token.getText());
	}
	
	@Test
	public void testINTEGER3() throws IOException
	{
		String text = "1.2";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertTrue(LatteLexer.INTEGER != token.getType());
		assertEquals(LatteLexer.FLOAT, token.getType());
		assertEquals("1.2", token.getText());
	}
	
	
	@Test
	public void testHIGIT1() throws IOException
	{
		String text = "0xA";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INTEGER, token.getType());
		assertEquals("0xA", token.getText());
	}
	
	@Test
	public void testHIGIT2() throws IOException
	{
		String text = "0X1FAB";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INTEGER, token.getType());
		assertEquals("0X1FAB", token.getText());
	}
	
	@Test
	public void testHIGIT3() 
	{
		String text = "0XG";
		LatteLexer lex;
		try {
			lex = LatteLexer.makeLexer(text);
			Token token = lex.nextToken();
			assertFalse(1==1);
			//assertEquals(LatteLexer.INTEGER, token.getType());
			//assertEquals("0XA", token.getText());
		} catch (LatteException e) {
			// TODO Auto-generated catch block
			System.out.println("expected exception thrown for an unparsable character 0xG which is not a valid Hex Digit");
			assertTrue(1==1);
		}
		
	}
	
	
	@Test
	public void testID01() throws IOException
	{
		String text = "a";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ID, token.getType());
		assertEquals("a", token.getText());
	}
	@Test
	public void testID02() throws IOException
	{
		String text = "cthulhu";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ID, token.getType());
		assertEquals("cthulhu", token.getText());
	}
	
	@Test
	public void testID03() throws IOException
	{
		String text = "cthulhu!@#@#";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.ID, token.getType());
		assertEquals("cthulhu", token.getText());
	}
	
	
	
	@Test
	public void testCHARLITERAL01() throws IOException
	{
		String text = "'a'";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHARLITERAL, token.getType());
		assertEquals("'a'", token.getText());
	}
	
	@Test
	public void testCHARLITERAL02() throws IOException
	{
		String text = "'Four score and seven years ago out forefather.1409uerng09&()*&$^%$^G'";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHARLITERAL, token.getType());
		assertEquals("'Four score and seven years ago out forefather.1409uerng09&()*&$^%$^G'", token.getText());
	}

	@Test
	public void testCHARLITERAL03() throws IOException
	{
		String text = "'\\''";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHARLITERAL, token.getType());
		assertEquals("'\\''", token.getText());
	}
	
	@Test
	public void testCHARLITERAL04() throws IOException
	{
		String text = "'\\'\\n\\t\\\\'";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHARLITERAL, token.getType());
		assertEquals("'\\'\\n\\t\\\\'", token.getText());
	}

	
	@Test
	public void testCHARLITERAL05() throws IOException
	{
		String text = "'a#64541231263'";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHARLITERAL, token.getType());
		assertEquals("'a#64541231263'", token.getText());
	}
	
	
	@Test
	public void testCHARLITERAL06() throws IOException
	{
		String text = "''''''''a''''''";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.CHARLITERAL, token.getType());
		assertEquals("''", token.getText());
	}

	
	@Test
	public void testWHITESPACE03() throws IOException
	{
		String text = "   aaaaa";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.WHITESPACE, token.getType());
		assertEquals("   ", token.getText());
	}
	
	@Test
	public void testWHITESPACE01() throws IOException
	{
		String text = "   ";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.WHITESPACE, token.getType());
		assertEquals("   ", token.getText());
	}
	
	@Test
	public void testWHITESPACE02() throws IOException
	{
		String text = "\t";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.WHITESPACE, token.getType());
		assertEquals("\t", token.getText());
	}
	
	@Test
	public void testCOMMENT01() throws IOException
	{
		String text = "#akdjlhfakldshf234$^%$*#*&_*()_@U^";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.COMMENT, token.getType());
		assertEquals("#akdjlhfakldshf234$^%$*#*&_*()_@U^", token.getText());
	}
	
	@Test
	public void testCOMMENT02() throws IOException
	{
		String text = "#akdjlhfakldshf234$^%$*#*&_*()_@U^\ndfkhjadfkhgskdfghslkfgh";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.COMMENT, token.getType());
		assertEquals("#akdjlhfakldshf234$^%$*#*&_*()_@U^", token.getText());
	}
	
	@Test
	public void testCOMMENT03() throws IOException
	{
		String text = "#";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.COMMENT, token.getType());
		assertEquals("#", token.getText());
	}
	
	
	
}