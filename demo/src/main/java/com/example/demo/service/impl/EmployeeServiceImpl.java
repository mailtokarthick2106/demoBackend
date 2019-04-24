package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

/**
 * @author Karthick Rajendran
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

 @Autowired
 private EmployeeRepository employeeRepository;

 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
  this.employeeRepository = employeeRepository;
 }
 
 public List<User> retrieveEmployees() {
  List<User> employees = employeeRepository.findAll();
  return employees;
 }
 
 public User getEmployee(Long employeeId) {
  Optional<User> optEmp = employeeRepository.findById(employeeId);
  return optEmp.get();
 }
 
 public void saveEmployee(User employee){
  employeeRepository.save(employee);
 }
 
 public void deleteEmployee(Long employeeId){
  employeeRepository.deleteById(employeeId);
 }
 
 public void updateEmployee(User employee) {
  employeeRepository.save(employee);
 }
}
