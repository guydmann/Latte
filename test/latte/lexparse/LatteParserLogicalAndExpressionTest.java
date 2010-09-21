/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserLogicalAndExpressionTest extends TestCase {
	/*
	 * Tries to parser the input string as a logical and expression
	 */	
	public void testLogicalAndExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).and_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testLogicalAndExpression01() throws Exception
	{
		testLogicalAndExpression("a");
	}
	
	@Test
	public void testLogicalAndExpression02() throws Exception
	{
		testLogicalAndExpression("q && a>1");
	}
	
	@Test
	public void testLogicalAndExpression03() throws Exception
	{
		testLogicalAndExpression("q && a>1 && 2");
	}
	
	@Test
	public void testLogicalAndExpression04() throws Exception
	{
		testLogicalAndExpression("q && a>1 && 2*a && 1 && 69");
	}
	
}
