package com.demo.client;

import java.util.List;
import java.util.Scanner;

import com.demo.model.Department;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServiceImpl;

public class ClientApp {
    private static Scanner sc = new Scanner(System.in);
    private static DepartmentService service = new DepartmentServiceImpl();

    public static void main(String[] args) {
        String continueChoice;

        do {
            System.out.println("***************Department Management*****************");
            System.out.println("1. Add Department");
            System.out.println("2. View Department by ID");
            System.out.println("3. View All Departments");
            System.out.println("4. Update Department by ID");
            System.out.println("5. Delete Department");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    viewDepartmentById();
                    break;
                case 3:
                    viewAllDepartments();
                    break;
                case 4:
                    updateDepartment();
                    break;
                case 5:
                    deleteDepartment();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            continueChoice = sc.nextLine().trim().toLowerCase();

        } while (continueChoice.equals("yes"));

        System.out.println("Exiting... Thank you!");
    }

    private static void addDepartment() {
        System.out.print("Enter Department ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Manager Name: ");
        String manager = sc.nextLine();

        System.out.print("Enter Number of Employees: ");
        int employees = sc.nextInt();
        sc.nextLine();

        Department dept = new Department(id, name, location, manager, employees);
        int result = service.addDepartment(dept);

        if (result > 0)
            System.out.println("Department added successfully.");
        else
            System.out.println("Failed to add department.");
    }

    private static void viewDepartmentById() {
        System.out.print("Enter Department ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Department dept = service.getDepartmentById(id);

        if (dept != null)
            System.out.println(" " + dept);
        else
            System.out.println(" Department not found.");
    }

    private static void viewAllDepartments() {
        List<Department> list = service.getAllDepartments();
        if (list.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            System.out.println("List of Departments:");
            for (Department dept : list) {
                System.out.println(dept);
            }
        }
    }

    private static void updateDepartment() {
        System.out.print("Enter Department ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Department Name: ");
        String newName = sc.nextLine();

        System.out.print("Enter New Location: ");
        String newLocation = sc.nextLine();

        int result = service.updateDepartmentById(id, newName, newLocation);
        if (result > 0)
            System.out.println("Department updated successfully.");
        else
            System.out.println("Update failed. Department ID may not exist.");
    }

    private static void deleteDepartment() {
        System.out.print("Enter Department ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        service.deleteDepartment(id);
        System.out.println("Department deleted successfully.");
    }
}
