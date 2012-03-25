package br.com.srnimbus.amadorpro.mvc;

import java.util.List;

import br.com.srnimbus.amadorpro.to.AbstractTO;

public class SessionBean {

	private SessionBean() {
	}

	private static SessionBean instance;
	
	private List<AbstractTO> listaTO;

	public static SessionBean getInstance() {

		if (instance == null) {
			instance = new SessionBean();
		}
		return instance;
	}

	public static void setInstance(SessionBean instance) {
		SessionBean.instance = instance;
	}

	public List<AbstractTO> getListaTO() {
		return listaTO;
	}

	@SuppressWarnings("unchecked")
	public void setListaTO(List<?> listaTO) {
		this.listaTO = (List<AbstractTO>) listaTO;
	}
}
