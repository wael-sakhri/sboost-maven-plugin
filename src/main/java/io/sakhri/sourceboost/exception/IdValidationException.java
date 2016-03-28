package io.sakhri.sourceboost.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.sourceboost.type.CodeTypes.AttributeCode;
import io.sakhri.sourceboost.type.CodeTypes.OperationCode;
import io.sakhri.sourceboost.type.CodeTypes.ServiceCode;
import io.sakhri.sourceboost.type.CodeTypes.ValidatorCode;

public class IdValidationException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdValidationException(ServiceCode serviceCode, OperationCode operationCode, ValidatorCode validatorCode,
			String message, HttpStatus status) {
		super(serviceCode, operationCode, AttributeCode.ID, validatorCode, message, status);
		// TODO Auto-generated constructor stub
	}

}
