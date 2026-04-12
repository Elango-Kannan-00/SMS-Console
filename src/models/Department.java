package models;

public class Department {

    private int id;
    private String name;

    // Constructors
    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}