package io.sakhri.sourceboost.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.sourceboost.model.ResponseData;
import io.sakhri.sourceboost.type.CodeTypes.OperationCode;

public class RuntimeException extends AbstractException {

	private static final long serialVersionUID = 1L;

	public RuntimeException(String serviceCode, OperationCode operationCode, String message, HttpStatus status) {
		super(serviceCode, operationCode, message, status);
	}

	public RuntimeException(String serviceCode, OperationCode operationCode, String message, HttpStatus status,
			boolean warning, Object target) {
		super(serviceCode, operationCode, message, status, warning, target);
	}

	@Override
	public ResponseData getErrorResponse() {

		ResponseData response = new ResponseData();

		response.setCode(getErrorCode());
		response.setStatus(getStatus());
		response.setMessage(toString());
		response.setWarning(isWarning());
		response.setResponseData(getTarget());
		
		return response;
	}
}
