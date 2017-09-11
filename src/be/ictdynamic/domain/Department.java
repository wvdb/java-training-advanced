package be.ictdynamic.domain;

/**
 * Created by wvdbrand on 6/09/2017.
 */
public class Department extends DatabaseEntity {
  private String departmentName;

    public Department(Integer id, String departmentName) {
        super(id);
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
