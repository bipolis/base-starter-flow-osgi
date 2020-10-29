package com.example.starter.base.osgi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osgi.service.component.annotations.ComponentPropertyType;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;
import org.osgi.service.http.whiteboard.annotations.RequireHttpWhiteboard;

/*
 * @author Stefan Bischof
 */

@ComponentPropertyType
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@RequireHttpWhiteboard
public @interface VaadinContext {

	public static final String CONTEXT_DEFAULT_NAME = "vaadin";

	String PREFIX_ = "osgi.http.whiteboard.context.";

	String select() default "(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "="
	+ CONTEXT_DEFAULT_NAME + ")";

}