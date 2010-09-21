/**
 * @author Guy Mann 
 */
package latte.lexparse;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	/*
	 * Runs all the tests
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for latte.lexparse");
		//$JUnit-BEGIN$
		suite.addTestSuite(LatteParserLogicalOrExpressionTest.class);
		suite.addTestSuite(LatteParserAssignmentTest.class);
		suite.addTestSuite(LatteParserMethodDeclarationTest.class);
		suite.addTestSuite(LatteParserScalarFieldDeclarationTest.class);
		suite.addTestSuite(LatteParserIfTest.class);
		suite.addTestSuite(LatteParserUnaryExpressionTest.class);
		suite.addTestSuite(LatteParserVariableDeclarationTest.class);
		suite.addTestSuite(LatteParserAdditiveExpressionTest.class);
		suite.addTestSuite(LatteParserCompilationUnitTest.class);
		suite.addTestSuite(LatteParserMultiplicativeExpressionTest.class);
		suite.addTestSuite(LatteParserExponentialExpressionTest.class);
		suite.addTestSuite(LatteParserBlockTest.class);
		suite.addTestSuite(LatteParserFormalParameterListTest.class);
		suite.addTestSuite(LatteParserEqualityExpressionTest.class);
		suite.addTestSuite(LatteParserPrimaryExpresionTest.class);
		suite.addTestSuite(LatteParserMethodCallTest.class);
		suite.addTestSuite(LatteParserLogicalAndExpressionTest.class);
		suite.addTestSuite(LatteParserInputTest.class);
		suite.addTestSuite(LatteLexerTest.class);
		suite.addTestSuite(LatteParserReturnTest.class);
		suite.addTestSuite(LatteParserWhileTest.class);
		suite.addTestSuite(LatteParserArrayDeclarationTest.class);
		suite.addTestSuite(LatteParserFormalParameterTest.class);
		suite.addTestSuite(LatteParserTypeTest.class);
		suite.addTestSuite(LatteParserArgumentListTest.class);
		suite.addTestSuite(LatteParserExpressionTest.class);
		suite.addTestSuite(LatteParserFieldDeclarationTest.class);
		suite.addTestSuite(LatteParserStatementTest.class);
		suite.addTestSuite(LatteParserRelationalExpressionTest.class);
		suite.addTestSuite(LatteParserOutputTest.class);
		//$JUnit-END$
		return suite;
	}

}
