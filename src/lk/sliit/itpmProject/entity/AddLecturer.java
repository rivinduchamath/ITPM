package lk.sliit.itpmProject.entity;

public class AddLecturer implements SuperEntity {
    private int id;
    private int  lName;
    private int department;
    private int faculty;
    private int center;
    private int buildingNo;
    private int level;
    private int rank;

    public AddLecturer(int id, int lName, int department, int faculty, int center, int buildingNo, int level, int rank) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getlName() {
        return lName;
    }

    public void setlName(int lName) {
        this.lName = lName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
