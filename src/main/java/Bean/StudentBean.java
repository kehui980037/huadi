package Bean;

public class StudentBean {
    private int id;
    private String studentID;
    private String studentName;
    private String sex;
    private String majorName;
    private int grade;
    private String classNum;
    private int buildNumber;
    private int dormNumber;

    public StudentBean() {
    }

    public StudentBean(int id, String studentID, String studentName, String sex, String majorName, int grade, String classNum, int buildNumber, int dormNumber) {
        this.id = id;
        this.studentID = studentID;
        this.studentName = studentName;
        this.sex = sex;
        this.majorName = majorName;
        this.grade = grade;
        this.classNum = classNum;
        this.buildNumber = buildNumber;
        this.dormNumber = dormNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public int getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(int dormNumber) {
        this.dormNumber = dormNumber;
    }
}
