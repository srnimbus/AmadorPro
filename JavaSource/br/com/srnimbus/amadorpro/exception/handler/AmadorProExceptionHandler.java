package br.com.srnimbus.amadorpro.exception.handler;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;

import br.com.srnimbus.amadorpro.jaas.Constants;

public class AmadorProExceptionHandler extends ExceptionHandlerWrapper {

	@Override
	public void handle() throws FacesException {

		for (ExceptionQueuedEvent event : getUnhandledExceptionQueuedEvents()) {
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) 
					event.getSource();

			Throwable t = context.getException();
			FacesContext fc = FacesContext.getCurrentInstance();
			NavigationHandler nav = fc.getApplication().getNavigationHandler();
			try {
				if (t instanceof Exception) {
					ESAPI.log().error(Logger.EVENT_FAILURE, t.getMessage());
					nav.handleNavigation(fc, null, Constants.ERROR_PAGE);
					fc.renderResponse();
				}
			} finally {
				// getWrapped().handle();

			}
		} 
	}

	private ExceptionHandler wrapped;

	public AmadorProExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

}
