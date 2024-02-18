package home.satoru.reactiveserver.config;

import home.satoru.reactiveserver.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.hibernate.cfg.Configuration;

@org.springframework.context.annotation.Configuration
public class DatabaseInitializer {

    @Bean
    public ApplicationRunner ini(){
        return  args -> {
            // Create the SessionFactory (you need to do this only once)
            SessionFactory sessionFactory = new Configuration()
                    .configure(ClassLoader.getSystemResource("hibernate.cfg.xml")).buildSessionFactory();

//            Configuration configuration = new Configuration();
//            configuration.configure(ClassLoader.getSystemResource("hibernate.cfg.xml"));

            // Create a session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Perform database operations (create, update, delete)

            // Commit the transaction
            session.getTransaction().commit();

            // Close the session and the SessionFactory
            session.close();
            sessionFactory.close();
        };
    }
}
