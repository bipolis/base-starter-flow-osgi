package com.example.starter.base.osgi;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.vaadin.flow.server.VaadinServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletAsyncSupported;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;

/*
 * @author Stefan Bischof
 * @author Vaadin Ltd
 */
@Component(service = { Servlet.class
		// Same like @VaadinContext
		// , property = {HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT + "=(" +
		// HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME +"=vaadin")"})

})
@VaadinMode
@VaadinContext
@HttpWhiteboardServletAsyncSupported
@HttpWhiteboardServletPattern("/*")
public class FixedVaadinServlet extends VaadinServlet {



	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

		super.init(servletConfig);

		getService().setClassLoader(getClass().getClassLoader());
	}

}