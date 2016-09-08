package com.zjs.exception;

/**
 * Created by Ptrk on 2015/11/20.
 */
public class NotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8242831925194452039L;

	public NotFoundException(int i, String s) {
		super(s);
	}
}
