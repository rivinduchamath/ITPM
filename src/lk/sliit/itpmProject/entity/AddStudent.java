package lk.sliit.itpmProject.entity;

public class AddStudent implements SuperEntity{
    String academicYear;
    String programme;
    String groupNumber;
    String sGroup;
    String group;


    public AddStudent(String academicYear, String programme, String groupNumber, String sGroup, String group) {
        this.academicYear = academicYear;
        this.programme = programme;
        this.groupNumber = groupNumber;
        this.sGroup = sGroup;
        this.group = group;
    }

    public AddStudent() {
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getsGroup() {
        return sGroup;
    }

    public void setsGroup(String sGroup) {
        this.sGroup = sGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "AddStudent{" +
                "academicYear='" + academicYear + '\'' +
                ", programme='" + programme + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", sGroup='" + sGroup + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}