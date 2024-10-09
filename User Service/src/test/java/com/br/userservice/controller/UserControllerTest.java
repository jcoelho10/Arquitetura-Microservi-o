package com.br.userservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.UserServiceApplication;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;
    
    @MockBean
    private UserService userService;
    
    
    @Test
    public void testGetUsers() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User((long) 1, "John Doe"));
        users.add(new User((long) 2, "Jane Doe"));
        
        when(userService.findAllUsers()).thenReturn(users);

        mockMvc.perform(get("/users"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name").value("John Doe"))
               .andExpect(jsonPath("$[1].name").value("Jane Doe"));
    }
    
    
    @Test
    public void testGetDados() throws Exception {
        String url = "http://exemplo.com/api/dados";
        String expectedResponse = "Resposta Mockada";

        when(restTemplate.getForEntity(url, String.class)).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        mockMvc.perform(get("/users/dados"))
               .andExpect(status().isOk())
               .andExpect((ResultMatcher) content().string(expectedResponse));
    }
}

