package ru.kirill.springcourse.Service;

import ru.kirill.springcourse.model.Employee;

import java.util.List;

public interface AllService{
    public List<Employee> findAll();
    public Employee saveUser(Employee employee);
}
