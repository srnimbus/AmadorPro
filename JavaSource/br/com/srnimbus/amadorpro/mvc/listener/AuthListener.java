package br.com.srnimbus.amadorpro.mvc.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthListener implements PhaseListener {

	// TODO Integrar com o JAAS.
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("verificar requisi��o posterior");

	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("chamar valida��o abstractbean");

		// chamar valida��o abstractbean
	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RESTORE_VIEW;
	}

}
