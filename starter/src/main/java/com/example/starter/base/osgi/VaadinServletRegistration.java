package com.example.starter.base.osgi;

import java.util.Hashtable;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.vaadin.flow.di.ResourceProvider;
import com.vaadin.flow.server.InitParameters;
import com.vaadin.flow.server.VaadinServlet;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.http.NamespaceException;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

/**
 * Register a VaadinServlet via HTTP Whiteboard specification
 */
@Component(immediate = true)
public class VaadinServletRegistration {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	ResourceProvider pr;

	private static final String INIT_PARAMETER_PREFIX = "servlet.init.";

	/**
	 * This class is a workaround for #4367. This will be removed after the issue is
	 * fixed.
	 */
	private static class FixedVaadinServlet extends VaadinServlet {

		@Override
		public void init(ServletConfig servletConfig) throws ServletException {

			super.init(servletConfig);

			getService().setClassLoader(getClass().getClassLoader());
		}

	}

	@Activate
	void activate(BundleContext ctx) throws NamespaceException {

		Hashtable<String, Object> properties = new Hashtable<>();
		properties.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_ASYNC_SUPPORTED, true);
		properties.put(INIT_PARAMETER_PREFIX + InitParameters.SERVLET_PARAMETER_COMPATIBILITY_MODE,
				Boolean.FALSE.toString());
		properties.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN, "/*");
		ctx.registerService(Servlet.class, new FixedVaadinServlet(), properties);
	}

}
