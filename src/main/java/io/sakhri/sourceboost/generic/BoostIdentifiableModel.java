package io.sakhri.sourceboost.generic;

/**
 * 
 * @author Wael Sakhri 
 *
 */
public interface BoostIdentifiableModel extends BoostModel {

	/**
	 * Get entity unique code
	 * 
	 * @return code
	 */
	public String getCode();
	
	/**
	 * Get entity unique code
	 * 
	 * @param code
	 */
	public void setCode(String code);
	
	/**
	 * Get entity label
	 * 
	 * @return label
	 */
	public String getLibele();

	/**
	 * Set entity label
	 * 
	 * @param libele
	 */
	public void setLibele(String libele);
	
}
