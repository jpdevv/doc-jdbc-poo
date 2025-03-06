package com.aulapoo;

// Criamos a classe principal chamada "App"
public class App 
{
    // O método "main" é onde o programa começa a rodar
    public static void main( String[] args )
    {
        // Criamos três contas diferentes com ID, nome, saldo e limite do cartão
        Conta conta1 = new Conta(1, "Letícia", 1412, 500);
        Conta conta2 = new Conta(2, "Raissa", 2500, 1000);
        Conta conta3 = new Conta(3, "Carlos", 80000, 10000);

        // Criamos um gerenciador de contas, que vai mexer no banco de dados
        ContaDAO gerenciador = new ContaDAO();

        // Adicionamos as três contas no banco de dados
        gerenciador.adicionarConta(conta1);
        gerenciador.adicionarConta(conta2);
        gerenciador.adicionarConta(conta3);

        // Mudamos o nome da conta3 de "Carlos" para "José"
        conta3.setNome("José");
        // Atualizamos a conta3 no banco de dados para salvar a mudança
        gerenciador.atualizarConta(conta3);

        // Listamos todas as contas que estão no banco de dados
        gerenciador.listarContas();

        // Apagamos as três contas do banco de dados
        gerenciador.deletarConta(conta1);
        gerenciador.deletarConta(conta2);
        gerenciador.deletarConta(conta3);
    }
}
