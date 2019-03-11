/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.exception;

/**
 *
 * @author Arman
 */
public class UserBlockedException extends Exception {

	/**
	 * Creates User object without error description
	 */
	public UserBlockedException() {
	}

	/**
	 * Creates User object with error description
	 */
	public UserBlockedException(String message) {
		super(message);
	}

}
