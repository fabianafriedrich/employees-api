package com.hitech.health.employeesapi;
import com.hitech.health.employeesapi.model.Employee;
import com.hitech.health.employeesapi.repository.EmployeeRepository;
import com.hitech.health.employeesapi.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceTests {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee employee = new Employee();
        employee.setEmail("test@email.com");

        Mockito.when(employeeRepository.findByEmail(employee.getEmail()))
                .thenReturn(employee);
    }

    @Test
    public void whenValidEmail_thenEmployeeShouldBeFound() {
        String email = "test@email.com";
        Employee found = employeeService.findByEmail(email);

        Assertions.assertEquals(email, found.getEmail());
    }
}
