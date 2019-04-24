package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.EmployeeService;


/**
 * @author Karthick Rajendran
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class EmployeeRestController {
 
 @Autowired
 private EmployeeService employeeService;
 
 public void setEmployeeService(EmployeeService employeeService) {
  this.employeeService = employeeService;
 }

 @GetMapping
 public List<User> getEmployees() {
  List<User> employees = employeeService.retrieveEmployees();
  return employees;
 }
 
 @GetMapping(path = {"/{id}"})
 public User getEmployee(@PathVariable("id") Long employeeId) {
  return employeeService.getEmployee(employeeId);
 }
 
 @PostMapping
 public void saveEmployee(@RequestBody User employee){
  System.out.println(employee.getDepartment() + ":" + employee.getName());
  employeeService.saveEmployee(employee);
  System.out.println("Employee Saved Successfully");
 }
 
 @DeleteMapping(path = {"/{id}"})
 public void deleteEmployee(@PathVariable("id") Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully");
 }
 
 @PutMapping(path = {"/{id}"})
 public void updateEmployee(@RequestBody User employee,
   @PathVariable("id") Long employeeId){
	 User emp = employeeService.getEmployee(employeeId);
  if(emp != null){
   employeeService.updateEmployee(employee);
  }
  
 }

}