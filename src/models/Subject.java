package models;

public class Subject {

    private int id;
    private String name;
    private int departmentId;

    // Constructors
    public Subject() {}

    public Subject(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
}