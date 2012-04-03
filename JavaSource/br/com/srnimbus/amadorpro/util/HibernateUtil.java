package br.com.srnimbus.amadorpro.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			// documentacao desatualizada
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getOpenSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	public static void insert(Object objetoHibernate) throws AmadorProDAOException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(objetoHibernate);
		transacao.commit();
		sessao.close();
	}

	public static void update(Object objetoHibernate) throws AmadorProDAOException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(objetoHibernate);
		transacao.commit();
		sessao.close();
	}

	public static void delete(Object objetoHibernate) throws AmadorProDAOException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(objetoHibernate);
		transacao.commit();
		sessao.close();
	}

	// LAB??
	@SuppressWarnings("unchecked")
	public static List<Object> findAll(String klazzname) throws AmadorProDAOException {
		List<Object> objects = null;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transacao = sessao.beginTransaction();
			Query query = sessao.createQuery("from " + klazzname);
			objects = query.list();
			transacao.commit();
		} catch (HibernateException e) {
			throw new AmadorProDAOException(e);
		} finally {
			sessao.close();
		}
		return objects;
	}

	// LAB??
	public static List<Object> loadById(Class<?> klazzname, int id) throws AmadorProDAOException {
		List<Object> objects = null;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			sessao.load(klazzname, id);
		} catch (HibernateException e) {
			throw new AmadorProDAOException(e);
		} finally {
			// observar como fazer para o hibernate nao fechar a sessao
			// sessao.close();
		}
		return objects;
	}

	public static void testDataSource() throws NamingException, SQLException {
		final String sql = "select 1";
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:jboss/datasources/AmadorProDS");
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Query '" + sql + "' returned " + rs.getString(1));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		}
	}
}