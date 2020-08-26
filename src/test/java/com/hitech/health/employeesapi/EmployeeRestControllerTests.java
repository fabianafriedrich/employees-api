//package com.hitech.health.employeesapi;
//
//import com.hitech.health.employeesapi.config.SecurityConfigurer;
//import com.hitech.health.employeesapi.resource.EmployeeController;
//import com.hitech.health.employeesapi.model.Employee;
//import com.hitech.health.employeesapi.service.EmployeeService;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = EmployeeController.class, excludeAutoConfiguration = {SecurityConfigurer.class})
//public class EmployeeRestControllerTests implements WebMvcConfigurer {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private EmployeeService service;
//
//    @Test
//    public void givenEmployees_whenGetEmployees_noAuth_thenReturn401Error() throws Exception {
//
//        Employee employee01 = new Employee();
//        employee01.setName("Mike");
//        employee01.setEmail("mike@email.com");
//
//        List<Employee> allEmployees = Arrays.asList(employee01);
//
//        given(service.listAll()).willReturn(allEmployees);
//
//        mvc.perform(get("/employee").header("Authorization", employee01.getToken())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(employee01.getName())));
//    }
//}
