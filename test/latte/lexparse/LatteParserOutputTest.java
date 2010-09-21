/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserOutputTest extends TestCase {
	/*
	 * Tries to parser the input string as an output
	 */		
	public void testOutput(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).output().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testOutput01() throws Exception
	{
		testOutput("print 'a'");
	}
	
	@Test
	public void testOutput01A() throws Exception
	{
		testOutput("print 'aasdasdasd'");
	}
	
	@Test
	public void testOutput02() throws Exception
	{
		testOutput("print a+b,b");
	}
	
	@Test
	public void testOutput03() throws Exception
	{
		testOutput("print a||b,c,d,e");
	}
	
	@Test
	public void testOutput04() throws Exception
	{
		testOutput("print 1,2,g,23,23,42");
	}
	
}
