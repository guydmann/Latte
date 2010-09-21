/**
 *
 * @author Guy Mann
 */
package latte.lexparse;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class LatteParserStatementTest extends TestCase{
	/*
	 * Tries to parser the input string as a Statement
	 */	
	public void testStatement(String input) throws RecognitionException {
		System.out.println(input + "\n");
		System.out.println(LatteParser.makeParser(input).statement().tree.toString() + "\n-----------\n");
		
	}
	
	
	@Test
	public void testAssignment01() throws Exception
	{
		testStatement("a:=23;");
	}
	
	@Test
	public void testAssignment02() throws Exception
	{
		testStatement("a[42]:=23;");
	}
	
	@Test
	public void testAssignment03() throws Exception
	{
		testStatement("a:=23+a;");
	}
	
	@Test
	public void testAssignment04() throws Exception
	{
		testStatement("a:=something;");
	}
	
	
	@Test
	public void testMethodCall00() throws Exception
	{
		testStatement("callstuff(a);");
	}
	
	
	@Test
	public void testMethodCall01() throws Exception
	{
		testStatement("callstuff(a);");
	}
	
	@Test
	public void testMethodCall02() throws Exception
	{
		testStatement("rot32.a(a,b,c,a+23.42);");
	}
	
	@Test
	public void testMethodCall03() throws Exception
	{
		testStatement("a.b.c.d.e.f.g(a,b,c,d,e,f,g);");
	}
	
	@Test
	public void testMethodCall04() throws Exception
	{
		testStatement("callstuff.rot32(input12, a, ~a,a);");
	}

	@Test
	public void testMethodCall05() throws Exception
	{
		testStatement("callstuff.rot32(a.input12(), a, ~a,a);");
	}

	@Test
	public void testMethodCall06() throws Exception
	{
		testStatement("callstuff.rot32(a.input12(), a, a.elevensees(),a);");
	}
	
	
	@Test
	public void testIf01() throws Exception
	{
		testStatement("if(a=1) {}");
	}
	
	@Test
	public void testIf02() throws Exception
	{
		testStatement("if(a) {} else {}");
	}
	
	@Test
	public void testIf03() throws Exception
	{
		testStatement("if(a=3 || a+b=42) {a:=a+b+1;} else { b:=a+b+1; }");
	}
	
	@Test
	public void testIf04() throws Exception
	{
		testStatement("if(a~=3 || a*b=-42 && a/b>=23) { if(a>2) { a:=a+1;} } else { return b^2; }");
	}
	

	@Test
	public void testWhile01() throws Exception
	{
		testStatement("while(i){}");
	}
	
	@Test
	public void testWhile02() throws Exception
	{
		testStatement("while(i>42){i:=i+2;}");
	}
	
	@Test
	public void testWhile03() throws Exception
	{
		testStatement("while(i>=12||stuff){i:=i*2;}");
	}
	
	@Test
	public void testType04() throws Exception
	{
		testStatement("while(i>=12&&-stuff||~a){i:=i*2;}");
	}
	
	
	@Test
	public void testReturn01() throws Exception
	{
		testStatement("return;");
	}
	
	@Test
	public void testReturn02() throws Exception
	{
		testStatement("return 1;");
	}
	
	@Test
	public void testReturn03() throws Exception
	{
		testStatement("return 1+a;");
	}
	
	@Test
	public void testReturn04() throws Exception
	{
		testStatement("return a>=42.23;");
	}

	@Test
	public void testBlock01() throws Exception
	{
		testStatement("{}");
	}
	
	@Test
	public void testBlock02() throws Exception
	{
		testStatement("{int a;}");
	}
	
	@Test
	public void testBlock03() throws Exception
	{
		testStatement("{int a; a:=1;}");
	}
	
	@Test
	public void testBlock04() throws Exception
	{
		testStatement("{int a,b[4]; a:=1;b[0]:=0;b[1]:=1;b[2]:=2;b[3]:=3;}");
	}
	
	
	@Test
	public void testInput01() throws Exception
	{
		testStatement("input a;");
	}
	
	@Test
	public void testInput02() throws Exception
	{
		testStatement("input cthulhu2323;");
	}
	
	@Test
	public void testInput03() throws Exception
	{
		testStatement("input a,cthulhu2323;");
	}
	
	@Test
	public void testInput04() throws Exception
	{
		testStatement("input a,cthulhu2323,b,c,d,zzzzzzzz,q,a42;");
	}
	
	@Test
	public void testOutput00() throws Exception
	{
		testStatement("print '#$\";';");
	}

	@Test
	public void testOutput00A() throws Exception
	{
		testStatement("print 'aasdasdasd';");
	}
	
	@Test
	public void testOutput00B() throws Exception
	{
		testStatement("print '';");
	}
	
	@Test
	public void testOutput01() throws Exception
	{
		testStatement("print a;");
	}
	
	@Test
	public void testOutput02() throws Exception
	{
		testStatement("print a+b,b;");
	}
	
	@Test
	public void testOutput03() throws Exception
	{
		testStatement("print a||b,c,d,e;");
	}
	
	@Test
	public void testOutput04() throws Exception
	{
		testStatement("print 1,2,g,23,23,42;");
	}
	
	@Test
	public void testOutput05() throws Exception
	{
		testStatement("print 1.546;");
	}
}