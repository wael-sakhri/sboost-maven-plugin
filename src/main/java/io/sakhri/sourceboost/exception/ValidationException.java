package io.sakhri.sourceboost.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.codegen.generics.ResponseData;
import io.sakhri.codegen.type.CodeTypes.AttributeCode;
import io.sakhri.codegen.type.CodeTypes.OperationCode;
import io.sakhri.codegen.type.CodeTypes.ServiceCode;
import io.sakhri.codegen.type.CodeTypes.ValidatorCode;

public class ValidationException extends AbstractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ValidatorCode validatorCode;
	private AttributeCode attribueCode;

	public ValidationException(ServiceCode serviceCode, OperationCode operationCode, AttributeCode attribueCode,
			ValidatorCode validatorCode, String message, HttpStatus status) {
		super(serviceCode, operationCode, message, status);

		this.validatorCode = validatorCode;
		this.attribueCode = attribueCode;
	}

	public ValidatorCode getValidatorCode() {
		return validatorCode;
	}

	public void setValidatorCode(ValidatorCode validatorCode) {
		this.validatorCode = validatorCode;
	}

	public AttributeCode getAttribueCode() {
		return attribueCode;
	}

	public void setAttribueCode(AttributeCode attribueCode) {
		this.attribueCode = attribueCode;
	}

	@Override
	public ResponseData getErrorResponse() {

		ResponseData response = new ResponseData();

		response.setCode(getErrorCode());
		response.setStatus(getStatus());

		if (getMessage() == null || getMessage().trim().length() == 0) {
			response.setMessage(this.toString());
		} else {
			response.setMessage(getMessage());
		}

		return response;
	}

	@Override
	public String toString() {
		return super.toString() + ", validatorCode=" + validatorCode.getValue() + ", attribueCode=" + attribueCode.getValue();
	}

}
