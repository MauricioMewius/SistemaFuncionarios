/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.model;

public class FuncionarioComissionado extends Funcionario implements Tributavel {

    private double valorVendas;
    private double percentualComissao;

    public FuncionarioComissionado(int codigo, String nome, String cpf,
                                   double salarioBase, double valorVendas,
                                   double percentualComissao) {

        super(codigo, nome, cpf, salarioBase);
        setValorVendas(valorVendas);
        setPercentualComissao(percentualComissao);
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        if (!Double.isFinite(valorVendas) || valorVendas < 0) {
            throw new IllegalArgumentException("Valor de vendas inválido.");
        }

        this.valorVendas = valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        if (!Double.isFinite(percentualComissao)
                || percentualComissao < 0
                || percentualComissao > 100) {
            throw new IllegalArgumentException("Percentual inválido.");
        }

        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularRemuneracao() {
        double comissao = valorVendas * percentualComissao / 100;
        return getSalarioBase() + comissao;
    }
    
    @Override
public double calcularTributos() {
    return calcularRemuneracao() * 0.05;
}
    
}