/**
 * @author Guy Mann
 *
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;



public class LatteParserReturnTest extends TestCase {
	/*
	 * Tries to parser the input string as a return
	 */	
	public void testReturn(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).return_op().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testReturn01() throws Exception
	{
		testReturn("return");
	}
	
	@Test
	public void testReturn02() throws Exception
	{
		testReturn("return 1");
	}
	
	@Test
	public void testReturn03() throws Exception
	{
		testReturn("return 1+a");
	}
	
	@Test
	public void testReturn04() throws Exception
	{
		testReturn("return a>=42.23");
	}
	
}
