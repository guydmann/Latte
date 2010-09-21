/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;



public class LatteParserExponentialExpressionTest extends TestCase {
	/*
	 * Tries to parser the input string as an exponential expression
	 */	
	public void testExponentialExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).exp_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testExponentialExpression01() throws Exception
	{
		testExponentialExpression("a");
	}
	
	@Test
	public void testExponentialExpression02() throws Exception
	{
		testExponentialExpression("q^a");
	}
	
	@Test
	public void testExponentialExpression03() throws Exception
	{
		testExponentialExpression("qa^aa^qq");
	}
	
	@Test
	public void testExponentialExpression04() throws Exception
	{
		testExponentialExpression("qa^aa^qq^zz");
	}
	@Test
	public void testExponentialExpression05() throws Exception
	{
		testExponentialExpression("qa^a*a^q/q^z+z");
		System.out.println("only the qa^a is recognized cause we are parsing exponential expressions here");
	}
	
}
