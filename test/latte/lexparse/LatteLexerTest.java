/*
 * Created on Sep 2, 2010
 * 
 * Copyright (C) 2010, Gary Pollice, Worcester Polytechnic Institute, gpollice@cs.wpi.edu. 
 *
 * The program is provided under the terms and conditions of
 * the Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL
 * is available at http://www.eclipse.org/org/documents/epl-v10.php.
 */
package latte.lexparse;

import java.io.*;

import org.antlr.runtime.*;
import org.junit.Test;

import static junit.framework.Assert.*;


/**
 *
 * @author gpollice
 * @version Sep 2, 2010
 */
public class LatteLexerTest {
	@Test
	public void testBasicInteger() throws IOException
	{
		String text = "1";
		LatteLexer lex = makeLexer(text);
		Token token = lex.nextToken();
		assertEquals(LatteLexer.INTEGER, token.getType());
		assertEquals("1", token.getText());
	}

	private LatteLexer makeLexer(String input) throws IOException
	{
		return new LatteLexer(
				new ANTLRReaderStream(
						new StringReader(input)));
	}

}