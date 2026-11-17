/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioJaCadastradoExceptionTest {

    @Test
    void deveCriarExcecaoComMensagem() {
        FuncionarioJaCadastradoException exception =
                new FuncionarioJaCadastradoException("Código já cadastrado.");

        assertEquals("Código já cadastrado.", exception.getMessage());
    }
}