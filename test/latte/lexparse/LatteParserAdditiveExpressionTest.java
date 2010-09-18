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
public class LatteParserAdditiveExpressionTest extends TestCase {
	
	public void testAdditiveExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).add_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testAdditiveExpression01() throws Exception
	{
		testAdditiveExpression("a");
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
	
}
