/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.repository;

import br.com.mewius.sistemafuncionarios.model.Funcionario;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioJaCadastradoException;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioRepository {

    private List<Funcionario> funcionarios = new ArrayList<>();
    private Map<Integer, Funcionario> funcionariosPorCodigo = new HashMap<>();

    public void cadastrar(Funcionario funcionario) {

        if (funcionariosPorCodigo.containsKey(funcionario.getCodigo())) {
            throw new FuncionarioJaCadastradoException(
                    "Já existe um funcionário com esse código."
            );
        }

        funcionarios.add(funcionario);
        funcionariosPorCodigo.put(funcionario.getCodigo(), funcionario);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }

    public Funcionario buscarPorCodigo(int codigo) {

        Funcionario funcionario = funcionariosPorCodigo.get(codigo);

        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException(
                    "Funcionário com código " + codigo + " não encontrado."
            );
        }

        return funcionario;
    }

    public List<Funcionario> buscarPorNome(String nome) {

        List<Funcionario> encontrados = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().toLowerCase()
                    .contains(nome.toLowerCase())) {
                encontrados.add(funcionario);
            }
        }

        return encontrados;
    }

    public void remover(int codigo) {

        Funcionario funcionario = buscarPorCodigo(codigo);

        funcionarios.remove(funcionario);
        funcionariosPorCodigo.remove(codigo);
    }
}