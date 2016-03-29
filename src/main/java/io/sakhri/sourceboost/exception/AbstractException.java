package io.sakhri.sourceboost.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.sourceboost.generic.BoostCodeGenerator;
import io.sakhri.sourceboost.model.ResponseData;
import io.sakhri.sourceboost.type.CodeTypes;
import io.sakhri.sourceboost.type.CodeTypes.OperationCode;

public abstract class AbstractException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8081247904283847409L;

	private BoostCodeGenerator generator;

	private String serviceCode;
	private OperationCode operationCode;

	private String message;
	private HttpStatus status;
	private boolean warning;
	private Object target;

	{
		generator = new BoostCodeGenerator();
	}

	public AbstractException(String serviceCode, CodeTypes.OperationCode operationCode, String message,
			HttpStatus status) {
		super();
		this.serviceCode = serviceCode;
		this.operationCode = operationCode;
		this.status = status;
		this.message = message;
	}

	public AbstractException(String serviceCode, OperationCode operationCode, String message, HttpStatus status,
			boolean warning, Object target) {
		super();
		this.serviceCode = serviceCode;
		this.operationCode = operationCode;
		this.message = message;
		this.status = status;
		this.warning = warning;
		this.target = target;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
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

	public BoostCodeGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(BoostCodeGenerator generator) {
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
