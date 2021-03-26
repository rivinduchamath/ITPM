package lk.sliit.itpmProject.entity;

public class AddStudent implements SuperEntity{
    private int id;
    private int year;
    private String programme;
    private int semester;
    private int groupNo;
    private int subGroupNo;
    private int groupId;
    private int subGroupId;

    public AddStudent(int id, int year, int semester, String programme, int groupNo, int subGroupNo, int groupId, int subGroupId) {
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.programme = programme;
        this.groupNo = groupNo;
        this.subGroupNo = subGroupNo;
        this.groupId = groupId;
        this.subGroupId = subGroupId;
    }

    public AddStudent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public int getSubGroupNo() {
        return subGroupNo;
    }

    public void setSubGroupNo(int subGroupNo) {
        this.subGroupNo = subGroupNo;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(int subGroupId) {
        this.subGroupId = subGroupId;
    }
}
