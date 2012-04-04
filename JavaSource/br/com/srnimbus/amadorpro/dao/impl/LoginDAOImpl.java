package br.com.srnimbus.amadorpro.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.srnimbus.amadorpro.dao.ILoginDAO;
import br.com.srnimbus.amadorpro.dominio.Login;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

public class LoginDAOImpl implements ILoginDAO {

	@Override
	public void insert(Login login) throws AmadorProDAOException {
		HibernateUtil.insert(login);

	}

	@Override
	public void update(Login login) throws AmadorProDAOException {
		HibernateUtil.update(login);

	}

	@Override
	public void delete(Login login) throws AmadorProDAOException {
		HibernateUtil.delete(login);

	}

	public Login getLogin(Login login) throws AmadorProDAOException {

		Login retorno;
		Session sessao = HibernateUtil.getOpenSession();
		try {
			Transaction transacao = sessao.beginTransaction();
			Query query = sessao.createQuery("from Login where login = :login");
			query.setParameter("login", login.getLogin());
			retorno = (Login)query.uniqueResult();
			transacao.commit();
		} catch (HibernateException e) {
			throw new AmadorProDAOException(e);
		} finally {
			sessao.close();
		}

		return retorno;
	}

}
