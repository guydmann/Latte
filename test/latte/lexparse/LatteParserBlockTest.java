/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserBlockTest extends TestCase {
	/*
	 * Tries to parser the input string as a block
	 */
	public void testBlock(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).block().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testBlock01() throws Exception
	{
		testBlock("{}");
	}
	
	@Test
	public void testBlock02() throws Exception
	{
		testBlock("{int a;}");
	}
	
	@Test
	public void testBlock03() throws Exception
	{
		testBlock("{int a; a:=1;}");
	}
	
	@Test
	public void testBlock04() throws Exception
	{
		testBlock("{int a,b[4]; a:=1;b[0]:=0;b[1]:=1;b[2]:=2;b[3]:=3;}");
	}
	@Test
	public void testBlock05() throws Exception
	{
		testBlock("{\n\n\njkh:=1;\n\n\n}\n\n");
	}
	
}
