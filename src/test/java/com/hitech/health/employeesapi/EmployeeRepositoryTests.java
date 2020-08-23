package com.hitech.health.employeesapi;

import com.hitech.health.employeesapi.model.Employee;
import com.hitech.health.employeesapi.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
