import java.util.Scanner;
import java.sql.*;

class Employee{
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}

class EmployeeJDBC {

    private final String URL = "jdbc:postgresql://localhost:5432/PayPal-rg-assignments";
    private final String USER = "postgres";
    private final String PASSWORD = "password";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Create
    public void addEmployee(int id, String name, String department) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, department);
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // Read one
    public void getEmployee(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Employee found with details:");
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Department: " + rs.getString("department"));
            } else {
                System.out.println("Employee with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee: " + e.getMessage());
        }
    }

    // Read all
    public void getAllEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Department: " + rs.getString("department"));
            }
            if (!found) {
                System.out.println("No employees found.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
    }

    // Update
    public void updateEmployee(int id, String name, String department) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee with ID " + id + " has been updated.");
            } else {
                System.out.println("Employee with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee with ID " + id + " has been deleted.");
            } else {
                System.out.println("Employee with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args){
        EmployeeJDBC employeeOperations = new EmployeeJDBC();
        System.out.println("Welcome to Employee Management System");
        System.out.println("Use the following commands to manage employees:");
        System.out.println("0. Exit the application");
        System.out.println("1. Add an employee");
        System.out.println("2. Get employee details by ID");
        System.out.println("3. Get all employees");
        System.out.println("4. Update an employee by ID");
        System.out.println("5. Delete an employee by ID");

        Scanner sc = new Scanner(System.in);
        int command;

        while(true){
            System.out.println();
            System.out.print("Enter your command: ");
            command = sc.nextInt();
            sc.nextLine();
            if(command == 1){
                System.out.print("Enter employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter employee name: ");
                String name = sc.nextLine();
                System.out.print("Enter employee department: ");
                String department = sc.nextLine();
                employeeOperations.addEmployee(id, name, department);
            } 
            else if(command == 2){
                System.out.print("Enter employee ID to get details: ");
                int id = sc.nextInt();
                employeeOperations.getEmployee(id);
            } 
            else if(command == 3){
                employeeOperations.getAllEmployees();
            } 
            else if(command == 4){
                System.out.print("Enter employee ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new employee name: ");
                String name = sc.nextLine();
                System.out.print("Enter new employee department: ");
                String department = sc.nextLine();
                employeeOperations.updateEmployee(id, name, department);
            } 
            else if(command == 5){
                System.out.print("Enter employee ID to delete: ");
                int id = sc.nextInt();
                employeeOperations.deleteEmployee(id);
            } 
            else if(command == 0){
                System.out.println("Exiting the application.");
                break;
            } 
            else {
                System.out.println("Invalid command. Please try again.");
            }
        }
        sc.close();
        System.out.println("Thank you for using the Employee Management System!");
    }    
}
