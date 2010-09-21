/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserArrayDeclarationTest extends TestCase {
	/*
	 * Tries to parser the input string as an array declaration
	 */
	public void testArrayDeclaration(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).array_declaration().tree.toString() + "\n-----------\n");
		
	}
	
	
	@Test
	public void testArrayDeclaration01() throws Exception
	{
		testArrayDeclaration("a[1]");
	}
	
	@Test
	public void testArrayDeclaration02() throws Exception
	{
		testArrayDeclaration("a[0]");
	}
	
	@Test
	public void testArrayDeclaration03() throws Exception
	{
		testArrayDeclaration("a23asd[161]");
	}
	
	@Test
	public void testArrayDeclaration04() throws Exception
	{
		testArrayDeclaration("afsaf[0]");
	}

	
	@Test
	public void testArrayDeclaration05() throws Exception
	{
		testArrayDeclaration("afsaf[a+4]");
	}
	
	
	@Test
	public void testArrayDeclaration06() throws Exception
	{
		testArrayDeclaration("t1290s[2^z+n]");
	}
	
	@Test
	public void testArrayDeclaration07() throws Exception
	{
		testArrayDeclaration("t1290s[2^(z+n)]");
	}
}
