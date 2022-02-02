package com.trabalho_lp.trabalho_lp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabalho_lp.trabalho_lp.controller.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TrabalhoLpApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private ClienteController clienteController;

	@Test
	void contextLoads() {
	}

}
