package ru.kirill.springcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirill.springcourse.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
