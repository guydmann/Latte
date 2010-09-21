/**
 * @author Guy Mann
 *
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;



public class LatteParserUnaryExpressionTest extends TestCase {
	/*
	 * Tries to parser the input string as a unary expression
	 */	
	public void testUnaryExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testUnaryExpression01() throws Exception
	{
		testUnaryExpression("a");
	}
	
	@Test
	public void testUnaryExpression02() throws Exception
	{
		testUnaryExpression("~a");
	}
	
	@Test
	public void testUnaryExpression03() throws Exception
	{
		testUnaryExpression("-a");
	}
	
	@Test
	public void testUnaryExpression04() throws Exception
	{
		testUnaryExpression("~(a*b)");
	}
	
}
