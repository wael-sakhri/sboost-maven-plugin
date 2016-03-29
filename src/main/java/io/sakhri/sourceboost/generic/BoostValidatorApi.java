package io.sakhri.sourceboost.generic;

import io.sakhri.sourceboost.exception.ValidationException;
import io.sakhri.sourceboost.type.CodeTypes.OperationCode;

public interface BoostValidatorApi<E extends BoostModel> {

	/**
	 * Test if the id is valid
	 * 
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isValidElement(Object e, OperationCode operationCode) throws ValidationException;

	/**
	 * Test if the id is valid
	 * 
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isValidId(Long id, OperationCode operationCode) throws ValidationException;

	/**
	 * Test if the code is valid
	 * 
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isValidCode(String code, Long id, OperationCode operationCode) throws ValidationException;

	/**
	 * Test if the label is valid
	 * 
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isValidLibele(String libele, OperationCode operationCode) throws ValidationException;

}
