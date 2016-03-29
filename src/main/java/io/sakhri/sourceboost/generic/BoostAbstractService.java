package io.sakhri.sourceboost.generic;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.sakhri.sourceboost.exception.CodeValidationException;
import io.sakhri.sourceboost.exception.IdValidationException;
import io.sakhri.sourceboost.exception.LabelValidationException;
import io.sakhri.sourceboost.exception.RuntimeException;
import io.sakhri.sourceboost.exception.ValidationException;
import io.sakhri.sourceboost.type.CodeTypes.AttributeCode;
import io.sakhri.sourceboost.type.CodeTypes.OperationCode;
import io.sakhri.sourceboost.type.CodeTypes.ValidatorCode;

@Service
public abstract class BoostAbstractService<E extends BoostModel>
		implements BoostGenericServiceApi<E>, BoostValidatorApi<E> {

	@Override
	public Collection<E> getAll() throws ValidationException, RuntimeException {

		List<E> elements = getRepository().findAll();

		return elements;
	}

	@Override
	public E get(Long id) throws ValidationException, RuntimeException {

		OperationCode code = OperationCode.GET_ONE;

		E element = getRepository().findOne(id);

		isValidElement(element, code);

		return element;
	}

	@Override
	public E getByCode(String c) throws ValidationException, RuntimeException {
		OperationCode code = OperationCode.GET_ONE;

		E element = getRepository().findByCode(c);

		isValidElement(element, code);

		return element;
	}

	@Override
	public void delete(Long id) throws ValidationException, RuntimeException {

		OperationCode code = OperationCode.DELETE;

		isValidId(id, code);

		try {
			getRepository().delete(id);
		} catch (Exception e) {
			throw new RuntimeException(this.getServiceCode(), OperationCode.DELETE, null,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public void delete(E element) throws ValidationException, RuntimeException {

		OperationCode code = OperationCode.DELETE;

		isValidElement(element, code);

		delete(element.getId());

	}

	@Override
	public E create(E element) throws ValidationException, RuntimeException {

		OperationCode code = OperationCode.CREATE;

		isValidElement(element, code);

		if (element instanceof BoostIdentifiableModel) {
			isValidCode(((BoostIdentifiableModel) element).getCode(), element.getId(), code);
			isValidLibele(((BoostIdentifiableModel) element).getLibele(), code);
		}

		try {
			element = getRepository().save(element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(this.getServiceCode(), OperationCode.CREATE, null,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return element;
	}

	@Override
	public E save(E element) throws ValidationException, RuntimeException {

		OperationCode code = OperationCode.SAVE;

		isValidElement(element, code);

		isValidId(element.getId(), code);

		if (element instanceof BoostIdentifiableModel) {
			isValidCode(((BoostIdentifiableModel) element).getCode(), element.getId(), code);
			isValidLibele(((BoostIdentifiableModel) element).getLibele(), code);
		}

		try {
			element = getRepository().save(element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(this.getServiceCode(), OperationCode.SAVE, null,
				HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return element;
	}

	@Override
	public boolean isValidElement(Object e, OperationCode operationCode) throws ValidationException {

		if (e == null) {
			throw new ValidationException(this.getServiceCode(), operationCode, AttributeCode.OBJECT,
					ValidatorCode.NULL_POINTER, "", HttpStatus.NOT_ACCEPTABLE);
		}

		return true;
	}

	@Override
	public boolean isValidId(Long id, OperationCode operationCode) throws ValidationException {

		if (id == null) {
			throw new IdValidationException("UNDEFINED", operationCode, ValidatorCode.NULL_POINTER, "",
					HttpStatus.NOT_ACCEPTABLE);
		}

		return true;
	}

	@Override
	public boolean isValidCode(String code, Long id, OperationCode operationCode) throws ValidationException {

		if (code == null) {
			throw new CodeValidationException(this.getServiceCode(), operationCode, ValidatorCode.NULL_POINTER, "",
					HttpStatus.NOT_ACCEPTABLE);
		}

		if (code.length() < BoostGlobalConfig.CODE_MINIMUM_LENGTH) {
			throw new CodeValidationException(this.getServiceCode(), operationCode, ValidatorCode.NOT_VALID, "",
					HttpStatus.NOT_ACCEPTABLE);
		}

		if (id != null && id > 0) {
			E e = getRepository().findByCode(code);
			if (e != null && (e.getId() != id)) {
				throw new CodeValidationException(this.getServiceCode(), operationCode, ValidatorCode.EXIST, "",
						HttpStatus.CONFLICT);
			}
		}

		return true;

	}

	@Override
	public boolean isValidLibele(String libele, OperationCode operationCode) throws ValidationException {

		if (libele == null) {

			throw new LabelValidationException(this.getServiceCode(), operationCode, ValidatorCode.NULL_POINTER, "",
					HttpStatus.NOT_ACCEPTABLE);
		}

		if (libele.length() < BoostGlobalConfig.LABEL_MINIMUM_LENGTH) {
			throw new LabelValidationException(this.getServiceCode(), operationCode, ValidatorCode.NOT_VALID, "",
					HttpStatus.NOT_ACCEPTABLE);

		}

		return true;
	}
	
	@Override
	public abstract String getServiceName();
	
	@Override
	public abstract String getServiceCode();
	
	@Override
	public void initData() {
		
	}
}
