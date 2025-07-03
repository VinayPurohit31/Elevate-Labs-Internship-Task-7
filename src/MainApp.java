
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    Employee newEmp = new Employee(0, name, age, dept, salary);
                    dao.addEmployee(newEmp);
                    break;

                case 2:
                    // View Employee by ID
                    System.out.print("Enter employee ID: ");
                    int searchId = sc.nextInt();
                    Employee emp = dao.getEmployee(searchId);
                    if (emp != null) {
                        System.out.println(emp);
                    } else {
                        System.out.println("⚠️ Employee not found.");
                    }
                    break;

                case 3:
                    // View All Employees
                    List<Employee> allEmployees = dao.getAllEmployees();
                    if (allEmployees.isEmpty()) {
                        System.out.println("⚠️ No employees in the database.");
                    } else {
                        for (Employee e : allEmployees) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    // Update Employee
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Employee existing = dao.getEmployee(updateId);
                    if (existing == null) {
                        System.out.println("⚠ Employee not found.");
                    } else {
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new department: ");
                        String newDept = sc.nextLine();
                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();

                        Employee updatedEmp = new Employee(updateId, newName, newAge, newDept, newSalary);
                        dao.updateEmployee(updatedEmp);
                    }
                    break;

                case 5:
                    // Delete Employee
                    System.out.print("Enter ID of employee to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 6:
                    System.out.println(" Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }
}
