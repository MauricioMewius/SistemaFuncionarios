/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioPJTest {

    @Test
    public void deveCalcularRemuneracaoCorretamente() {

        FuncionarioPJ funcionario = new FuncionarioPJ(
                3,
                "Carlos Souza",
                "529.982.247-25",
                1500.00,
                2
        );

        double resultado = funcionario.calcularRemuneracao();

        assertEquals(3000.00, resultado, 0.01);
    }
    
    @Test
public void deveCalcularTributosCorretamente() {

    FuncionarioPJ funcionario = new FuncionarioPJ(
            3,
            "Carlos Souza",
            "529.982.247-25",
            1500.00,
            2
    );

    double tributos = funcionario.calcularTributos();

    assertEquals(180.00, tributos, 0.01);
}
    
}