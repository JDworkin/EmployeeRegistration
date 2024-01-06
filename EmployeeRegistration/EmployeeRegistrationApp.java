// EmployeeRegistrationApp.java
import java.util.List;
import java.util.Scanner;

// The main part of a simple employee registration program.
public class EmployeeRegistrationApp {
    private static final String CSV_FILE_NAME = "employees.csv";
    private static Scanner scanner = new Scanner(System.in);

    // The main method where the program starts.
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            performAction(choice);
        }
    }

    // Show the options for the user to choose from.
    private static void displayMenu() {
        System.out.println("\nEmployee Registration System");
        System.out.println("1. Register a new employee");
        System.out.println("2. View all registered employees");
        System.out.println("3. Exit the program");
        System.out.print("Enter your choice: ");
    }

    // Get the user's choice from the console.
    private static int getUserChoice() {
        return scanner.nextInt();
    }

    // Perform an action based on the user's choice.
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
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    // Register a new employee by taking information from the user.
    private static void registerEmployee() {
        System.out.println("\nRegister a New Employee");

        Employee employee = new Employee();

        System.out.print("Enter First Name: ");
        employee.setFirstName(scanner.next());

        System.out.print("Enter Last Name: ");
        employee.setLastName(scanner.next());

        System.out.print("Enter Age: ");
        employee.setAge(scanner.nextInt());

        System.out.print("Enter Department: ");
        employee.setDepartment(scanner.next());

        // Save the employee's details to a file.
        employee.saveToCSV(CSV_FILE_NAME);

        System.out.println("Employee registered successfully!");
    }

    // Show details of all registered employees.
    private static void viewAllEmployees() {
        System.out.println("\nAll Registered Employees");

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
