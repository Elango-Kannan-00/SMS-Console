package models;

import java.sql.Date;

public class Attendance {

    private int id;
    private int studentId;
    private Date date;
    private String status; // Present, Absent, Late, Leave

    // Constructors
    public Attendance() {}

    public Attendance(int studentId, Date date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}