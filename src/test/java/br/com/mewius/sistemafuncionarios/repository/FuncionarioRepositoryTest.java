/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.repository;

import br.com.mewius.sistemafuncionarios.model.FuncionarioCLT;
import org.junit.jupiter.api.Test;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioJaCadastradoException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.mewius.sistemafuncionarios.model.Funcionario;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioNaoEncontradoException;
import java.util.List;

public class FuncionarioRepositoryTest {

    @Test
    public void deveCadastrarFuncionario() {

        FuncionarioRepository repository = new FuncionarioRepository();

        FuncionarioCLT funcionario = new FuncionarioCLT(
                1,
                "Joao Silva",
                "529.982.247-25",
                2000.00,
                500.00
        );

        repository.cadastrar(funcionario);

        assertEquals(1, repository.listarTodos().size());
    }
    
    @Test
public void naoDeveCadastrarFuncionarioComCodigoDuplicado() {

    FuncionarioRepository repository = new FuncionarioRepository();

    FuncionarioCLT funcionario1 = new FuncionarioCLT(
            1, "Joao Silva", "529.982.247-25", 2000.00, 500.00
    );

    FuncionarioCLT funcionario2 = new FuncionarioCLT(
            1, "Maria Silva", "111.444.777-35", 2500.00, 300.00
    );

    repository.cadastrar(funcionario1);

    assertThrows(
            FuncionarioJaCadastradoException.class,
            () -> repository.cadastrar(funcionario2)
    );
}
    
@Test
public void deveBuscarFuncionarioPorCodigo() {

    FuncionarioRepository repository = new FuncionarioRepository();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            5,
            "Carlos Souza",
            "529.982.247-25",
            2000.00,
            500.00
    );

    repository.cadastrar(funcionario);

    Funcionario encontrado = repository.buscarPorCodigo(5);

    assertEquals("Carlos Souza", encontrado.getNome());
}

@Test
public void deveLancarExcecaoQuandoFuncionarioNaoExiste() {

    FuncionarioRepository repository = new FuncionarioRepository();

    assertThrows(
            FuncionarioNaoEncontradoException.class,
            () -> repository.buscarPorCodigo(99)
    );
}

@Test
public void deveBuscarFuncionarioPorNome() {

    FuncionarioRepository repository = new FuncionarioRepository();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            6,
            "Carlos Souza",
            "529.982.247-25",
            2000.00,
            500.00
    );

    repository.cadastrar(funcionario);

    List<Funcionario> encontrados = repository.buscarPorNome("carlos");

    assertEquals(1, encontrados.size());
    assertEquals("Carlos Souza", encontrados.get(0).getNome());
}

@Test
public void deveRemoverFuncionario() {

    FuncionarioRepository repository = new FuncionarioRepository();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            7,
            "Pedro Santos",
            "529.982.247-25",
            2000.00,
            500.00
    );

    repository.cadastrar(funcionario);

    repository.remover(7);

    assertEquals(0, repository.listarTodos().size());
}

@Test
public void naoDeveEncontrarFuncionarioAposRemocao() {

    FuncionarioRepository repository = new FuncionarioRepository();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            8,
            "Ana Souza",
            "529.982.247-25",
            2000.00,
            500.00
    );

    repository.cadastrar(funcionario);
    repository.remover(8);

    assertThrows(
            FuncionarioNaoEncontradoException.class,
            () -> repository.buscarPorCodigo(8)
    );
}

}