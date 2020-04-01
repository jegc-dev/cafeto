package com.cafeto.codechallenge.controller;

import com.cafeto.codechallenge.model.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CityController cityController;

    City city = new City(1,"Cali Pachanguero");

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cityController)
                .build();
    }

    @Test
    public void getCityById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cities/","1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(city.toString()));
    }
}