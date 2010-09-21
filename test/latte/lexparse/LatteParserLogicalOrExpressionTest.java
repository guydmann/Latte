/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserLogicalOrExpressionTest extends TestCase {
	/*
	 * Tries to parser the input string as a logical or expression
	 */	
	public void testLogicalOrExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).or_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testLogicalOrExpression01() throws Exception
	{
		testLogicalOrExpression("a");
	}
	
	@Test
	public void testLogicalOrExpression02() throws Exception
	{
		testLogicalOrExpression("q || a>1");
	}
	
	@Test
	public void testLogicalOrExpression03() throws Exception
	{
		testLogicalOrExpression("q || a>1 || 2");
	}
	
	@Test
	public void testLogicalOrExpression04() throws Exception
	{
		testLogicalOrExpression("q || a>1 || 2*a || 1 || 69");
	}
	
}
