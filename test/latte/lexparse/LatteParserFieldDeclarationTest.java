/**
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class LatteParserFieldDeclarationTest extends TestCase {
	/*
	 * Tries to parser the input string as a field declaration
	 */	
	public void testFieldDeclaration(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).field_declaration().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testFieldDeclaration01() throws Exception
	{
		testFieldDeclaration("int a;");
	}
	
	@Test
	public void testFieldDeclaration02() throws Exception
	{
		testFieldDeclaration("int a[42];");
	}
	
	@Test
	public void testFieldDeclaration03() throws Exception
	{
		testFieldDeclaration("int a,b,c,d[42];");
	}
	
	@Test
	public void testFieldDeclaration04() throws Exception
	{
		testFieldDeclaration("float a,b,c[54];");
	}
	
}
