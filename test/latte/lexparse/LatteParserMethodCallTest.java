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
public class LatteParserMethodCallTest extends TestCase {
	
	public void testMethodCall(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).method_call().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testMethodCall00() throws Exception
	{
		testMethodCall("callstuff(a)");
	}
	
	
	@Test
	public void testMethodCall01() throws Exception
	{
		testMethodCall("callstuff(a)");
	}
	
	@Test
	public void testMethodCall02() throws Exception
	{
		testMethodCall("rot32.a(a,b,c,a+23.42)");
	}
	
	@Test
	public void testMethodCall03() throws Exception
	{
		testMethodCall("a.b.c.d.e.f.g(a,b,c,d,e,f,g)");
	}
	
	@Test
	public void testMethodCall04() throws Exception
	{
		testMethodCall("callstuff.rot32(input12, a, ~a,a)");
	}

	@Test
	public void testMethodCall05() throws Exception
	{
		testMethodCall("callstuff.rot32(a.input12(), a, ~a,a)");
	}

	@Test
	public void testMethodCall06() throws Exception
	{
		testMethodCall("callstuff.rot32(a.input12(), a, a.elevensees(),a)");
	}
	
}
