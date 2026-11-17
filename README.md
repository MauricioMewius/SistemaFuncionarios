# Sistema de Gerenciamento de Funcionários

Sistema desenvolvido em Java para cadastro, consulta, remoção e gerenciamento de funcionários, com cálculo de remuneração e folha de pagamento.

## Funcionalidades

- Cadastro de funcionários CLT, PJ e comissionados
- Listagem de funcionários
- Busca por código ou nome
- Remoção de funcionários
- Cálculo individual de remuneração
- Relatório da folha de pagamento
- Cálculo do total geral da folha
- Validação de dados e tratamento de exceções

## Tecnologias

- Java 17
- Maven
- JUnit 5
- NetBeans

## Organização do projeto

- `model`: classes de domínio e interfaces
- `repository`: armazenamento e acesso aos funcionários
- `service`: regras de negócio
- `view`: menu e interação com o usuário
- `exception`: exceções personalizadas

## Como executar

Abra o projeto no NetBeans como um projeto Maven e execute a classe `SistemaFuncionarios.java`.

## Como executar os testes

Na raiz do projeto, execute:

```bash
mvn clean test