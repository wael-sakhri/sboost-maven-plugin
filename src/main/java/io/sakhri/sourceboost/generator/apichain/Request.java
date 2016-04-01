package io.sakhri.sourceboost.generator.apichain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;

import com.sun.codemodel.JDefinedClass;

import io.sakhri.sourceboost.type.SourceType;
import io.sakhri.sourceboosts.annotation.SourceBoost;

/**
 * @author Wael.Sakhri
 *
 */
public class Request {

	private BeanDefinition definition;
	private SourceBoost sourceBoost;
	private Map<SourceType, JDefinedClass> codeModels;

	public Request() {
		super();
		this.codeModels = new HashMap<>();
		this.initialize();
	}

	public void initialize() {
		codeModels.put(SourceType.REPOSITORY, null);
		codeModels.put(SourceType.SERVICE, null);
		codeModels.put(SourceType.FACADE, null);
		codeModels.put(SourceType.CONTROLLER, null);
		codeModels.put(SourceType.TEST, null);
	}

	public BeanDefinition getDefinition() {
		return definition;
	}

	public void setDefinition(BeanDefinition definition) {
		this.definition = definition;
	}

	public SourceBoost getSourceBoost() {
		return sourceBoost;
	}

	public void setSourceBoost(SourceBoost sourceBoost) {
		this.sourceBoost = sourceBoost;
	}

	public void setJModel(JDefinedClass jmodel, SourceType sourceType) {
		codeModels.put(sourceType, jmodel);
	}

	public JDefinedClass getJModel(SourceType sourceType) {
		return codeModels.get(sourceType);
	}
}
