package io.sakhri.sourceboost.generic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import io.sakhri.sourceboost.exception.AbstractException;
import io.sakhri.sourceboost.exception.ValidationException;
import io.sakhri.sourceboost.type.CodeTypes.AttributeCode;
import io.sakhri.sourceboost.type.CodeTypes.OperationCode;
import io.sakhri.sourceboost.type.CodeTypes.ServiceCode;
import io.sakhri.sourceboost.type.CodeTypes.ValidatorCode;

@Service
@PropertySource("classpath:config.properties")
public class CodeGenerator implements BoxyGlobalConfig {

	public String generateErrorCode(AbstractException e) {

		if (e instanceof ValidationException) {
			return this.generateErrorCode(e.getServiceCode(), e.getOperationCode(),
					((ValidationException) e).getAttribueCode(), ((ValidationException) e).getValidatorCode());
		}

		return this.generateErrorCode(e.getServiceCode(), e.getOperationCode(), AttributeCode.UNDEFINED,
				ValidatorCode.UNDEFINED);

	}

	public String generateErrorCode(ServiceCode service, OperationCode operationCode, AttributeCode attributeCode,
			ValidatorCode validator) {
		return getCodePrefix() + "-" + service.getCode() + operationCode.getCode() + attributeCode.getCode()
				+ validator.getCode() + "-" + getCodeSuffix();
	}

	private String getCodeSuffix() {

		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd");
		return dt.format(new Date());
	}

	private String getCodePrefix() {
		return "BOXYERROR_" + VERSION_VALUE;
	}

}
