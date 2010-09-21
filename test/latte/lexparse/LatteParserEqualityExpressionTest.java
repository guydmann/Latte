/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserEqualityExpressionTest extends TestCase {
	/*
	 * Tries to parser the input string as an equality expression
	 */	
	public void testEqualityExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testEqualityExpression01() throws Exception
	{
		testEqualityExpression("a");
	}
	
	@Test
	public void testEqualityExpression02() throws Exception
	{
		testEqualityExpression("q=1");
	}
	
	@Test
	public void testEqualityExpression03() throws Exception
	{
		testEqualityExpression("a~=2*b");
	}
	
	@Test
	public void testEqualityExpression04() throws Exception
	{
		testEqualityExpression("q~=69^n");
	}
	
}
