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
public class LatteParserVariableDeclarationTest extends TestCase {
	
	public void testVariableDeclaration(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).variable_declaration().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testVariableDeclaration01() throws Exception
	{
		testVariableDeclaration("int a;");
	}
	
	@Test
	public void testVariableDeclaration02() throws Exception
	{
		testVariableDeclaration("int a[42];");
	}
	
	@Test
	public void testVariableDeclaration03() throws Exception
	{
		testVariableDeclaration("int a,b,c,d[42];");
	}
	
	@Test
	public void testVariableDeclaration04() throws Exception
	{
		testVariableDeclaration("float a,b,c[54];");
	}
	
}
