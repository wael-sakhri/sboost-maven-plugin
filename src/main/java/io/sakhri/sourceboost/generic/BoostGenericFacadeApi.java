package io.sakhri.sourceboost.generic;

import javax.naming.OperationNotSupportedException;

import org.springframework.stereotype.Service;

import io.sakhri.sourceboost.model.BoostModel;
import io.sakhri.sourceboost.model.ResponseData;


@Service
public interface BoostGenericFacadeApi<E extends BoostModel> {

	public ResponseData getAll() throws OperationNotSupportedException;

	public ResponseData create(E element) throws OperationNotSupportedException;

	public ResponseData update(E elemen) throws OperationNotSupportedException;

	public ResponseData get(Long id) throws OperationNotSupportedException;

	public ResponseData getByCode(String code) throws OperationNotSupportedException;

	public ResponseData delete(Long id) throws OperationNotSupportedException;

}
