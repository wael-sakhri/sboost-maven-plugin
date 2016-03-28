package io.sakhri.codegen.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.codegen.generics.CodeGenerator;
import io.sakhri.codegen.generics.ResponseData;
import io.sakhri.codegen.type.CodeTypes;
import io.sakhri.codegen.type.CodeTypes.OperationCode;
import io.sakhri.codegen.type.CodeTypes.ServiceCode;

public abstract class AbstractException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8081247904283847409L;

	private CodeGenerator generator;

	private CodeTypes.ServiceCode serviceCode;
	private CodeTypes.OperationCode operationCode;

	private String message;
	private HttpStatus status;
	private boolean warning;
	private Object target;

	{
		generator = new CodeGenerator();
	}

	public AbstractException(CodeTypes.ServiceCode serviceCode, CodeTypes.OperationCode operationCode, String message,
			HttpStatus status) {
		super();
		this.serviceCode = serviceCode;
		this.operationCode = operationCode;
		this.status = status;
		this.message = message;
	}

	public AbstractException(ServiceCode serviceCode, OperationCode operationCode, String message, HttpStatus status,
			boolean warning, Object target) {
		super();
		this.serviceCode = serviceCode;
		this.operationCode = operationCode;
		this.message = message;
		this.status = status;
		this.warning = warning;
		this.target = target;
	}

	public CodeTypes.ServiceCode getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(CodeTypes.ServiceCode serviceCode) {
		this.serviceCode = serviceCode;
	}

	public CodeTypes.OperationCode getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(CodeTypes.OperationCode operationCode) {
		this.operationCode = operationCode;
	}

	public String getErrorCode() {
		return generator.generateErrorCode(this);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public CodeGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(CodeGenerator generator) {
		this.generator = generator;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public abstract ResponseData getErrorResponse();

	@Override
	public String toString() {
		return serviceCode + " " + operationCode + " " + (warning ? "warining " : "") + message;
	}
}
