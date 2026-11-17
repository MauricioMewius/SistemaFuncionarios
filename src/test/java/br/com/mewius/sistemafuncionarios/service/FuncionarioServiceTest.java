/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.service;

import br.com.mewius.sistemafuncionarios.model.FuncionarioCLT;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.mewius.sistemafuncionarios.model.Funcionario;
import java.util.List;
import br.com.mewius.sistemafuncionarios.model.FuncionarioPJ;
import org.junit.jupiter.api.Assertions;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioNaoEncontradoException;


public class FuncionarioServiceTest {

    @Test
    public void deveCadastrarFuncionarioPeloService() {

        FuncionarioService service = new FuncionarioService();

        FuncionarioCLT funcionario = new FuncionarioCLT(
                1,
                "Joao Silva",
                "529.982.247-25",
                2000.00,
                500.00
        );

        service.cadastrarFuncionario(funcionario);

        assertEquals(1, service.listarFuncionarios().size());
    }
    
    @Test
public void deveBuscarFuncionarioPorCodigo() {

    FuncionarioService service = new FuncionarioService();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            2,
            "Carlos Souza",
            "529.982.247-25",
            2000.00,
            500.00
    );

    service.cadastrarFuncionario(funcionario);

    Funcionario encontrado = service.buscarFuncionario(2);

    assertEquals("Carlos Souza", encontrado.getNome());
}
    
@Test
public void deveBuscarFuncionarioPorNome() {

    FuncionarioService service = new FuncionarioService();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            3,
            "Pedro Santos",
            "529.982.247-25",
            2000.00,
            500.00
    );

    service.cadastrarFuncionario(funcionario);

    List<Funcionario> encontrados = service.buscarFuncionario("Pedro");

    assertEquals(1, encontrados.size());
    assertEquals("Pedro Santos", encontrados.get(0).getNome());
}

@Test
public void deveRemoverFuncionarioPeloService() {

    FuncionarioService service = new FuncionarioService();

    FuncionarioCLT funcionario = new FuncionarioCLT(
            4,
            "Maria Silva",
            "529.982.247-25",
            2000.00,
            500.00
    );

    service.cadastrarFuncionario(funcionario);

    service.removerFuncionario(4);

    assertEquals(0, service.listarFuncionarios().size());
}

@Test
public void deveCalcularFolhaSalarial() {

    FuncionarioService service = new FuncionarioService();

    FuncionarioCLT clt = new FuncionarioCLT(
            1, "Joao Silva", "529.982.247-25", 2000.00, 500.00
    );

    FuncionarioPJ pj = new FuncionarioPJ(
            2, "Maria Silva", "111.444.777-35", 1000.00, 3
    );

    service.cadastrarFuncionario(clt);
    service.cadastrarFuncionario(pj);

    assertEquals(5500.00, service.calcularFolhaSalarial(), 0.01);
}

@Test
public void deveCalcularTributosTotais() {

    FuncionarioService service = new FuncionarioService();

    FuncionarioCLT clt = new FuncionarioCLT(
            1, "Joao Silva", "529.982.247-25", 2000.00, 500.00
    );

    FuncionarioPJ pj = new FuncionarioPJ(
            2, "Maria Silva", "111.444.777-35", 1000.00, 3
    );

    service.cadastrarFuncionario(clt);
    service.cadastrarFuncionario(pj);

    assertEquals(380.00, service.calcularTributosTotais(), 0.01);
}

@Test
public void deveLancarExcecaoAoRemoverFuncionarioInexistente() {

    FuncionarioService service = new FuncionarioService();

    Assertions.assertThrows(
            FuncionarioNaoEncontradoException.class,
            () -> service.removerFuncionario(999)
    );
}

}
