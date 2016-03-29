package io.sakhri.sourceboost.generic;

import java.io.Serializable;

public interface BoostModel extends Serializable{

	/**
	 * Serial version
	 */
	public static final long serialVersionUID = 1L;

	/**
	 * Get entity id
	 * 
	 * @return id
	 */
	public Long getId();

	/**
	 * Set entity id
	 * 
	 * @param id
	 */
	public void setId(Long id);

}
