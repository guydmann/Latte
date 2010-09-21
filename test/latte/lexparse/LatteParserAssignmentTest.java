/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserAssignmentTest extends TestCase {
	/*
	 * Tries to parser the input string as an assignment
	 */
	public void testAssignment(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).assignment().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testAssignment01() throws Exception
	{
		testAssignment("a:=23");
	}
	
	@Test
	public void testAssignment02() throws Exception
	{
		testAssignment("a[42]:=23");
	}
	
	@Test
	public void testAssignment03() throws Exception
	{
		testAssignment("a:=23+a");
	}
	
	@Test
	public void testAssignment04() throws Exception
	{
		testAssignment("a:=something");
	}
	
	
	
	@Test
	public void testAssignment05() throws Exception
	{
		testAssignment("a:=something*foh^n+2546/23");
	}
}
