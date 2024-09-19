package com.policyautomation;

import java.sql.SQLException;
import java.util.List;

public class PolicyService {
    private PolicyDAO policyDAO = new PolicyDAO();

    public List<Policy> getAllPolicies() throws SQLException {
        return policyDAO.getAllPolicies();
    }

    public void addPolicy(Policy policy) throws SQLException {
        policyDAO.addPolicy(policy);
    }

    public void updatePolicy(Policy policy) throws SQLException {
        policyDAO.updatePolicy(policy);
    }

    public void deletePolicy(int policyId) throws SQLException {
        policyDAO.deletePolicy(policyId);
    }
}
