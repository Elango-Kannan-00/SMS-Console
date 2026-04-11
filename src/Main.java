import dao.StudentDAO;
import models.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Course: "); String course = sc.nextLine();
                    dao.addStudent(new Student(0, name, age, email, course));
                }
                case 2 -> {
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) System.out.println("No students found.");
                    else students.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Student ID to update: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Course: "); String course = sc.nextLine();
                    dao.updateStudent(new Student(id, name, age, email, course));
                }
                case 4 -> {
                    System.out.print("Student ID to delete: "); int id = sc.nextInt(); sc.nextLine();
                    dao.deleteStudent(id);
                }
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
