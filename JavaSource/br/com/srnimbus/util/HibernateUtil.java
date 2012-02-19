package br.com.srnimbus.util;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}