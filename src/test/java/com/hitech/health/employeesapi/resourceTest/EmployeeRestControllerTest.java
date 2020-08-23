package com.hitech.health.employeesapi.resourceTest;

import com.hitech.health.employeesapi.resource.EmployeeController;
import com.hitech.health.employeesapi.model.Employee;
import com.hitech.health.employeesapi.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

        Employee employee01 = new Employee();
        employee01.setName("Robert");
        employee01.setEmail("robert@email.com");

        Employee employee02 = new Employee();
        employee02.setName("Jim");
        employee02.setEmail("james@email.com");

        List<Employee> allEmployees = Arrays.asList(employee01,employee02);

        given(service.listAll()).willReturn(allEmployees);

        mvc.perform(get("/employee")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is(employee02.getName())));
    }
}
