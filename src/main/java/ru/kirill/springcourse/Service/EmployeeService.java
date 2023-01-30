package ru.kirill.springcourse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirill.springcourse.model.Employee;
import ru.kirill.springcourse.repository.EmployeeRepository;

import java.util.List;

@Service
@Transactional
public class EmployeeService implements AllService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }
    @Override
    public Employee saveUser(Employee employee) {
        return employeeRepository.save(employee);
    }

}