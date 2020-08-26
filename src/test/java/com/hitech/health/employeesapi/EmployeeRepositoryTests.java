package com.hitech.health.employeesapi;

import com.hitech.health.employeesapi.model.Employee;
import com.hitech.health.employeesapi.repository.EmployeeRepository;
import com.hitech.health.employeesapi.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByEmail_thenReturnEmployee() {

        // given
        Employee employee = new Employee();
        employee.setEmail("bia@gmail.com");
        entityManager.persist(employee);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByEmail(employee.getEmail());

        // then
        Assertions.assertEquals(employee.getEmail(), found.getEmail());
    }
}
