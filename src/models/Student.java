package models;

public class Student {

    private int id;
    private String name;
    private int age;
    private String email;
    private String course;
    private String gender;
    private char section;
    private long phone;
    private int year;
    private boolean status;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int id, String name, int age, String email, String course,
                   String gender, char section, long phone, int year, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
        this.gender = gender;
        this.section = section;
        this.phone = phone;
        this.year = year;
        this.status = status;
    }

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public char getSection() { return section; }
    public void setSection(char section) { this.section = section; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + course +
               " | Year: " + year + " | Sec: " + section +
               " | " + email + " | " + phone +
               " | " + (status ? "Active" : "Inactive");
    }
}