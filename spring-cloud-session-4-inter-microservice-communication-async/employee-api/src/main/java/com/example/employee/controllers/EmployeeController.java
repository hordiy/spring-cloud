package com.example.employee.controllers;

import com.example.employee.models.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    private final Log logger = LogFactory.getLog(EmployeeController.class);

    // Initialize database
    private static final Map<Integer, Employee> dataBase = new HashMap<>();

    static {
        dataBase.put(100, new Employee(100, "Alex"));
        dataBase.put(101, new Employee(101, "Tom"));
    }


    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        logger.info(String.format("Getting Details of Employee with id %s", employeeId));
        return dataBase.get(employeeId);
    }

}
