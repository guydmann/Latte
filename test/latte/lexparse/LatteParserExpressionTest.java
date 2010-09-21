/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserExpressionTest extends TestCase {
	/*
	 * Tries to parser the input string as an expression
	 */	
	public void testExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testExpression01() throws Exception
	{
		testExpression("a");
	}
	
	@Test
	public void testExpression02() throws Exception
	{
		testExpression("q || a>1");
	}
	
	@Test
	public void testExpression03() throws Exception
	{
		testExpression("q || a>1 && 2");
	}
	
	@Test
	public void testExpression04() throws Exception
	{
		testExpression("q || a>1 && 2*a");
	}
	
	
	@Test
	public void testExpression05() throws Exception
	{
		testExpression("~q || a<=1 || b>=1 && 2*a=12 || q~=11");
	}
	
}
