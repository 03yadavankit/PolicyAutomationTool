package com.policyautomation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PolicyController controller = new PolicyController();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Policy Automation Tool");
            System.out.println("1. View All Policies");
            System.out.println("2. Add New Policy");
            System.out.println("3. Exit");

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline after integer input

                switch (choice) {
                    case 1:
                        controller.showAllPolicies();
                        break;
                    case 2:
                        System.out.print("Enter Policy Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Policy Description: ");
                        String description = scanner.nextLine();
                        controller.addNewPolicy(name, description);
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.close();
    }
}
