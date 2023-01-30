package ru.kirill.springcourse.Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kirill.springcourse.model.Employee;
import ru.kirill.springcourse.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;


    @Test
    public void testFindAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setFirstName("Kirill");
        employee.setId(1L);
        employee.setLastName("Karnauhov");

        Employee employee1 = new Employee();
        employee1.setFirstName("Leha");
        employee1.setId(2L);
        employee1.setLastName("Loy");

        employeeList.add(employee);
        employeeList.add(employee1);

        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actualFindAllResult = employeeService.findAll();
        assertSame(employeeList, actualFindAllResult);
        assertFalse(actualFindAllResult.isEmpty());
        verify(employeeRepository).findAll();
    }


    @Test
    public void testSaveUser() {
        Employee employee = new Employee();
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        when(employeeRepository.save(any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Jane");
        employee1.setId(123L);
        employee1.setLastName("Doe");
        assertSame(employee, employeeService.saveUser(employee1));
        verify(employeeRepository).save(any());
    }
}

