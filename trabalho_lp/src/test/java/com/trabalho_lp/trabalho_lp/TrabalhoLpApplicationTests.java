package com.trabalho_lp.trabalho_lp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabalho_lp.trabalho_lp.controller.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrabalhoLpApplicationTests {


	@Autowired
	private ObjectMapper objectMapper;

	private ClienteController clienteController;

	@Test
	void contextLoads() {
	}

}
