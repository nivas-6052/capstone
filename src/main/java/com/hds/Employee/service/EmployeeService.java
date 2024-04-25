package com.hds.Employee.service;

import com.hds.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllDetails();

    Employee createDetails(Employee employee);

    Employee getDetailsById(Long id);
}
