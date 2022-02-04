package com.trabalho_lp.trabalho_lp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void cadCliente() throws Exception{
        this.mockMvc.perform(get("/cadastrarCliente"))
                .andExpect(status().isOk())
                .andExpect(view().name("cliente/formCliente"));
    }

    @Test
    void cadClientePost() throws Exception {
        this.mockMvc.perform(post("/cadastrarCliente")
                        .param("nome", "teste")
                        .param("dataNasc", "30/02/2000")
                        .param("rendaMedia", "1000"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void listCliente() throws Exception{
        this.mockMvc.perform(get("/listarCliente"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("clientes"));
    }

    @Test
    void atualizarCliente() throws Exception{
        this.mockMvc.perform(get("/atualizarCliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("codigo", ""))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void salvaAtualizacao() throws Exception {
        this.mockMvc.perform(post("/atualizarCliente"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void deletaCliente() throws Exception {
        this.mockMvc.perform(get("/listarCliente"))
                .andExpect(status().is2xxSuccessful());
    }
}