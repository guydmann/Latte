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
public class LatteParserExpressionTest extends TestCase {
	
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
	
}
