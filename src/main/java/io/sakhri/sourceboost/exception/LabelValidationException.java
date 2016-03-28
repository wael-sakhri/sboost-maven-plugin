package io.sakhri.sourceboost.exception;

import org.springframework.http.HttpStatus;

import io.sakhri.codegen.type.CodeTypes.AttributeCode;
import io.sakhri.codegen.type.CodeTypes.OperationCode;
import io.sakhri.codegen.type.CodeTypes.ServiceCode;
import io.sakhri.codegen.type.CodeTypes.ValidatorCode;

public class LabelValidationException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LabelValidationException(ServiceCode serviceCode, OperationCode operationCode, ValidatorCode validatorCode,
			String message, HttpStatus status) {
		super(serviceCode, operationCode, AttributeCode.LIBELE, validatorCode, message, status);
	}
}
