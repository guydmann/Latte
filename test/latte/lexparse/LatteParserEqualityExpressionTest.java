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
public class LatteParserEqualityExpressionTest extends TestCase {
	
	public void testLogicalOrExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testLogicalOrExpression01() throws Exception
	{
		testLogicalOrExpression("a");
	}
	
	@Test
	public void testLogicalOrExpression02() throws Exception
	{
		testLogicalOrExpression("q=1");
	}
	
	@Test
	public void testLogicalOrExpression03() throws Exception
	{
		testLogicalOrExpression("a~=2*b");
	}
	
	@Test
	public void testLogicalOrExpression04() throws Exception
	{
		testLogicalOrExpression("q~=69^n");
	}
	
}
