package com.policyautomation;

import java.sql.SQLException;
import java.util.List;

public class PolicyController {
    private PolicyService policyService = new PolicyService();

    public void showAllPolicies() {
        try {
            List<Policy> policies = policyService.getAllPolicies();
            for (Policy policy : policies) {
                System.out.println("Policy ID: " + policy.getId());
                System.out.println("Policy Name: " + policy.getName());
                System.out.println("Policy Description: " + policy.getDescription());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewPolicy(String name, String description) {
        Policy policy = new Policy();
        policy.setName(name);
        policy.setDescription(description);

        try {
            policyService.addPolicy(policy);
            System.out.println("Policy added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
