/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserWhileTest extends TestCase {
	/*
	 * Tries to parser the input string as a while
	 */	
	public void testWhile(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).while_op().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testWhile01() throws Exception
	{
		testWhile("while(i){}");
	}
	
	@Test
	public void testWhile02() throws Exception
	{
		testWhile("while(i>42){i:=i+2;}");
	}
	
	@Test
	public void testWhile03() throws Exception
	{
		testWhile("while(i>=12||stuff){i:=i*2;}");
	}
	
	@Test
	public void testType04() throws Exception
	{
		testWhile("while(i>=12&&-stuff||~a){i:=i*2;}");
	}
	
	@Test
	public void testType05() throws Exception
	{
		testWhile("while(i>=12&&-stuff||~a){i:=i*2;}");
		
	}
	
}
