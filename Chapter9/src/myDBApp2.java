import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class myDBApp2 {
    public static void main(String[] args) {
        Set<Project> projects = new HashSet<>();
        projects.add(new Project(1, "Hibernate Basic Project"));
        projects.add(new Project(2, "Hibernate Many to Many Project"));

        Employee Myemp = new Employee(7, "Hibernate freak", "Male", 1, projects);

        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(Myemp);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
