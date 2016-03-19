import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class myDBApp {
    public static void main(String[] args) {
        // Create new employee and store in MySQL
        Employee Myemp = new Employee();
        Myemp.setName("Hibernate dude");
        Myemp.setGender("Male");
        Myemp.setEmployeeID(6);
        Myemp.setDNR(2);

        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(Myemp);
        session.getTransaction().commit();
        // retrieve employee data from MySQL
        Query query = session.createQuery("from Employee where EmployeeID = 6");
        List<?> list = query.list();
        Employee emp = (Employee)list.get(0);
        System.out.println(emp.getName());
        System.out.println(emp.getGender());
        System.out.println(emp.getDNR());
        session.close();
        sessionFactory.close();
    }
}
