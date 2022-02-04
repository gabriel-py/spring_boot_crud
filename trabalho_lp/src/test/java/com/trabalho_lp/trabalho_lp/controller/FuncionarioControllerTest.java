package com.trabalho_lp.trabalho_lp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void cadFuncionario() throws Exception {
        this.mockMvc.perform(get("/cadastrarFuncionario"))
                .andExpect(status().isOk())
                .andExpect(view().name("funcionario/formFuncionario"));
    }

    @Test
    void CadFuncionarioPost() throws Exception{
        this.mockMvc.perform(post("/cadastrarFuncionario")
                        .param("nome", "teste")
                        .param("dataNasc", "30/02/2000"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void listFuncionario() throws Exception{
        this.mockMvc.perform(get("/listarFuncionario"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("funcionarios"));
    }

    @Test
    void atualizarFuncionario() throws Exception{
        this.mockMvc.perform(get("/atualizarFuncionario")
                        .param("id", "13"))
                .andExpect(model().attributeExists("funcionario"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void salvaAtualizacao() throws Exception {
        this.mockMvc.perform(post("/atualizarFuncionario"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void deletaFuncionario() throws Exception {
        this.mockMvc.perform(get("/deletarFuncionario")
                        .param("id", "14"))
                .andExpect(status().is3xxRedirection());
    }
}