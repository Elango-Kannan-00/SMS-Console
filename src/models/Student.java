package models;

public class Student {

    private int id;
    private String name;
    private int age;
    private String email;
    private String gender;
    private String phone;
    private int year;
    private String status;
    private Integer departmentId; // nullable

    // Constructors
    public Student() {}

    public Student(String name, int age, String email, String gender,
                   String phone, int year, String status, Integer departmentId) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.year = year;
        this.status = status;
        this.departmentId = departmentId;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", gender=" + gender
                + ", phone=" + phone + ", year=" + year + ", status=" + status + ", departmentId=" + departmentId + "]";
    }

}