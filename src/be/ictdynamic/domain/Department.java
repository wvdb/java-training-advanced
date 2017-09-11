package be.ictdynamic.domain;

/**
 * Created by wvdbrand on 6/09/2017.
 */
public class Department extends DatabaseEntity {
    private String departmentName;
    private String departmentAddress;

    public Department(Integer id, String departmentName, String departmentAddress) {
        super(id);
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
    }

    private Department(DepartmentBuilder builder) {
        this.departmentName = builder.nestedDepartmentName;
        this.departmentAddress = builder.nestedDepartmentAddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public static class DepartmentBuilder {
        private String nestedDepartmentName;
        private String nestedDepartmentAddress;

        public DepartmentBuilder departmentName(String departmentName) {
            this.nestedDepartmentName = departmentName;
            return this;
        }

        public DepartmentBuilder departmentAddress(String nestedDepartmentAddress) {
            this.nestedDepartmentAddress = nestedDepartmentAddress;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
