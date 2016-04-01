package io.sakhri.sourceboost.generator.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;

import io.sakhri.sourceboost.generator.scanner.Scanner;
import io.sakhri.sourceboost.generator.strategy.AngularSourceGenerator;
import io.sakhri.sourceboost.generator.strategy.ApiSourceGenerator;
import io.sakhri.sourceboost.generator.strategy.TargetStrategy;
import io.sakhri.sourceboost.type.ModelType;
import io.sakhri.sourceboost.type.Target;
import io.sakhri.sourceboosts.annotation.SourceBoost;

public class Generator {

	private static Logger logger = LoggerFactory.getLogger(Generator.class);

	private static Map<Target, TargetStrategy> targets;
	private static Map<ModelType, Set<BeanDefinition>> map;

	static {
		logger.info("Initialize Target Generator strategies");
		targets = new HashMap<>();
		targets.put(Target.API, new ApiSourceGenerator());
		targets.put(Target.ANGULARJS_CLIENT, new AngularSourceGenerator());
	}

	/**
	 * 
	 */
	public void generate() {

		populateMap();

		for (BeanDefinition definition : map.get(ModelType.SIMPLE)) {

			performGeneration(definition, Scanner.getAnnotation(definition.getSource().getClass()));
		}
	}

	/**
	 * 
	 */
	private void populateMap() {
		try {
			map = Scanner.scanSourceBoostClasses();
		} catch (Exception e) {
			// Silent kill
			logger.error("Error while scanning classes");
		}
	}

	/**
	 * 
	 * @param definition
	 * @param sourceBoost
	 */
	private void performGeneration(BeanDefinition definition, SourceBoost sourceBoost) {

		for (Target target : sourceBoost.targets()) {
			logger.info("*************** Start source generation for " + definition.getBeanClassName());
			targets.get(target).generate(definition, sourceBoost);
			logger.info("*************** End source generation for " + definition.getBeanClassName());
		}
	}
}
