package br.com.srnimbus.amadorpro.business.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.srnimbus.amadorpro.business.ILoginDelegate;
import br.com.srnimbus.amadorpro.dao.ILoginDAO;
import br.com.srnimbus.amadorpro.dao.impl.LoginDAOImpl;
import br.com.srnimbus.amadorpro.dominio.Login;
import br.com.srnimbus.amadorpro.dominio.Perfil;
import br.com.srnimbus.amadorpro.exception.AmadorProBusinessException;
import br.com.srnimbus.amadorpro.exception.AmadorProException;
import br.com.srnimbus.amadorpro.jaas.Constants;
import br.com.srnimbus.amadorpro.to.LoginTO;
import br.com.srnimbus.amadorpro.to.PerfilTO;
import br.com.srnimbus.amadorpro.to.PlanoPagamentoTO;
import br.com.srnimbus.amadorpro.to.UsuarioTO;
import br.com.srnimbus.amadorpro.util.FacesUtil;

public class LoginDelegateImpl implements ILoginDelegate {

	private LoginTO loginTO;

	public boolean isSenhaValida(LoginTO to) throws AmadorProException {

		ILoginDAO loginDAO = new LoginDAOImpl();
		Login model = new Login();
		boolean retorno = false;
		// copia dos objetos
		try {
			BeanUtils.copyProperties(model, to);
			Login login = loginDAO.getLogin(model);
			if (login != null) {
				setLoginTO(login);
				retorno = login.getSenha().equals(to.getSenha());
				// TODO verificar quantidade de login sem sucesso e gravar no
				// banco para evitar negacao de servico
				// TODO Captcha?
			}
			return retorno;
		} catch (IllegalAccessException e) {
			throw new AmadorProException(e);
		} catch (InvocationTargetException e) {
			throw new AmadorProException(e);
		}

	}

	private void setLoginTO(Login login) throws AmadorProException {
		loginTO = new LoginTO();
		UsuarioTO usuarioTO = new UsuarioTO();
		PlanoPagamentoTO planoPagamentoTO = new PlanoPagamentoTO();
		try {
			BeanUtils.copyProperties(loginTO, login);
			BeanUtils.copyProperties(usuarioTO, login.getUsuario());
			BeanUtils.copyProperties(planoPagamentoTO, login.getUsuario().getPlanoPagamento());
			usuarioTO.setPlanoPagamentoTO(planoPagamentoTO);
			loginTO.setUsuarioTO(usuarioTO);
			List<PerfilTO> listaPerfisTO = new ArrayList<PerfilTO>();
			for (Perfil perfil : login.getPerfis()) {
				PerfilTO to = new PerfilTO();
				BeanUtils.copyProperties(to, perfil);
				listaPerfisTO.add(to);
			}
			loginTO.setPerfisTO(listaPerfisTO);
			FacesUtil.setSessionAttribute(Constants.SESSION_USER, usuarioTO);
		} catch (IllegalAccessException e) {
			throw new AmadorProException(e);
		} catch (InvocationTargetException e) {
			throw new AmadorProException(e);
		}
	}

	public LoginTO getLoginTO() {
		return this.loginTO;
	}

	@Override
	public boolean insert(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginTO update(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginTO read(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginTO findAll(LoginTO to) throws AmadorProBusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
