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
public class LatteParserBlockTest extends TestCase {
	
	public void testType(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).block().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testBlock01() throws Exception
	{
		testType("{}");
	}
	
	@Test
	public void testBlock02() throws Exception
	{
		testType("{int a;}");
	}
	
	@Test
	public void testBlock03() throws Exception
	{
		testType("{int a; a:=1;}");
	}
	
	@Test
	public void testBlock04() throws Exception
	{
		testType("{int a,b[4]; a:=1;b[0]:=0;b[1]:=1;b[2]:=2;b[3]:=3;}");
	}
	
}
