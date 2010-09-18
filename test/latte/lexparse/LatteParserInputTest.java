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
public class LatteParserInputTest extends TestCase {
	public void testInput(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).input().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testInput01() throws Exception
	{
		testInput("input a");
	}
	
	@Test
	public void testInput02() throws Exception
	{
		testInput("input cthulhu2323");
	}
	
	@Test
	public void testInput03() throws Exception
	{
		testInput("input a,cthulhu2323");
	}
	
	@Test
	public void testInput04() throws Exception
	{
		testInput("input a,cthulhu2323,b,c,d,zzzzzzzz,q,a42");
	}
	
}
