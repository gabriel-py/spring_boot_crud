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
class LivroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void cadLivro() throws Exception {
        this.mockMvc.perform(get("/cadastrarLivro"))
                .andExpect(status().isOk())
                .andExpect(view().name("livro/formLivro"));
    }

    @Test
    void cadLivroPost() throws Exception {
        this.mockMvc.perform(post("/cadastrarLivro")
                        .param("nome", "livro dos testes")
                        .param("preco", "20"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void listLivro() throws Exception {
        this.mockMvc.perform(get("/listarLivro"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("livro"));
    }

    @Test
    void atualizarLivro() throws Exception {
        this.mockMvc.perform(get("/atualizarLivro")
                        .param("codigo", "13"))
                .andExpect(model().attributeExists("livro"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void salvaAtualizacao() throws Exception {
        this.mockMvc.perform(post("/atualizarLivro"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void deletaCliente() throws Exception {
        this.mockMvc.perform(get("/deletarLivro")
                        .param("id", "14"))
                .andExpect(status().is3xxRedirection());
    }
}