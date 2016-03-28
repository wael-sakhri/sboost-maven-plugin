package io.sakhri.sourceboost.generic;

import javax.naming.OperationNotSupportedException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.sakhri.sourceboost.exception.RuntimeException;
import io.sakhri.sourceboost.exception.ValidationException;

@Service
public abstract class BoxyAbstractFacade<E extends BoxyModel>
		implements BoxyGenericFacadeApi<E> {

	@Override
	public ResponseData getAll() throws OperationNotSupportedException {

		ResponseData data = new ResponseData("SUCCESS", "", getService().getModuleName(), HttpStatus.OK);

		try {
			data.setResponseData(getService().getAll());
		} catch (ValidationException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		}

		return data;
	}

	@Override
	public ResponseData create(E element) throws OperationNotSupportedException {

		ResponseData data = new ResponseData("SUCCESS", "", getService().getModuleName(), HttpStatus.OK);

		try {
			data.setResponseData(getService().create(element));
		} catch (ValidationException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		}

		return data;
	}

	@Override
	public ResponseData update(E element) throws OperationNotSupportedException {

		ResponseData data = new ResponseData("SUCCESS", "", getService().getModuleName(), HttpStatus.OK);

		try {
			data.setResponseData(getService().save(element));
		} catch (ValidationException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public ResponseData get(Long id) throws OperationNotSupportedException {

		ResponseData data = new ResponseData("SUCCESS", "", getService().getModuleName(), HttpStatus.OK);

		try {
			data.setResponseData(getService().get(id));
		} catch (ValidationException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		}

		return data;
	}

	@Override
	public ResponseData getByCode(String code) throws OperationNotSupportedException {

		ResponseData data = new ResponseData("SUCCESS", "", getService().getModuleName(), HttpStatus.OK);

		try {
			data.setResponseData(getService().getByCode(code));
		} catch (ValidationException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		}

		return data;
	}

	@Override
	public ResponseData delete(Long id) throws OperationNotSupportedException {

		ResponseData data = new ResponseData("SUCCESS", "", getService().getModuleName(), HttpStatus.OK);

		try {
			getService().delete(id);
		} catch (ValidationException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return e.getErrorResponse();
		}

		return data;
	}

	public abstract BoxyAbstractService<E> getService() throws OperationNotSupportedException;

}
