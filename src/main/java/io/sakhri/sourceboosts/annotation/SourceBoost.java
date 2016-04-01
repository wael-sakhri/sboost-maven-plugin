package io.sakhri.sourceboosts.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface SourceBoost {

	io.sakhri.sourceboost.type.Target[] targets() default io.sakhri.sourceboost.type.Target.API;

	String sourcePackage();

	String repositorySourcePackage();

	String serviceSourcePackage();

	String facadeSourcePackage();

	String controllerSourcePackage();

}
