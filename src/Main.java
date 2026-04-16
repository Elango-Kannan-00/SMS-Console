import models.*;
import services.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static StudentService studentService = new StudentService();
    static DepartmentService departmentService = new DepartmentService();
    static SubjectService subjectService = new SubjectService();
    static MarksService marksService = new MarksService();
    static AttendanceService attendanceService = new AttendanceService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Add Department");
            System.out.println("4. Add Subject");
            System.out.println("5. Add Marks");
            System.out.println("6. Mark Attendance");
            System.out.println("7. View Attendance %");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudent();
                        break;
                    case 3:
                        addDepartment();
                        break;
                    case 4:
                        addSubject();
                        break;
                    case 5:
                        addMarks();
                        break;
                    case 6:
                        markAttendance();
                        break;
                    case 7:
                        viewAttendancePercentage();
                        break;
                    case 8:
                        System.out.println("Exiting...Thank You!");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ================= STUDENT =================

    private static void addStudent() throws Exception {

        sc.nextLine(); // clear buffer

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        sc.nextLine();

        System.out.print("Department Name: ");
        String deptName = sc.nextLine();

        Department dept = departmentService.getDepartmentByName(deptName);

        if (dept == null) {
            System.out.println("Department not found!");
            return;
        }

        int deptId = dept.getId();

        Student s = new Student(name, age, email, gender, phone, year, "Active", deptId);
        studentService.addStudent(s);

        System.out.println("Student added successfully!");
    }

    private static void viewStudent() throws Exception {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = studentService.getStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n--- Student Details ---");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Email: " + s.getEmail());
        System.out.println("Age: " + s.getAge());
    }

    // ================= DEPARTMENT =================

    private static void addDepartment() throws Exception {

        sc.nextLine();

        System.out.print("Department Name: ");
        String name = sc.nextLine();

        Department d = new Department(name);
        departmentService.addDepartment(d);

        System.out.println("Department added!");
    }

    // ================= SUBJECT =================

    private static void addSubject() throws Exception {

        sc.nextLine();

        System.out.print("Subject Name: ");
        String name = sc.nextLine();

        System.out.print("Department ID: ");
        int deptId = sc.nextInt();

        Subject s = new Subject(name, deptId);
        subjectService.addSubject(s);

        System.out.println("Subject added!");
    }

    // ================= MARKS =================

    private static void addMarks() throws Exception {

        System.out.print("Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Subject ID: ");
        int subjectId = sc.nextInt();

        sc.nextLine();
        System.out.print("Exam Type (Midterm/Final): ");
        String examType = sc.nextLine();

        System.out.print("Marks: ");
        int marks = sc.nextInt();

        Marks m = new Marks(studentId, subjectId, examType, marks);
        marksService.addMarks(m);

        System.out.println("Marks added!");
    }

    // ================= ATTENDANCE =================

    private static void markAttendance() throws Exception {

        System.out.print("Student ID: ");
        int studentId = sc.nextInt();

        sc.nextLine();
        System.out.print("Status (Present/Absent/Late/Leave): ");
        String status = sc.nextLine();

        Date date = new Date(System.currentTimeMillis());

        Attendance a = new Attendance(studentId, date, status);
        attendanceService.markAttendance(a);

        System.out.println("Attendance marked!");
    }

    private static void viewAttendancePercentage() throws Exception {

        System.out.print("Student ID: ");
        int studentId = sc.nextInt();

        double percent = attendanceService.calculateAttendancePercentage(studentId);

        System.out.println("Attendance %: " + percent);
    }
}
