package io.sakhri.sourceboost.generator.strategy;

import org.springframework.beans.factory.config.BeanDefinition;

import io.sakhri.sourceboosts.annotation.SourceBoost;

/**
 * 
 * @author Wael.Sakhri
 *
 */
public interface TargetStrategy {

	/**
	 * Generate source code for source boost models
	 */
	public void generate(BeanDefinition beans, SourceBoost sourceBoost);

}
