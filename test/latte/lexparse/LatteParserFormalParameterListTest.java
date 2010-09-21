/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserFormalParameterListTest extends TestCase{
	/*
	 * Tries to parser the input string as a formal parameter list
	 */	
	public void testParserFormalList(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).formal_parameter_list().tree.toString() + "\n-----------\n");
		
	}
	
	
	@Test
	public void testParserFormalList01() throws Exception
	{
		testParserFormalList("int a");
	}
	
	@Test
	public void testParserFormalList02() throws Exception
	{
		testParserFormalList("int a, boolean b");
	}
	
	@Test
	public void testParserFormalList03() throws Exception
	{
		testParserFormalList("int a[], float c, boolean b");
	}
	
	@Test
	public void testParserFormalList04() throws Exception
	{
		testParserFormalList("int a[], float c, boolean b, char q[]");
	}
	
}
