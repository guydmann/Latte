/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserAdditiveExpressionTest extends TestCase {
	
	/*
	 * Tries to parser the input string as an additive expression
	 */
	public void testAdditiveExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).add_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testAdditiveExpression01() throws Exception
	{
		testAdditiveExpression("1+1.2");
	}
	
	@Test
	public void testAdditiveExpression02() throws Exception
	{
		testAdditiveExpression("q +a");
	}
	
	@Test
	public void testAdditiveExpression03() throws Exception
	{
		testAdditiveExpression("q-a");
	}
	
	@Test
	public void testAdditiveExpression04() throws Exception
	{
		testAdditiveExpression("q-a^3");
	}
	
	@Test
	public void testAdditiveExpression05() throws Exception
	{
		testAdditiveExpression("z+1+q-a+3");
	}
	@Test
	public void testAdditiveExpression06() throws Exception
	{
		testAdditiveExpression("42*1/q-a+3");
	}
	
	@Test
	public void testAdditiveExpression07() throws Exception
	{
		testAdditiveExpression("42+2*1/q-a+3");
	}
	
	@Test
	public void testAdditiveExpression08() throws Exception
	{
		testAdditiveExpression("q*a+5345/c div 2");
	}
	
	
}
