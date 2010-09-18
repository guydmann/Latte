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
public class LatteParserArgumentListTest extends TestCase {
	public void testArgumentList(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).argument_list().tree.toString() + "\n-----------\n");	
	}
	
	
	@Test
	public void testArgumentList01() throws Exception
	{
		testArgumentList("a");
	}
	
	@Test
	public void testArgumentList02() throws Exception
	{
		testArgumentList("23.42");
	}
	
	@Test
	public void testArgumentList03() throws Exception
	{
		testArgumentList("23,a,23.42");
	}
	
	@Test
	public void testArgumentList04() throws Exception
	{
		testArgumentList("true,a~=b,12,42.5,z");
	}
	
}
