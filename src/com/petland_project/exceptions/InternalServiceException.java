package com.petland_project.exceptions;

/**
 * @author NIVEDHA
 *
 */
public class InternalServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InternalServiceException(String message) {
		super(message);
	}

}
