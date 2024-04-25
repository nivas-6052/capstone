package com.hds.Employee.service.impl;


import com.hds.Employee.exception.ResourceNotFoundException;
import com.hds.Employee.model.Employee;
import com.hds.Employee.repository.EmployeeRepository;
import com.hds.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllDetails() {
        return employeeRepository.findAll();
    }

    public Employee createDetails(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getDetailsById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details not exist with id :" + id));
    }
}