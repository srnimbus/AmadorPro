package br.com.srnimbus.amadorpro.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.srnimbus.amadorpro.exception.AmadorProException;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); // documentacao
																								// desatualizada
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void insert(Object objetoHibernate) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(objetoHibernate);
		transacao.commit();
		sessao.close();
	}

	public static void update(Object objetoHibernate) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(objetoHibernate);
		transacao.commit();
		sessao.close();
	}

	public static void delete(Object objetoHibernate) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(objetoHibernate);
		transacao.commit();
		sessao.close();
	}

	public static Object load(Class<?> klazzHibernate, int id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Object retorno = null;
		try {
			retorno = sessao.load(klazzHibernate, id);
		} finally {
			// observar como fazer para o hibernate nao fechar a sessao
			// sessao.close();
		}
		return retorno;
	}

	// LAB??
	@SuppressWarnings("unchecked")
	public static List<Object> findAll(String klazzname) throws AmadorProException {
		List<Object> objects = null;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transacao = sessao.beginTransaction();
			Query query = sessao.createQuery("from " + klazzname);
			objects = query.list();
			transacao.commit();
		} catch (HibernateException e) {
			throw new AmadorProException(e);
		} finally {
			sessao.close();
		}
		return objects;
	}

	// LAB??
	public static List<Object> loadById(Class<?> klazzname, int id) throws AmadorProException {
		List<Object> objects = null;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			sessao.load(klazzname, id);
		} catch (HibernateException e) {
			throw new AmadorProException(e);
		} finally {
			// observar como fazer para o hibernate nao fechar a sessao
			// sessao.close();
		}
		return objects;
	}
}