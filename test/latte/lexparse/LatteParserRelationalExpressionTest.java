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
public class LatteParserRelationalExpressionTest extends TestCase {
	
	public void testRelationalExpression(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).relational_expression().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testRelationalExpression01() throws Exception
	{
		testRelationalExpression("a>b");
	}
	
	@Test
	public void testRelationalExpression02() throws Exception
	{
		testRelationalExpression("q<1");
	}
	
	@Test
	public void testRelationalExpression03() throws Exception
	{
		testRelationalExpression("q>=2^23*a");
	}
	
	@Test
	public void testRelationalExpression04() throws Exception
	{
		testRelationalExpression("q42<=a/79");
	}
	
}
