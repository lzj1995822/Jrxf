package com.jtzh.szcj.common;

import java.io.Serializable;

public class ResultObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean result = true;
	
	private Object obj;
	
	private String message;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultObject(boolean result, Object obj, String message) {
		this.result = result;
		this.obj = obj;
		this.message = message;
	}
	public ResultObject() {

	}

	public static ResultObject of(Boolean result, Object object, String message) {
		return new ResultObject(result, object, message);
	}

}
