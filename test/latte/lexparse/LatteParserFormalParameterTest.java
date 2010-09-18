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
public class LatteParserFormalParameterTest extends TestCase{
	public void testParserFormal(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).formal_parameter().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testParserFormal01() throws Exception
	{

		testParserFormal("int a");
	}
	
	@Test
	public void testParserFormal02() throws Exception
	{
		testParserFormal("boolean b");
	}
	
	@Test
	public void testParserFormal03() throws Exception
	{
		testParserFormal("int a[]");
	}
	
	@Test
	public void testParserFormal04() throws Exception
	{
		testParserFormal("boolean b[]");
	}
	
}
