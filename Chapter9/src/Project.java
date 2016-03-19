import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
    private int ProjectID;
    private String PName;

    public Project(int ProjectID, String PName){
        super();
        this.ProjectID = ProjectID;
        this.PName = PName;
    }

    @Id
    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        this.ProjectID = projectID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String pName) {
        this.PName = pName;
    }
}
