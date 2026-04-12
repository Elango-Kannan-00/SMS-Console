import services.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        DepartmentService deptService = new DepartmentService();
        SubjectService subjectService = new SubjectService();
        MarksService marksService = new MarksService();
        AttendanceService attendanceService = new AttendanceService();
        ReportService reportService = new ReportService();

        while (true) {

            System.out.println("\n====== STUDENT MANAGEMENT SYSTEM ======");
            System.out.println("1. Student Management");
            System.out.println("2. Department Management");
            System.out.println("3. Subject Management");
            System.out.println("4. Marks Management");
            System.out.println("5. Attendance Management");
            System.out.println("6. Reports");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ================= STUDENT =================
                case 1 -> {
                    System.out.println("\n--- Student Menu ---");
                    System.out.println("1. Add Student");
                    System.out.println("2. View Students");
                    System.out.println("3. Update Student");
                    System.out.println("4. Delete Student");

                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {

                        case 1 -> {
                            System.out.print("Name: ");
                            String name = sc.nextLine();

                            System.out.print("Age: ");
                            int age = sc.nextInt(); sc.nextLine();

                            System.out.print("Email: ");
                            String email = sc.nextLine();

                            System.out.print("Course: ");
                            String course = sc.nextLine();

                            System.out.print("Department ID: ");
                            int deptId = sc.nextInt();

                            System.out.print("Section: ");
                            char section = sc.next().charAt(0);

                            System.out.print("Phone: ");
                            long phone = sc.nextLong();

                            System.out.print("Year: ");
                            int year = sc.nextInt();

                            System.out.print("Status (true/false): ");
                            boolean status = sc.nextBoolean();

                            studentService.addStudent(
                                new models.Student(0, name, age, email, course, gender, section, phone, year, status)
                            );
                        }

                        case 2 -> studentService.viewAllStudents();

                        case 3 -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt(); sc.nextLine();

                            System.out.print("Name: ");
                            String name = sc.nextLine();

                            System.out.print("Age: ");
                            int age = sc.nextInt(); sc.nextLine();

                            System.out.print("Email: ");
                            String email = sc.nextLine();

                            System.out.print("Course: ");
                            String course = sc.nextLine();

                            System.out.print("Gender: ");
                            String gender = sc.nextLine();

                            System.out.print("Section: ");
                            char section = sc.next().charAt(0);

                            System.out.print("Phone: ");
                            long phone = sc.nextLong();

                            System.out.print("Year: ");
                            int year = sc.nextInt();

                            System.out.print("Status: ");
                            boolean status = sc.nextBoolean();

                            studentService.updateStudent(
                                new models.Student(id, name, age, email, course, gender, section, phone, year, status)
                            );
                        }

                        case 4 -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            studentService.deleteStudent(id);
                        }
                    }
                }

                // ================= DEPARTMENT =================
                case 2 -> {
                    System.out.println("\n--- Department Menu ---");
                    System.out.println("1. Add Department");
                    System.out.println("2. View Departments");

                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {
                        case 1 -> {
                            System.out.print("Department Name: ");
                            String name = sc.nextLine();
                            deptService.addDepartment(name);
                        }
                        case 2 -> deptService.viewDepartments();
                    }
                }

                // ================= SUBJECT =================
                case 3 -> {
                    System.out.println("\n--- Subject Menu ---");
                    System.out.println("1. Add Subject");
                    System.out.println("2. View Subjects");

                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {
                        case 1 -> {
                            System.out.print("Subject Name: ");
                            String name = sc.nextLine();
                            subjectService.addSubject(name);
                        }
                        case 2 -> subjectService.viewSubjects();
                    }
                }

                // ================= MARKS =================
                case 4 -> {
                    System.out.println("\n--- Marks Menu ---");
                    System.out.println("1. Add Marks");
                    System.out.println("2. View Marks");
                    System.out.println("3. Update Marks");

                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1 -> {
                            System.out.print("Student ID: ");
                            int id = sc.nextInt();

                            System.out.print("Marks: ");
                            int marks = sc.nextInt();

                            marksService.addMarks(id, marks);
                        }
                        case 2 -> marksService.viewMarks();

                        case 3 -> marksService.updateMarks();
                    }
                }

                // ================= ATTENDANCE =================
                case 5 -> {
                    System.out.println("\n--- Attendance Menu ---");
                    System.out.println("1. Mark Attendance");
                    System.out.println("2. View Attendance");

                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1 -> {
                            System.out.print("Student ID: ");
                            int id = sc.nextInt();

                            System.out.print("Present (true/false): ");
                            boolean present = sc.nextBoolean();

                            attendanceService.markAttendance(id, present);
                        }
                        case 2 -> attendanceService.viewAttendance();
                    }
                }

                // ================= REPORT =================
                case 6 -> {
                    System.out.println("\n--- Reports ---");
                    System.out.println("1. Total Students");
                    System.out.println("2. Average Marks");
                    System.out.println("3. Attendance Report");

                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1 -> reportService.totalStudents();
                        case 2 -> reportService.averageMarks();
                        case 3 -> reportService.attendanceReport();
                    }
                }

                case 7 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}