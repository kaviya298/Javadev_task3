import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students; // List to store student records

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(int id, String name, int age, String course) {
        Student student = new Student(id, name, age, course);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Update an existing student's details
    public void updateStudent(int id, String name, int age, String course) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            System.out.println("Student details updated.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Remove a student by ID
    public void removeStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Retrieve and display student details by ID
    public void viewStudentDetails(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Helper method to find a student by ID
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Main menu to interact with the system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Details");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    system.addStudent(id, name, age, course);
                    break;

                case 2:
                    // Update student
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter new Course: ");
                    String newCourse = scanner.nextLine();
                    system.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 3:
                    // Remove student
                    System.out.print("Enter ID of student to remove: ");
                    int removeId = scanner.nextInt();
                    system.removeStudent(removeId);
                    break;

                case 4:
                    // View student details
                    System.out.print("Enter ID of student to view: ");
                    int viewId = scanner.nextInt();
                    system.viewStudentDetails(viewId);
                    break;

                case 5:
                    // View all students
                    system.viewAllStudents();
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
