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
public class LatteParserScalarFieldDeclarationTest extends TestCase{
	
	public void testScalarField(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).scalar_field_declaration().tree.toString() + "\n-----------\n");
		
	}
	
	@Test
	public void testScalarField01() throws Exception
	{
		testScalarField("a");
	}
	
	@Test
	public void testScalarField02() throws Exception
	{
		testScalarField("afadfadf");
	}
	
	@Test
	public void testScalarField03() throws Exception
	{
		testScalarField("a23asd");
	}
	
	@Test
	public void testScalarField04() throws Exception
	{
		testScalarField("afsaf");
	}
	
}
