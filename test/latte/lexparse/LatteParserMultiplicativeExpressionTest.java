/**
 * 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


/**
 * @author guydmann
 *
 */
public class LatteParserMultiplicativeExpressionTest extends TestCase {
	
	public void testMultiplicativeExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).mult_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testMultiplicativeExpression01() throws Exception
	{
		testMultiplicativeExpression("a");
	}
	
	@Test
	public void testMultiplicativeExpression02() throws Exception
	{
		testMultiplicativeExpression("q*a");
	}
	
	@Test
	public void testMultiplicativeExpression03() throws Exception
	{
		testMultiplicativeExpression("q*a/c mod 2");
	}
	
	@Test
	public void testMultiplicativeExpression04() throws Exception
	{
		testMultiplicativeExpression("q*a/c div 2");
	}
	
}
