package com.zack.example.ids.controller;

import com.zack.example.ids.security.JwtService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("dev")
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JwtService jwtService;

    @Test
    void testGetMeWhenAuthenticated() throws Exception {
        String authToken = login("admin", "password");
        mockMvc.perform(get("/users/me")
                .header("Authorization", "Bearer " + authToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("admin"));
    }

    @Test
    void testGetMeWhenNotAuthenticated() throws Exception {
        mockMvc.perform(get("/users/me")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @ParameterizedTest
    @CsvSource({
        "admin,password,200",
        "user,password,403"
    })
    void testAdminAccess(String username, String password, int expectedStatus) throws Exception {
        String authToken = login(username, password);
        mockMvc.perform(get("/users/admin")
                .header("Authorization", "Bearer " + authToken))
                .andExpect(status().is(expectedStatus));
    }

    private String login(String username, String password) throws Exception {
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);

        String response = mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);

        // Extract token from response JSON
        return response.split("\"token\":\"")[1].split("\"")[0];
    }
}
