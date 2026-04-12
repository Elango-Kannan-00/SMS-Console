package models;

public class Marks {

    private int id;
    private int studentId;
    private int subjectId;
    private String examType; // Midterm, Final, Internal
    private int marks;

    // Constructors
    public Marks() {}

    public Marks(int studentId, int subjectId, String examType, int marks) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.examType = examType;
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getSubjectId() { return subjectId; }
    public void setSubjectId(int subjectId) { this.subjectId = subjectId; }

    public String getExamType() { return examType; }
    public void setExamType(String examType) { this.examType = examType; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
}