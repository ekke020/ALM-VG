package com.alm.controllers;

import com.alm.services.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MathService mathService;

    @BeforeEach
    void init() {
        when(mathService.add(anyInt(), anyInt())).thenReturn(0);
        when(mathService.subtract(anyInt(), anyInt())).thenReturn(0);
    }

    @Test
    void additionReturns200Ok() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/math/add"))
                .andExpect(status().isOk());

    }

    @Test
    void subtractionReturns200Ok() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/math/sub"))
                .andExpect(status().isOk());
    }

}