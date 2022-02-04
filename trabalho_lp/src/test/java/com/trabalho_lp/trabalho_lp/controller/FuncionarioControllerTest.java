package com.trabalho_lp.trabalho_lp.controller;

import com.trabalho_lp.trabalho_lp.model.Funcionario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
        this.mockMvc.perform(post("/cadastrarFuncionario"))
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
                        .param("id", "4"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void salvaAtualizacao() {
    }

    @Test
    void deletaFuncionario() {
    }
}