package com.sm.api;

import java.io.Serializable;
import java.util.List;

/**
 * Message class to be used for API response.
 *
 */
public class Message implements Serializable {

	private static final long serialVersionUID = -1L;

	private List<String> errors;
	private String msg;

	/** No-arg Constructor. */
	public Message() {
	}

	/**
	 * Constructor to populate the message.
	 *
	 * @param message
	 */
	public Message(String message) {
		this.msg = message;
	}

	/**
	 * Full argument constructor.
	 *
	 * @param msgCode
	 * @param msgDesc
	 */
	public Message(String message, List<String> errors) {
		this.msg = message;
		this.errors = errors;
	}

	/** @return the errors */
	public List<String> getErrors() {
		return this.errors;
	}

	/** @return the message */
	public String getMessage() {
		return this.msg;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.msg = message;
	}

	/**
	 * Returns string representation of Message as - 'Response Message :
	 * [msgCode,msgDesc]'
	 */
	@Override
	public String toString() {
		return "Response Message : [message=" + this.msg + ", errors=" + this.errors + "]";
	}
}
