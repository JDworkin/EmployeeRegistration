// EmployeeRegistrationApp.java
import java.util.List;
import java.util.Scanner;

public class EmployeeRegistrationApp {
    private static final String CSV_FILE_NAME = "employees.csv";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            performAction(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("\nEmployee Registration System");
        System.out.println("1. Register new employee");
        System.out.println("2. View all employees");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void performAction(int choice) {
        switch (choice) {
            case 1:
                registerEmployee();
                break;
            case 2:
                viewAllEmployees();
                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void registerEmployee() {
        System.out.println("\nRegister New Employee");

        Employee employee = new Employee();

        System.out.print("Enter First Name: ");
        employee.setFirstName(scanner.next());

        System.out.print("Enter Last Name: ");
        employee.setLastName(scanner.next());

        System.out.print("Enter Age: ");
        employee.setAge(scanner.nextInt());

        System.out.print("Enter Department: ");
        employee.setDepartment(scanner.next());

        // Save the employee to a CSV file
        employee.saveToCSV(CSV_FILE_NAME);

        System.out.println("Employee registered successfully!");
    }

    private static void viewAllEmployees() {
        System.out.println("\nAll Employees");

        List<Employee> employees = Employee.retrieveAllFromCSV(CSV_FILE_NAME);

        if (employees.isEmpty()) {
            System.out.println("No employees registered yet.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
    }
}
