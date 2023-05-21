package org.example.basis.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD}) //定义Annotation能够被应用于源码的哪些位置
@Retention(RetentionPolicy.RUNTIME) // 定义了Annotation的生命周期
@Inherited //使用@Inherited定义子类是否可继承父类定义的Annotation
public @interface Monitor {

	/**
	 * @return the name of the service that we will monitor(监控)
	 */
	String serviceName();

	/**
	 * @return the duration threshold in milliseconds, when a WARN message
	 *   is emitted in the log,
	 *   or -1 if such a WARN message should never be emitted
	 */
	long warningTime() default -1;

	/**
	 * @return the duration threshold in milliseconds, when a CRITICAL message
	 *   is emitted in the log,
	 *   or -1 if such a CRITICAL message should never be emitted
	 */
	long criticalTime() default -1;
}
