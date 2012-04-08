package br.com.srnimbus.amadorpro.mvc;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import br.com.srnimbus.amadorpro.jaas.Constants;

@ManagedBean(name = "menuController")
@RequestScoped
public class MenuController {

	private MenuModel menuModel;

	public MenuController() {
		generateMenu();
	}

	private void generateMenu() {
		menuModel = new DefaultMenuModel();

		// First submenu
		Submenu submenu = new Submenu();
		submenu.setLabel("Dados Pessoais");

		MenuItem item = new MenuItem();
		item.setValue("Atualizar Endereco");
		item.setUrl(Constants.LINK_ENDERECO);
		//item.setUpdate(Constants.UPDATE_CENTER);
		submenu.getChildren().add(item);

		menuModel.addSubmenu(submenu);

		// Second submenu
		submenu = new Submenu();
		submenu.setLabel("Peladas");

		item = new MenuItem();
		item.setValue("Agenda");
		item.setUrl(Constants.LINK_AGENDA);
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Dynamic Menuitem 2.2");
		item.setUrl("#");
		submenu.getChildren().add(item);

		menuModel.addSubmenu(submenu);
	}

	// private MenuDAO menuDAO = new MenuDAO();

	// public void geraMenu() {
	// menuModel = new DefaultMenuModel();
	// List<Menu> listaMenu = menuDAO.listaTodos();
	// for (Menu menu : listaMenu) {
	// if (menu.getMenu().getId() == 0) {
	// Submenu submenu = new Submenu();
	// submenu.setLabel(menu.getDescricao());
	// for (Menu m : menuDAO.buscaPorMenu(menu)) {
	// if (!menuDAO.verificaSubMenu(m)) {
	// MenuItem mi = new MenuItem();
	// mi.setValue(m.getDescricao());
	// mi.setIcon("imagens/" + m.getIcone());
	// submenu.getChildren().add(mi);
	// } else {
	// Submenu sm = new Submenu();
	// sm.setLabel(m.getDescricao());
	// sm = geraSubmenu(m);
	// submenu.getChildren().add(sm);
	// }
	// }
	// menuModel.addSubmenu(submenu);
	// }
	// }
	// }
	//
	// public Submenu geraSubmenu(Menu menu) {
	// Submenu submenu = new Submenu();
	// submenu.setLabel(menu.getDescricao());
	// for (Menu m : menuDAO.buscaPorMenu(menu)) {
	// if (!menuDAO.verificaSubMenu(m)) {
	// MenuItem mi = new MenuItem();
	// mi.setValue(m.getDescricao());
	// mi.setStyle("width:100px");
	// submenu.getChildren().add(mi);
	// } else {
	// submenu.getChildren().add(geraSubmenu(m));
	// }
	// }
	// return submenu;
	// }

	
	public MenuModel getMenuModel() {
		return menuModel;

	}

}