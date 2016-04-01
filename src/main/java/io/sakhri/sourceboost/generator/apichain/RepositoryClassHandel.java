package io.sakhri.sourceboost.generator.apichain;

import io.sakhri.sourceboost.generic.BoostJpaRepository;
import io.sakhri.sourceboost.type.SourceType;

public class RepositoryClassHandel extends AbstractHandler {

	public RepositoryClassHandel(Request request) {

		super(new ServiceClassHandler(request), request);
		sourceType = SourceType.REPOSITORY;

	}

	@Override
	public void process() {

		addExtends(BoostJpaRepository.class, modelClass);

	}

	/**
	 * 
	 * @return
	 */
	public String getFullClassName(SourceType sourceType) {

		StringBuilder fullName = new StringBuilder();

		if (getAnnotation().repositorySourcePackage() == null
				|| getAnnotation().repositorySourcePackage().trim().isEmpty()) {
			throw new IllegalArgumentException();
		}

		fullName = fullName.append(getAnnotation().sourcePackage().toLowerCase()).append(".")
				.append(sourceType.toString().toLowerCase()).append(request.getDefinition().getBeanClassName())
				.append(camelCase(sourceType.toString()));

		return fullName.toString();
	}

	private String camelCase(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}
}
