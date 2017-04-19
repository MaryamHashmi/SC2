/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mika
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class hibernateUtil {
private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
public static void createSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure();
    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
            configuration.getProperties()).build();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

}

public static SessionFactory getSessionFactory(){
	return sessionFactory;
}

}
