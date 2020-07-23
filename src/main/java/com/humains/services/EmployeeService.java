package com.humains.services;

import com.humains.entities.Employee;
import com.humains.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

     Page<Employee> findAllEmployees(Optional<Integer> pageNo, Integer pageSize, String sortBy);
     void ajouterEmployee(Employee employee);
     void supprimmerEmployee(long id);
     List<Employee> findAllSous_jacents(short id);
     Employee findById(long id) throws ResourceNotFoundException;
     Employee findEmployeeByCin(String cin);
     Employee findEmployeeByEmail(String email);
     Employee findEmployeeByTel(String tel);
     boolean findEmployeeByEmailAndPassword(String email, String password);

}
