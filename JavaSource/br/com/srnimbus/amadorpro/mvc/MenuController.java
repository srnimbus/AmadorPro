package br.com.srnimbus.amadorpro.mvc;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import br.com.srnimbus.amadorpro.jaas.Constants;
import br.com.srnimbus.amadorpro.to.LoginTO;
import br.com.srnimbus.amadorpro.to.MenuTO;
import br.com.srnimbus.amadorpro.to.PerfilTO;
import br.com.srnimbus.amadorpro.to.SubMenuTO;
import br.com.srnimbus.amadorpro.util.FacesUtil;

@ManagedBean(name = "menuController")
@RequestScoped
public class MenuController {

	private MenuModel menuModel;
	private Set<MenuTO> listaMenus;

	public MenuController() {
		LoginTO loginTO = (LoginTO) FacesUtil.getSession(false).getAttribute(Constants.SESSION_USER);
		if (loginTO != null) {
			for (PerfilTO to : loginTO.getPerfisTO()) {
				getListaMenus().addAll(to.getMenusTO());
			}
		}
		generateMenu();
	}

	private void generateMenu() {
		menuModel = new DefaultMenuModel();

		for (MenuTO menu : getListaMenus()) {
			Submenu submenu = new Submenu();
			submenu.setLabel(menu.getNome());
			for (SubMenuTO to : menu.getSubMenusTO()) {
				MenuItem item = new MenuItem();
				item.setValue(to.getNome());
				item.setUrl(to.getLink());
				submenu.getChildren().add(item);
			}
			menuModel.addSubmenu(submenu);
		}

	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public Set<MenuTO> getListaMenus() {
		if (listaMenus == null) {
			listaMenus = new HashSet<MenuTO>();
		}
		return listaMenus;
	}

	public void setListaMenus(Set<MenuTO> listaMenus) {
		this.listaMenus = listaMenus;
	}

}