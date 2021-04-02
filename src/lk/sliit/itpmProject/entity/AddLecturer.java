package lk.sliit.itpmProject.entity;

public class AddLecturer implements SuperEntity {
    private String id;
    private String lName;
    private String department;
    private String faculty;
    private String center;
    private String buildingNo;
    private String level;
    private String rank;

    public AddLecturer(String id, String lName, String department, String faculty, String center, String buildingNo, String level, String rank) {
        this.id = id;
        this.lName = lName;
        this.department = department;
        this.faculty = faculty;
        this.center = center;
        this.buildingNo = buildingNo;
        this.level = level;
        this.rank = rank;


    }

    public AddLecturer() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
