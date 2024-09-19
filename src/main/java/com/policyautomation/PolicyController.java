package com.policyautomation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PolicyController {
    private PolicyService policyService = new PolicyService();
    private Scanner scanner = new Scanner(System.in);

    public void handleRequest() {
        while (true) {
            System.out.println("Policy Automation Tool");
            System.out.println("1. View All Policies");
            System.out.println("2. Add New Policy");
            System.out.println("3. Update Policy");
            System.out.println("4. Delete Policy");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        showAllPolicies();
                        break;
                    case 2:
                        addPolicy();
                        break;
                    case 3:
                        updatePolicy();
                        break;
                    case 4:
                        deletePolicy();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void showAllPolicies() throws SQLException {
        List<Policy> policies = policyService.getAllPolicies();
        if (policies.isEmpty()) {
            System.out.println("No policies found.");
        } else {
            for (Policy policy : policies) {
                System.out.println("ID: " + policy.getId() + ", Name: " + policy.getName() + ", Description: " + policy.getDescription());
            }
        }
    }

    private void addPolicy() throws SQLException {
        System.out.print("Enter Policy Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Policy Description: ");
        String description = scanner.nextLine();

        Policy policy = new Policy();
        policy.setName(name);
        policy.setDescription(description);

        policyService.addPolicy(policy);
        System.out.println("Policy added successfully.");
    }

    private void updatePolicy() throws SQLException {
        System.out.print("Enter Policy ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter New Policy Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Policy Description: ");
        String description = scanner.nextLine();

        Policy policy = new Policy();
        policy.setId(id);
        policy.setName(name);
        policy.setDescription(description);

        policyService.updatePolicy(policy);
        System.out.println("Policy updated successfully.");
    }

    private void deletePolicy() throws SQLException {
        System.out.print("Enter Policy ID to delete: ");
        int policyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        policyService.deletePolicy(policyId);
        System.out.println("Policy deleted successfully.");
    }
}
