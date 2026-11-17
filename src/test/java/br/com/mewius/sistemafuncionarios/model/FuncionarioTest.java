/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void deveCriarFuncionarioComDadosValidos() {
        Funcionario funcionario = new FuncionarioCLT(
                1, "João", "52998224725", 2000, 500
        );

        assertEquals(1, funcionario.getCodigo());
        assertEquals("João", funcionario.getNome());
        assertEquals("52998224725", funcionario.getCpf());
        assertEquals(2000, funcionario.getSalarioBase());
        assertEquals(2500, funcionario.calcularRemuneracao());
    }

    @Test
    void naoDeveAceitarCodigoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioCLT(0, "João", "52998224725", 2000, 500)
        );
    }

    @Test
    void naoDeveAceitarNomeVazio() {
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioCLT(1, " ", "52998224725", 2000, 500)
        );
    }

    @Test
    void naoDeveAceitarCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioCLT(1, "João", "12345678900", 2000, 500)
        );
    }

    @Test
    void naoDeveAceitarSalarioNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioCLT(1, "João", "52998224725", -100, 500)
        );
    }
}