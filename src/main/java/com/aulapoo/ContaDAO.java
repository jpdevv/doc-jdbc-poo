package com.aulapoo;

// Importamos algumas ferramentas que ajudam a conectar ao banco de dados
import java.sql.Connection; // Representa a conexão com o banco de dados
import java.sql.PreparedStatement; // Ajuda a criar comandos SQL de forma segura
import java.sql.ResultSet; // Guarda os dados que vêm do banco depois de uma busca (SELECT)

// Criamos a classe ContaDAO. Essa classe serve para manipular contas no banco de dados.
public class ContaDAO {
    
    // Esse método adiciona uma nova conta no banco de dados
    public void adicionarConta(Conta contas) {
        BancoDeDados bancoDados = new BancoDeDados(); // Criamos um objeto para falar com o banco
        Connection conexao = null; // A conexão com o banco começa como "vazia"
        PreparedStatement comando = null; // O comando SQL também começa "vazio"

        try {
            conexao = bancoDados.getConexao(); // Abrimos a conexão com o banco
            // Criamos um comando SQL para adicionar uma nova conta no banco
            comando = conexao.prepareStatement("INSERT INTO conta (id, nome, saldo, limiteCartao) VALUES (?, ?, ?, ?)");
            // Preenchemos os "?" com os dados da conta
            comando.setInt(1, contas.getId());
            comando.setString(2, contas.getNome());
            comando.setFloat(3, contas.getSaldo());
            comando.setFloat(4, contas.getLimiteCartao());

            comando.executeUpdate(); // Executamos o comando SQL para inserir a conta no banco
            String mensagem = String.format("Conta (%s) adicionada com sucesso!", contas.getNome());
            System.out.println(mensagem); // Mostramos uma mensagem dizendo que deu certo
        } catch (Exception e) {
            e.printStackTrace(); // Se der erro, mostramos ele no console
        } finally {
            bancoDados.close(comando, conexao); // Fechamos a conexão com o banco para não gastar memória
        }
    }

    // Esse método apaga uma conta do banco de dados
    public void deletarConta(Conta contas) {
        BancoDeDados bancoDados = new BancoDeDados();
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = bancoDados.getConexao(); // Abrimos a conexão com o banco
            // Criamos um comando SQL para apagar uma conta pelo ID
            comando = conexao.prepareStatement("DELETE FROM conta WHERE id = ?");
            comando.setInt(1, contas.getId()); // Definimos qual conta será apagada

            comando.executeUpdate(); // Executamos o comando SQL para deletar a conta
            String mensagem = String.format("Conta (%s) deletada com sucesso!", contas.getNome());
            System.out.println(mensagem); // Mostramos uma mensagem confirmando
        } catch (Exception e) {
            e.printStackTrace(); // Se der erro, mostramos ele no console
        } finally {
            bancoDados.close(comando, conexao); // Fechamos a conexão com o banco
        }
    }

    // Esse método lista todas as contas que estão no banco de dados
    public void listarContas() {
        BancoDeDados bancoDados = new BancoDeDados();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null; // Esse objeto vai guardar as contas que encontramos no banco

        try {
            conexao = bancoDados.getConexao(); // Abrimos a conexão com o banco
            comando = conexao.prepareStatement("SELECT * FROM conta"); // Criamos um comando para buscar todas as contas
            resultado = comando.executeQuery(); // Executamos o comando e guardamos os resultados

            // Vamos passar por todas as contas encontradas e exibir as informações
            while (resultado.next()) {
                String contaDaVez = String.format("ID: %d, Nome: %s, Saldo: %.2f, Limite do Cartão: %.2f",
                resultado.getInt("id"), resultado.getString("nome"), resultado.getFloat("saldo"), resultado.getFloat("limiteCartao"));
                System.out.println(contaDaVez); // Mostramos a conta no console
            }
        } catch (Exception e) {
            e.printStackTrace(); // Se der erro, mostramos no console
        } finally {
            bancoDados.close(comando, conexao); // Fechamos a conexão com o banco
        }
    }

    // Esse método serve para atualizar os dados de uma conta no banco
    public void atualizarConta(Conta contas) {
        BancoDeDados bancoDados = new BancoDeDados();
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = bancoDados.getConexao(); // Abrimos a conexão com o banco
            // Criamos um comando SQL para atualizar uma conta pelo ID
            comando = conexao.prepareStatement("UPDATE conta SET nome = ?, saldo = ?, limiteCartao = ? WHERE id = ?");
            // Preenchemos os "?" com os novos valores da conta
            comando.setString(1, contas.getNome());
            comando.setFloat(2, contas.getSaldo());
            comando.setFloat(3, contas.getLimiteCartao());
            comando.setInt(4, contas.getId()); // Dizemos qual conta deve ser atualizada

            comando.executeUpdate(); // Executamos o comando SQL para atualizar os dados
            String mensagem = String.format("Conta (%s) atualizada com sucesso!", contas.getNome());
            System.out.println(mensagem); // Mostramos uma mensagem confirmando
        } catch (Exception e) {
            e.printStackTrace(); // Se der erro, mostramos no console
        } finally {
            bancoDados.close(comando, conexao); // Fechamos a conexão com o banco
        }
    }
}
