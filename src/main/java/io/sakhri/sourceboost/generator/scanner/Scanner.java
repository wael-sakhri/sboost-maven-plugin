package io.sakhri.sourceboost.generator.scanner;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import io.sakhri.sourceboost.model.BoostIdentifiableModel;
import io.sakhri.sourceboost.model.BoostModel;
import io.sakhri.sourceboost.type.ModelType;
import io.sakhri.sourceboosts.annotation.SourceBoost;

/**
 * 
 * @author Wael.Sakhri
 *
 */
public class Scanner {

	private final static Map<ModelType, Set<BeanDefinition>> classes;
	private final static Set<BeanDefinition> simple;
	private final static Set<BeanDefinition> identifiable;

	static {
		classes = new HashMap<>();
		simple = new HashSet<>();
		identifiable = new HashSet<>();
	}

	/**
	 * 
	 * @return
	 */
	public static Map<ModelType, Set<BeanDefinition>> scanSourceBoostClasses() {

		for (BeanDefinition bean : getSourceBoostClasses()) {
			if (bean.getSource() instanceof BoostModel) {
				simple.add(bean);
			}
			if (bean.getSource() instanceof BoostIdentifiableModel) {
				identifiable.add(bean);
			}
		}

		classes.put(ModelType.SIMPLE, simple);
		classes.put(ModelType.IDENTIFIABLE, identifiable);

		return classes;
	}

	/**
	 * Get the SourceBoost annotation from the given class
	 * 
	 * @param Class<?>
	 * @return SourceBoost annotation
	 * @throws IllegalStateException
	 */
	public static SourceBoost getAnnotation(Class<?> boostClass) throws IllegalStateException {

		if (boostClass.isAnnotationPresent(SourceBoost.class)) {
			Annotation annotation = boostClass.getAnnotation(SourceBoost.class);
			return (SourceBoost) annotation;
		}

		throw new IllegalStateException();

	}

	/**
	 * 
	 * @return
	 */
	private static Set<BeanDefinition> getSourceBoostClasses() {

		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

		scanner.addIncludeFilter(new AnnotationTypeFilter(SourceBoost.class));

		return scanner.findCandidateComponents("com.example");
	}

}
