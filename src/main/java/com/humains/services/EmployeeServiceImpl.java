package com.humains.services;

import com.humains.entities.Employee;
import com.humains.exceptions.ResourceNotFoundException;
import com.humains.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Page<Employee> findAllEmployees(Optional<Integer> pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(0, pageSize, Sort.by(sortBy));
        if(pageNo.isPresent()){
            paging = PageRequest.of(pageNo.get(), pageSize, Sort.by(sortBy));
        }
        return employeeRepository.findAll(paging);
    }

    @Override
    @Transactional
    public void ajouterEmployee(Employee employee) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated(timestamp);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void supprimmerEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Employee> findAllSous_jacents(short id) {
        return employeeRepository.findBySous_jacents(id);
    }

    @Override
    @Transactional
    public Employee findById(long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public Employee findEmployeeByCin(String cin) {
        return employeeRepository.findByCin(cin);
    }

    @Override
    @Transactional
    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public Employee findEmployeeByTel(String tel) {
        return employeeRepository.findByTel(tel);
    }

    @Override
    @Transactional
    public boolean findEmployeeByEmailAndPassword(String email, String password) {
        return employeeRepository.findByEmailAndPassword(email, password) != null;
    }
}
