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
public class LatteParserTypeTest extends TestCase {
	
	public void testType(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).type().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testType01() throws Exception
	{
		testType("int");
	}
	
	@Test
	public void testType02() throws Exception
	{
		testType("boolean");
	}
	
	@Test
	public void testType03() throws Exception
	{
		testType("char");
	}
	
	@Test
	public void testType04() throws Exception
	{
		testType("float");
	}
	
}
