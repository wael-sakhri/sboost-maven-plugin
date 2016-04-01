package io.sakhri.sourceboost.generic;

import java.util.Collection;

import org.springframework.stereotype.Service;

import io.sakhri.sourceboost.exception.RuntimeException;
import io.sakhri.sourceboost.exception.ValidationException;
import io.sakhri.sourceboost.model.BoostModel;

@Service
public interface BoostGenericServiceApi<E extends BoostModel> {

	/**
	 * Get all element from the database using T Repository
	 * 
	 * @return Collection<E>
	 * @throws ValidationException
	 * @throws RuntimeException
	 */
	public Collection<E> getAll() throws ValidationException, RuntimeException;

	/**
	 * Get element from database by ID
	 * 
	 * @param id
	 *            of the element to search for
	 * @return <E>
	 * @throws RuntimeException
	 * @throws ValidationException
	 */
	public E get(Long id) throws ValidationException, RuntimeException;

	/**
	 * Get element from database by code
	 * 
	 * @param code
	 *            of the element to search for
	 * @return <E>
	 * @throws RuntimeException
	 * @throws ValidationException
	 */
	public E getByCode(String code) throws ValidationException, RuntimeException;

	/**
	 * Delete element from database by ID
	 * 
	 * @param id
	 *            of the element to delete
	 * @throws RuntimeException
	 * @throws ValidationException
	 */
	public void delete(Long id) throws ValidationException, RuntimeException;

	/**
	 * Delete element from database by element reference
	 * 
	 * @param <E>
	 *            the element to delete
	 * @throws RuntimeException
	 * @throws ValidationException
	 */
	public void delete(E element) throws ValidationException, RuntimeException;

	/**
	 * Create new element in the database
	 * 
	 * @param <E>
	 *            the element to create
	 * @return <E> the new created element
	 * @throws RuntimeException
	 * @throws ValidationException
	 */
	public E create(E element) throws ValidationException, RuntimeException;

	/**
	 * Update element in the database
	 * 
	 * @param <E>
	 *            the element to update
	 * @return <E> the updated element
	 * @throws RuntimeException
	 * @throws ValidationException
	 */
	public E save(E element) throws ValidationException, RuntimeException;

	/**
	 * Create the initial data for the specific model
	 * 
	 */
	public void initData();

	/**
	 * Return the code of the current service
	 * 
	 * @return String
	 */
	public String getServiceCode();

	/**
	 * Return the name of the current service
	 * 
	 * @return String
	 */
	public String getServiceName();

	/**
	 * Return the global error code of the module
	 * 
	 * @return String
	 */
	public BoostJpaRepository<E> getRepository();

}
