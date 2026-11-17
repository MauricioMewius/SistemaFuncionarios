/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.model;

public class FuncionarioPJ extends Funcionario implements Tributavel {

    private int quantidadeProjetos;

    public FuncionarioPJ(int codigo, String nome, String cpf,
                         double valorPorProjeto, int quantidadeProjetos) {

        super(codigo, nome, cpf, valorPorProjeto);
        setQuantidadeProjetos(quantidadeProjetos);
    }

    public int getQuantidadeProjetos() {
        return quantidadeProjetos;
    }

    public void setQuantidadeProjetos(int quantidadeProjetos) {
        if (quantidadeProjetos < 0) {
            throw new IllegalArgumentException(
                    "Quantidade de projetos não pode ser negativa."
            );
        }

        this.quantidadeProjetos = quantidadeProjetos;
    }

    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() * quantidadeProjetos;
   
    }
    
    @Override
public double calcularTributos() {
    return calcularRemuneracao() * 0.06;
}
    
}
