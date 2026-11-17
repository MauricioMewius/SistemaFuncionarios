/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mewius.sistemafuncionarios.view;

import java.util.Scanner;
import br.com.mewius.sistemafuncionarios.service.FuncionarioService;
import br.com.mewius.sistemafuncionarios.model.FuncionarioCLT;
import br.com.mewius.sistemafuncionarios.model.Funcionario;
import java.util.List;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioNaoEncontradoException;
import br.com.mewius.sistemafuncionarios.model.FuncionarioPJ;
import br.com.mewius.sistemafuncionarios.model.FuncionarioComissionado;
import br.com.mewius.sistemafuncionarios.exception.FuncionarioJaCadastradoException;


public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);
    private FuncionarioService service = new FuncionarioService();

    public void exibirMenu() {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE FUNCIONARIOS =====");
            System.out.println("1 - Cadastrar funcionario");
            System.out.println("2 - Listar funcionarios");
            System.out.println("3 - Buscar funcionario");
            System.out.println("4 - Remover funcionario");
            System.out.println("5 - Calcular folha salarial");
            System.out.println("6 - Calcular tributos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            System.out.println();
            
            switch (opcao) {

    case 1: cadastrarFuncionario(); break;

    case 2:
    listarFuncionarios();
    break;

    case 3:
    buscarFuncionario();
    break;

    case 4:
    removerFuncionario();
    break;

    case 5:
    calcularFolhaSalarial();
    break;

    case 6:
    calcularTributos();
    break;

    case 0:
        System.out.println("Saindo do sistema...");
        break;

    default:
        System.out.println("Opção inválida!");
        break;
}

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }
    
    private void cadastrarFuncionario() {

    System.out.println("===== TIPO DE FUNCIONARIO =====");
    System.out.println("1 - CLT");
    System.out.println("2 - PJ");
    System.out.println("3 - Comissionado");
    System.out.print("Escolha: ");

    int tipo = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Codigo: ");
    int codigo = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    System.out.print("CPF: ");
    String cpf = scanner.nextLine();

    try {
        Funcionario funcionario;

        switch (tipo) {
            case 1:
                System.out.print("Salario base: ");
                double salario = scanner.nextDouble();

                System.out.print("Beneficios: ");
                double beneficios = scanner.nextDouble();

                funcionario = new FuncionarioCLT(
                    codigo, nome, cpf, salario, beneficios
                );
                break;

            case 2:
                System.out.print("Valor por projeto: ");
                double valor = scanner.nextDouble();

                System.out.print("Quantidade de projetos: ");
                int quantidade = scanner.nextInt();

                funcionario = new FuncionarioPJ(
                    codigo, nome, cpf, valor, quantidade
                );
                break;

            case 3:
                System.out.print("Salario base: ");
                double base = scanner.nextDouble();

                System.out.print("Valor das vendas: ");
                double vendas = scanner.nextDouble();

                System.out.print("Percentual de comissao: ");
                double percentual = scanner.nextDouble();

                funcionario = new FuncionarioComissionado(
                    codigo, nome, cpf, base, vendas, percentual
                );
                break;

            default:
                System.out.println("Tipo invalido!");
                return;
        }

        service.cadastrarFuncionario(funcionario);
        System.out.println("Funcionario cadastrado com sucesso!");

} catch (IllegalArgumentException | FuncionarioJaCadastradoException e) {
    System.out.println("Erro no cadastro: " + e.getMessage());
}
}
 
    
    private void listarFuncionarios() {

    System.out.println("===== LISTA DE FUNCIONARIOS =====");

    List<Funcionario> funcionarios = service.listarFuncionarios();

    if (funcionarios.isEmpty()) {
        System.out.println("Nenhum funcionario cadastrado.");
        return;
    }

    for (Funcionario funcionario : funcionarios) {

        System.out.println("-------------------------");
        System.out.println("Codigo: " + funcionario.getCodigo());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Remuneracao: R$ " + funcionario.calcularRemuneracao());
    }
}
    
    private void buscarFuncionario() {

    System.out.println("===== BUSCAR FUNCIONARIO =====");
    System.out.println("1 - Buscar por codigo");
    System.out.println("2 - Buscar por nome");
    System.out.print("Escolha: ");

    int opcao = scanner.nextInt();
    scanner.nextLine();

    if (opcao == 1) {

        System.out.print("Digite o codigo: ");
        int codigo = scanner.nextInt();

        try {
            Funcionario funcionario = service.buscarFuncionario(codigo);
            exibirDadosFuncionario(funcionario);

        } catch (FuncionarioNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    } else if (opcao == 2) {

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        List<Funcionario> encontrados = service.buscarFuncionario(nome);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum funcionario encontrado.");
        } else {
            for (Funcionario funcionario : encontrados) {
                exibirDadosFuncionario(funcionario);
            }
        }

    } else {
        System.out.println("Opcao invalida!");
    }
}
    
    private void exibirDadosFuncionario(Funcionario funcionario) {

    System.out.println("-------------------------");
    System.out.println("Codigo: " + funcionario.getCodigo());
    System.out.println("Nome: " + funcionario.getNome());
    System.out.println("CPF: " + funcionario.getCpf());
    System.out.printf("Salario-base: R$ %.2f%n", funcionario.getSalarioBase());

    if (funcionario instanceof FuncionarioCLT) {
        FuncionarioCLT clt = (FuncionarioCLT) funcionario;
        System.out.println("Tipo: CLT");
        System.out.printf("Beneficios: R$ %.2f%n", clt.getBeneficios());

    } else if (funcionario instanceof FuncionarioPJ) {
        FuncionarioPJ pj = (FuncionarioPJ) funcionario;
        System.out.println("Tipo: PJ");
        System.out.println("Quantidade de projetos: " + pj.getQuantidadeProjetos());
        System.out.printf("Valor por projeto: R$ %.2f%n", pj.getSalarioBase());

    } else if (funcionario instanceof FuncionarioComissionado) {
        FuncionarioComissionado comissionado = (FuncionarioComissionado) funcionario;
        System.out.println("Tipo: Comissionado");
        System.out.printf("Valor das vendas: R$ %.2f%n", comissionado.getValorVendas());
        System.out.printf("Comissao: %.2f%%%n", comissionado.getPercentualComissao());
    }

    System.out.printf("Remuneracao total: R$ %.2f%n",
            funcionario.calcularRemuneracao());

    System.out.println("-------------------------");
}
    
    private void removerFuncionario() {

    System.out.println("===== REMOVER FUNCIONARIO =====");

    System.out.print("Digite o codigo do funcionario: ");
    int codigo = scanner.nextInt();

    try {

        service.removerFuncionario(codigo);

        System.out.println("Funcionario removido com sucesso!");

    } catch (FuncionarioNaoEncontradoException e) {

        System.out.println(e.getMessage());
    }
}

private void calcularFolhaSalarial() {

    double total = service.calcularFolhaSalarial();

    System.out.println("===== FOLHA SALARIAL =====");
    System.out.printf("Total da folha: R$ %.2f%n", total);
}
 
private void calcularTributos() {
    double total = service.calcularTributosTotais();

    System.out.println("===== TRIBUTOS TOTAIS =====");
    System.out.printf("Total de tributos: R$ %.2f%n", total);
}

}