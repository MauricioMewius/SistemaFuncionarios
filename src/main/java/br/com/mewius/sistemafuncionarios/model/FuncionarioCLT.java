/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.model;

public class FuncionarioCLT extends Funcionario implements Tributavel  {

    private double beneficios;

    public FuncionarioCLT(int codigo, String nome, String cpf,
                          double salarioBase, double beneficios) {

        super(codigo, nome, cpf, salarioBase);
        setBeneficios(beneficios);
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        if (!Double.isFinite(beneficios) || beneficios < 0) {
            throw new IllegalArgumentException(
                    "Benefícios não podem ser negativos."
            );
        }

        this.beneficios = beneficios;
    }

    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() + beneficios;
    }
    
    @Override
public double calcularTributos() {
    return calcularRemuneracao() * 0.08;
}
    
}
