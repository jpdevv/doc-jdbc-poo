package com.aulapoo;

// Importação das classes necessárias para trabalhar com banco de dados PostgreSQL
import java.sql.Connection; // Representa a conexão com o banco de dados
import java.sql.DriverManager; // Responsável por gerenciar a conexão
import java.sql.PreparedStatement; // Usado para executar comandos SQL de forma segura
import java.sql.SQLException; // Trata erros relacionados ao banco de dados

// Declaração da classe BancoDeDados, que será usada para gerenciar a conexão com o banco de dados
public class BancoDeDados {
    // Variáveis que armazenam as informações necessárias para conectar ao banco
    private String url;      // Endereço do banco de dados (URL de conexão)
    private String usuario;  // Nome de usuário para acessar o banco
    private String senha;    // Senha do usuário

    // Construtor da classe, que define os valores padrão para conexão com o banco de dados
    public BancoDeDados() {
        // Define a URL do banco, substitua 'poo' pelo nome do seu banco criado no pgAdmin
        this.url = "jdbc:postgresql://localhost:5432/poo";

        // Define o nome de usuário do banco, geralmente é 'postgres', mas pode ser outro
        this.usuario = "postgres";

        // Define a senha do banco, deve ser a mesma que você usou ao configurar o PostgreSQL
        this.senha = "1234";
    }

    // Método que estabelece uma conexão com o banco de dados
    // Sempre que for preciso acessar o banco, esse método será chamado
    public Connection getConexao() throws SQLException {
        // Retorna um objeto Connection, que representa a conexão com o banco
        return DriverManager.getConnection(url, usuario, senha);
    }

    // Método para fechar a conexão e liberar recursos quando não forem mais necessários
    public void close(PreparedStatement comando, Connection conexao) {
        try {
            // Verifica se o comando não é nulo antes de tentar fechá-lo
            if (comando != null) {
                comando.close(); // Fecha a consulta SQL para evitar consumo desnecessário de memória
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe na tela caso ocorra um erro ao fechar a consulta
        }

        try {
            // Verifica se a conexão não é nula antes de tentar fechá-la
            if (conexao != null) {
                conexao.close(); // Fecha a conexão com o banco de dados
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe na tela caso ocorra um erro ao fechar a conexão
        }
    }
}
