/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserPrimaryExpresionTest extends TestCase{
	/*
	 * Tries to parser the input string as a logical and expression
	 */	
	public void testPrimaryExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).primary_expression().tree.toString() + "\n-----------\n");
		
	}
	
	
	@Test
	public void testPrimaryExpression01() throws Exception
	{
		testPrimaryExpression("a");
	}
	
	@Test
	public void testPrimaryExpression02() throws Exception
	{
		testPrimaryExpression("(a)");
		
	}
	@Test
	public void testPrimaryExpression03() throws Exception
	{
		testPrimaryExpression("42");
	}
	@Test
	public void testPrimaryExpression04() throws Exception
	{
		testPrimaryExpression("42.23");
	}
	@Test
	public void testPrimaryExpression05() throws Exception
	{
		testPrimaryExpression("true");
	}
	@Test
	public void testPrimaryExpression06() throws Exception
	{
		testPrimaryExpression("false");
	}
	
	
	
	@Test
	public void testPrimaryExpression07() throws Exception
	{
		testPrimaryExpression("(a)");
	}
	@Test
	public void testPrimaryExpression08() throws Exception
	{
		testPrimaryExpression("a[42]");
	}

	@Test
	public void testPrimaryExpression09() throws Exception
	{
		testPrimaryExpression("callstuff.rot32(a.input12(), a, a.elevensees(),a)");
	}
	
	@Test
	public void testPrimaryExpression10() throws Exception
	{
		testPrimaryExpression("'something'");
	}
	
	
	


	
	
}