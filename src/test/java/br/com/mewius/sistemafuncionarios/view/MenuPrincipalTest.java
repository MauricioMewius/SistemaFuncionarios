/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.view;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuPrincipalTest {

    @Test
    void deveExibirOpcoesDoMenu() {
        System.setIn(new ByteArrayInputStream(
                "0\n".getBytes(StandardCharsets.UTF_8)
        ));

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        try {
            MenuPrincipal menu = new MenuPrincipal();
            menu.exibirMenu();

            String resultado = saida.toString(StandardCharsets.UTF_8);

            assertTrue(resultado.contains("SISTEMA DE FUNCIONARIOS"));
            assertTrue(resultado.contains("Cadastrar funcionario"));
            assertTrue(resultado.contains("Listar funcionarios"));
            assertTrue(resultado.contains("Sair"));

        } finally {
            System.setIn(System.in);
            System.setOut(System.out);
        }
    }
}
