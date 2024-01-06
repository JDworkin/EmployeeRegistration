// Employee.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// This class holds information about an employee and helps save and load data.
public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String department;

    // Default way to create an employee without specific details.
    public Employee() {
    }

    // Create an employee with specific details.
    public Employee(String firstName, String lastName, int age, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
    }

    // Methods to get and set information about an employee.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Save employee details to a file in a simple format (CSV).
    public void saveToCSV(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(String.format("%s,%s,%d,%s", firstName, lastName, age, department));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read all employees' details from the file and create a list of employees.
    public static List<Employee> retrieveAllFromCSV(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String department = parts[3].trim();

                    employees.add(new Employee(firstName, lastName, age, department));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Display employee information in a readable way.
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
