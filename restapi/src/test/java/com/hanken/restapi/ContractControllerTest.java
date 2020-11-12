package com.hanken.restapi;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void myStatus() throws Exception {
        // Note: The testscenarios should obviously be more plentyful and more realistic.
        Contract contract = new Contract();
        mvc.perform(MockMvcRequestBuilders.post("/createContract", contract)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo("{avtalenummer:5, status: \"avtale sendt\"}")));
    }
}
