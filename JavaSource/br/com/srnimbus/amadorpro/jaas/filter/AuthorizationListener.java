package br.com.srnimbus.amadorpro.jaas.filter;

import java.security.Principal;
import java.util.Set;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

import br.com.srnimbus.amadorpro.jaas.AdministradorPrincipal;
import br.com.srnimbus.amadorpro.jaas.LoginHelper;
import br.com.srnimbus.amadorpro.jaas.UsuarioPrincipal;
import br.com.srnimbus.amadorpro.to.MenuTO;

public class AuthorizationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// Depois de atualizar o Bean com os dados do form

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// Antes de atualizar o bean com os dados do form
		boolean authorized = false;
		HttpServletRequest req = (HttpServletRequest) event.getFacesContext().getExternalContext().getRequest();
		String uri = req.getRequestURI();

		for (Principal principal : LoginHelper.getInstance().getSubject().getPrincipals()) {
			if (principal instanceof AdministradorPrincipal) {
				AdministradorPrincipal admp = (AdministradorPrincipal) principal;
				if (isAutorized(admp.getPerfilTO().getMenusTO(), uri)) {
					authorized = true;
					break;
				}

			} else if (principal instanceof UsuarioPrincipal) {
				UsuarioPrincipal usrp = (UsuarioPrincipal) principal;
				if (isAutorized(usrp.getPerfilTO().getMenusTO(), uri)) {
					authorized = true;
					break;
				}
			}
		}

	}

	public boolean isAutorized(Set<MenuTO> menus, String URI) {
		for (MenuTO to : menus) {
			if (to.getLink().equals(URI)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
