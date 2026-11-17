/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package br.com.mewius.sistemafuncionarios.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioCLTTest {

    @Test
    public void deveCalcularRemuneracaoCorretamente() {

        // Arrange - Preparar os dados
        FuncionarioCLT funcionario = new FuncionarioCLT(
                1,
                "Joao Silva",
                "529.982.247-25",
                2000.00,
                500.00
        );

        // Act - Executar o cálculo
        double resultado = funcionario.calcularRemuneracao();

        // Assert - Verificar o resultado
        assertEquals(2500.00, resultado, 0.01);
    }

@Test
public void naoDeveAceitarBeneficiosNegativos() {

    assertThrows(IllegalArgumentException.class, () -> {
        new FuncionarioCLT(
                2,
                "Maria Silva",
                "111.444.777-35",
                2000.00,
                -500.00
        );
    });
}
    
@Test
public void deveCalcularTributosCorretamente() {

    FuncionarioCLT funcionario = new FuncionarioCLT(
            5,
            "Joao Silva",
            "529.982.247-25",
            2000.00,
            500.00
    );

    double tributos = funcionario.calcularTributos();

    assertEquals(200.00, tributos, 0.01);
}

}
