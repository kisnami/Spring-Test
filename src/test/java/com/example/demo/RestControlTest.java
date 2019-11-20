package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
class RestControlTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestServices services;


    /*@Test
    void add() throws Exception {
        Pojo o=new Pojo(111,"sdasdasdasdasdasdasdasda");
        String actual=new ObjectMapper().writeValueAsString(o);
        List<EmployeePOJO> e=new ArrayList<>();
        e.add(o);
        when(services.getEmployee()).thenReturn(e);
        MvcResult mvcResult= mockMvc.perform(get("/getEmployee").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String expected=mvcResult.getResponse().getContentAsString();
        assertEquals(actual,expected);
    }*/

    @Test
    public void addEmployeeTest() throws Exception {
        List<EmployeePOJO> ls = new ArrayList<>();
        ls.add(new EmployeePOJO("1", "1", "1", "1"));
        when(services.addEmployee(ls)).thenReturn(ls);
        MvcResult mvcResult = mockMvc.perform(get("/addEmployee").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(new ObjectMapper().writeValueAsString(ls), mvcResult.getResponse().getContentAsString());
    }

}