package com.example.starter.base.osgi;

import com.vaadin.flow.di.ResourceProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.http.context.ServletContextHelper;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(service = ServletContextHelper.class, scope = ServiceScope.BUNDLE, property = {
		HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=" + VaadinServletContext.NAME,
		HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH + "=/" })
public class VaadinServletContext extends ServletContextHelper {

	@Reference // maybe not longer needed when places in flow-osgi bundle
	ResourceProvider pr;
	public static final String NAME = "vaadin";
}