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
public class LatteParserIfTest extends TestCase {
	
	public void testIf(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).if_op().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testIf01() throws Exception
	{
		testIf("if(a=1) {}");
	}
	
	@Test
	public void testIf02() throws Exception
	{
		testIf("if(a) {} else {}");
	}
	
	@Test
	public void testIf03() throws Exception
	{
		testIf("if(a=3 || a+b=42) {a:=a+b+1;} else { b:=a+b+1; }");
	}
	
	@Test
	public void testIf04() throws Exception
	{
		testIf("if(a~=3 || a*b=-42 && a/b>=23) { if(a>2) { a:=a+1;} } else { return b^2; }");
	}
	
}
