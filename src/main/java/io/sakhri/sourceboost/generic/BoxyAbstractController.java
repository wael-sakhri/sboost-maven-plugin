package io.sakhri.sourceboost.generic;

import javax.naming.OperationNotSupportedException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BoxyAbstractController<T extends BoxyModel> extends ApiController {

	@RequestMapping(method = RequestMethod.GET, value = GET_ALL)
	public ResponseEntity<ResponseData> getAll() throws OperationNotSupportedException {

		ResponseData msg = getFacade().getAll();
		return new ResponseEntity<ResponseData>(msg, msg.getStatus());
	}

	@RequestMapping(method = RequestMethod.GET, value = GET_BY_ID)
	public ResponseEntity<ResponseData> get(@PathVariable Long id) throws OperationNotSupportedException {

		ResponseData msg = getFacade().get(id);
		return new ResponseEntity<ResponseData>(msg, msg.getStatus());
	}

	@RequestMapping(method = RequestMethod.GET, value = GET_BY_CODE)
	public ResponseEntity<ResponseData> getByCode(@PathVariable String code) throws OperationNotSupportedException {

		ResponseData msg = getFacade().getByCode(code);
		return new ResponseEntity<ResponseData>(msg, msg.getStatus());
	}

	@RequestMapping(value = CREATE, method = RequestMethod.POST)
	public ResponseEntity<ResponseData> create(@RequestBody T type) throws OperationNotSupportedException {

		ResponseData msg = getFacade().create(type);
		return new ResponseEntity<ResponseData>(msg, msg.getStatus());
	}

	@RequestMapping(value = SAVE, method = RequestMethod.PUT)
	public ResponseEntity<ResponseData> update(@RequestBody T type) throws OperationNotSupportedException {

		ResponseData msg = getFacade().update(type);
		return new ResponseEntity<ResponseData>(msg, msg.getStatus());
	}

	@RequestMapping(value = DELETE, method = RequestMethod.DELETE)
	public ResponseEntity<ResponseData> delete(@PathVariable Long id) throws OperationNotSupportedException {

		ResponseData msg = getFacade().delete(id);
		return new ResponseEntity<ResponseData>(msg, msg.getStatus());
	}

	protected abstract BoxyAbstractFacade<T> getFacade() throws OperationNotSupportedException;
}
