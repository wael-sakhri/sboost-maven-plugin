package io.sakhri.sourceboost.generator.apichain;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;

import io.sakhri.sourceboost.type.SourceType;
import io.sakhri.sourceboosts.annotation.SourceBoost;

public abstract class AbstractHandler {

	private AbstractHandler successor;
	protected Request request;
	protected Class<?> modelClass;
	protected SourceType sourceType;

	public AbstractHandler(AbstractHandler successor, Request request) {

		super();

		if (request == null || request.getDefinition() == null || request.getSourceBoost() == null) {
			throw new IllegalArgumentException();
		}

		this.successor = successor;
		this.request = request;
		modelClass = request.getDefinition().getSource().getClass();

	}

	/**
	 * Set the next step handler
	 * 
	 * @param successor
	 */
	public void setSuccessor(AbstractHandler successor) {
		this.successor = successor;
	}

	/**
	 * Process the next step
	 * 
	 * @param sourceBoost
	 * @param jclass
	 */
	public void next() {
		this.successor.process();
	}

	/**
	 * Get the SourceBoost annotation from the generation request
	 * 
	 * @return SourceBoost annotation
	 */
	public SourceBoost getAnnotation() {
		return this.request.getSourceBoost();
	}

	/**
	 * Process the object
	 */
	public abstract void process();

	/**
	 * 
	 * @param model
	 * @param ref
	 * @param gen
	 */
	public void addExtends(Class<?> ref, Class<?> gen) {

		JCodeModel jCodeModel = new JCodeModel();

		JClass jGenClass = jCodeModel.ref(gen);
		JClass jRefClass = jCodeModel.ref(ref).narrow(jGenClass);

		request.getJModel(sourceType)._extends(jRefClass);
	}

	public void initJClass() {
		try {
			request.setJModel(new JCodeModel()._class(getFullClassName()), SourceType.REPOSITORY);
		} catch (JClassAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFullClassName() {

		switch (sourceType) {
		case REPOSITORY:

			break;
		case SERVICE:

			break;
		case FACADE:

			break;
		case CONTROLLER:

			break;
		default:
			break;
		}

		return null;
	}

	private String getSourcePackageName() {
		return null;
	}
}
