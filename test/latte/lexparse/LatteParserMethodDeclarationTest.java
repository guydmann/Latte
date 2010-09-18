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
public class LatteParserMethodDeclarationTest extends TestCase {
	
	public void testType(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).method_declaration().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testMethodDeclaration01() throws Exception
	{
		testType("void a(){}");
	}
	
	@Test
	public void testMethodDeclaration02() throws Exception
	{
		testType("int rot32(){int a;}");
	}
	
	@Test
	public void testMethodDeclaration03() throws Exception
	{
		testType("int rot32(int key){int a; a:=1;}");
	}
	
	@Test
	public void testMethodDeclaration04() throws Exception
	{
		testType("int rot32(char key){int a; a:=1;}");
	}
	
	@Test
	public void testMethodDeclaration05() throws Exception
	{
		testType("char rot32(int key, char inputdata[]){int a,b[4]; a:=1;b[0]:=0;b[1]:=1;b[2]:=2;b[3]:=3;}");
	}
	
}
