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

	private ExceptionHandler wrapped;

	public AmadorProExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {

		for (ExceptionQueuedEvent event : getUnhandledExceptionQueuedEvents()) {
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			// obtain throwable object
			Throwable t = context.getException();
			// System.out.println(t.getStackTrace());
			FacesContext fc = FacesContext.getCurrentInstance();
			// Map<String, Object> requestMap =
			// fc.getExternalContext().getRequestMap();
			NavigationHandler nav = fc.getApplication().getNavigationHandler();

			// here you do what ever you want with exception
			try {

				if (t instanceof Exception) {
					ESAPI.log().error(Logger.EVENT_FAILURE, t.getMessage());
					nav.handleNavigation(fc, null, Constants.ERROR_PAGE);
					fc.renderResponse();

				}

				// log error
				// log.error("Serious error happened!", t);
				// redirect to error view etc....

			} finally {

			}
		}

		// getWrapped().handle();

	}
}
