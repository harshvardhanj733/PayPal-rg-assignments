import java.util.Scanner;
import java.util.ArrayList;

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

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}

class EmployeeCRUD{
    private ArrayList<Employee> employees;
    public EmployeeCRUD() {
        employees = new ArrayList<>();
    }

    //create
    public void addEmployee(int id, String name, String department) {
        Employee employee = new Employee(id, name, department);
        employees.add(employee);
    }

    //read
    public void getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employe found with details: ");
                System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Department: " + employee.getDepartment());
                return;
            }
        }
        System.out.println("Employee with ID " + id + " does not exist.");
    }

    public void getAllEmployees(){
        if(employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for(Employee employee : employees){
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Department: " + employee.getDepartment());
        }
    }

    //update
    public void updateEmployee(int id, String name, String department) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                System.out.println("Employee with ID " + id + " has been updated.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " does not exist.");
    }

    //delete
    public void deleteEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee with ID " + id + " has been deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " does not exist.");
    }
}

public class Main {
    public static void main(String[] args){
        EmployeeCRUD employeeOperations = new EmployeeCRUD();
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
                System.out.println("Employee added successfully.");
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
                System.out.println("Employee updated successfully.");
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
    }    
}
