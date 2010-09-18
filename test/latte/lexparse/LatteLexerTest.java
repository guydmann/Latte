/*
 * Created on Sep 2, 2010
 * 
 * Copyright (C) 2010, Gary Pollice, Worcester Polytechnic Institute, gpollice@cs.wpi.edu. 
 *
 * The program is provided under the terms and conditions of
 * the Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL
 * is available at http://www.eclipse.org/org/documents/epl-v10.php.
 */
package latte.lexparse;

import java.io.*;

import junit.framework.TestCase;

import org.antlr.runtime.*;
import org.junit.Test;


/**
 *
 * @author gpollice
 * @version Sep 2, 2010
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
	public void testOR1() throws IOException
	{
		String text = "||";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.OR, token.getType());
		assertEquals("||", token.getText());
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
		String text = "0XA";
		LatteLexer lex = LatteLexer.makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INTEGER, token.getType());
		assertEquals("0XA", token.getText());
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
	
	
	
}