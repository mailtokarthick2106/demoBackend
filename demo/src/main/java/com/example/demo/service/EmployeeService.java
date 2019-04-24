package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

/**
 * @author Karthick Rajendran
 *
 */
public interface EmployeeService {
 public List<User> retrieveEmployees();
 
 public User getEmployee(Long employeeId);
 
 public void saveEmployee(User employee);
 
 public void deleteEmployee(Long employeeId);
 
 public void updateEmployee(User employee);
}