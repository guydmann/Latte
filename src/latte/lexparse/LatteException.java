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

/**
 *
 * @author gpollice
 * @version Sep 2, 2010
 */
public class LatteException extends RuntimeException {

	/**
	 * 
	 */
	public LatteException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public LatteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public LatteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LatteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}