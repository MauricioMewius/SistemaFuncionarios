/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.service;

import br.com.mewius.sistemafuncionarios.model.Funcionario;
import br.com.mewius.sistemafuncionarios.repository.FuncionarioRepository;
import java.util.List;
import br.com.mewius.sistemafuncionarios.model.Tributavel;

public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService() {
        this.repository = new FuncionarioRepository();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
    repository.cadastrar(funcionario);
}
    
    public List<Funcionario> listarFuncionarios() {
    return repository.listarTodos();
}
 
    public Funcionario buscarFuncionario(int codigo) {
    return repository.buscarPorCodigo(codigo);
}
   
    public List<Funcionario> buscarFuncionario(String nome) {
    return repository.buscarPorNome(nome);
}
   
    public void removerFuncionario(int codigo) {
    repository.remover(codigo);
}
 
    public double calcularFolhaSalarial() {

    double total = 0;

    for (Funcionario funcionario : repository.listarTodos()) {
        total += funcionario.calcularRemuneracao();
    }

    return total;
}
  
    public double calcularTributosTotais() {

    double total = 0;

    for (Funcionario funcionario : repository.listarTodos()) {

        if (funcionario instanceof Tributavel) {
            Tributavel tributavel = (Tributavel) funcionario;
            total += tributavel.calcularTributos();
        }
    }

    return total;
}
    
}
