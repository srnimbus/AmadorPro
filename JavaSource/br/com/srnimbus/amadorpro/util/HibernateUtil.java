package br.com.srnimbus.amadorpro.util;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory(); // documentacao desatualizada
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

	public static  Object load(Class<?> klazzHibernate, int id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Hibernate.initialize(klazzHibernate);
		Object retorno = sessao.load(klazzHibernate, id);
		sessao.close();
		return retorno;
	}
}