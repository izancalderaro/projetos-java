package br.ifnc.ws.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure();
			
			StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());

			sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
