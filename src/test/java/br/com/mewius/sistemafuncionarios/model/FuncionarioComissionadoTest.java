/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioComissionadoTest {

    @Test
    public void deveCalcularRemuneracaoCorretamente() {

        FuncionarioComissionado funcionario = new FuncionarioComissionado(
                4,
                "Pedro Santos",
                "529.982.247-25",
                2000.00,
                10000.00,
                10.0
        );

        double resultado = funcionario.calcularRemuneracao();

        assertEquals(3000.00, resultado, 0.01);
    }
    
    @Test
public void deveCalcularTributosCorretamente() {

    FuncionarioComissionado funcionario = new FuncionarioComissionado(
            4,
            "Pedro Santos",
            "529.982.247-25",
            2000.00,
            10000.00,
            10.0
    );

    double tributos = funcionario.calcularTributos();

    assertEquals(150.00, tributos, 0.01);
}
    
}
