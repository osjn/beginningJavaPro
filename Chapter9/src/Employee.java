import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    private int EmployeeID;
    private String Name;
    private String Gender;
    private int DNR;
    private Set<Project> projects = new HashSet<>(0);

    public  Employee() {}

    public Employee(int EmployeeID, String Name, String Gender,
                    int DNR, Set<Project> projects) {
        super();
        this.EmployeeID = EmployeeID;
        this.Name = Name;
        this.Gender = Gender;
        this.DNR = DNR;
        this.projects = projects;
    }

    @Id
    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int id) {
        this.EmployeeID = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public int getDNR() {
        return DNR;
    }

    public void setDNR(int dnr) {
        this.DNR = dnr;
    }

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "works_on", joinColumns =
            {@JoinColumn(name = "EmployeeID")},
    inverseJoinColumns = {@JoinColumn(name = "ProjectID")})

    public Set<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
