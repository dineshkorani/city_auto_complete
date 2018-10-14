package com.test.models;


import java.io.Serializable;

public class GenericResponse implements Serializable {

	private static final String	SUCCESS				= "SUCCESS";
	private static final String	FAILURE				= "FAILURE";
	private String				status;
	private String				responseCode;
	private String				message;
	private Object				data;

	public GenericResponse() {
	}

	public GenericResponse(boolean success, String responseCode, String message) {
		this(success ? SUCCESS : FAILURE, responseCode, message);
	}

	public GenericResponse(String status, String responseCode, String message) {
		this.status = status;
		this.responseCode = responseCode;
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return this.status != null && this.status.equals(SUCCESS) ? true : false;
	}

	@Override
	public String toString() {
		return "GenericResponse [status=" + status + ", responseCode=" + responseCode + ", message=" + message + "]";
	}

}
