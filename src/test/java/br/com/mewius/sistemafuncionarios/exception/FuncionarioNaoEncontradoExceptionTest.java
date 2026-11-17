/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioNaoEncontradoExceptionTest {

    @Test
    void deveCriarExcecaoComMensagem() {
        FuncionarioNaoEncontradoException exception =
                new FuncionarioNaoEncontradoException("Funcionário não encontrado.");

        assertEquals("Funcionário não encontrado.", exception.getMessage());
    }
}
