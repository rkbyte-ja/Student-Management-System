import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
///Users/harshit/IdeaProjects/Student Management System
                    System.out.print("Course: ");
                    String course = scanner.nextLine();

                    dao.addStudent(new Student(name, email, course));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(
                                s.getId() + " | " + s.getName() + " | " + s.getEmail() + " | " + s.getCourse()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int id = scanner.nextInt();
                    dao.deleteStudent(id);
                    System.out.println("Student deleted.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
