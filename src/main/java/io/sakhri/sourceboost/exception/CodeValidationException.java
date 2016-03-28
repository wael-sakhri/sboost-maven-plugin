package io.sakhri.sourceboost.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.codegen.type.CodeTypes.AttributeCode;
import io.sakhri.codegen.type.CodeTypes.OperationCode;
import io.sakhri.codegen.type.CodeTypes.ServiceCode;
import io.sakhri.codegen.type.CodeTypes.ValidatorCode;

public class CodeValidationException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeValidationException(ServiceCode serviceCode, OperationCode operationCode, ValidatorCode validatorCode,
			String message, HttpStatus status) {
		super(serviceCode, operationCode, AttributeCode.CODE, validatorCode, message, status);
	}
}
