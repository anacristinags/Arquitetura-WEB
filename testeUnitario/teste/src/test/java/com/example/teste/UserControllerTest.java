package com.example.teste;

import com.example.teste.model.User;
import com.example.teste.service.UserService;
import com.example.teste.controller.UserController;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllUsers() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("João");
        user.setEmail("joao@mail.com");

        when(userService.findAllUsers()).thenReturn(List.of(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("João"));
    }

    @Test
    void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Maria");
        user.setEmail("maria@mail.com");

        when(userService.findUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("maria@mail.com"));
    }

    @Test
    void testCreateUser() throws Exception {
        User user = new User();
        user.setId(2L);
        user.setName("Pedro");
        user.setEmail("pedro@mail.com");

        when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pedro"));
    }
}
