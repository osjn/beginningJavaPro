import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class myDBApp3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "D:/apps/objectdb-2.6.7_05/db/employeeadm.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Set<Project> projects = new HashSet<>();
        projects.add(new Project(1, "Basic ObjectDB Project"));
        projects.add(new Project(2, "Advanced ObjectDB Project"));
        Employee Myemp = new Employee(1, "Object DB freak", "Male", 1, projects);
        em.persist(Myemp);
        em.getTransaction().commit();
        Query ql = em.createQuery("SELECT COUNT(emp) FROM Employee emp");
        System.out.println("Total Employees: " + ql.getSingleResult());
        TypedQuery<Project> query =
                em.createQuery("SELECT proj FROM Project proj", Project.class);
        List<Project> results = query.getResultList();
        for (Project proj : results) {
            System.out.print(proj.getProjectID());
            System.out.print(" ");
            System.out.println(proj.getPName());
        }
        em.close();
        emf.close();
    }
}
