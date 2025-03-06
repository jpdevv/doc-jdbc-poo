# **Documentação do Projeto – Sistema de Contas em Java com PostgreSQL**

## **1. Visão Geral**
Este projeto é um sistema simples de gerenciamento de contas bancárias usando Java e um banco de dados PostgreSQL. Ele permite criar, listar, atualizar e deletar contas de um banco de dados.

---

## **2. Estrutura do Projeto**
O projeto é composto por cinco classes principais:

1. **`App.java`** → Classe principal, onde o programa começa a rodar.
2. **`Conta.java`** → Representa uma conta bancária.
3. **`ContaDAO.java`** → Faz operações no banco de dados (inserir, listar, atualizar e deletar contas).
4. **`BancoDeDados.java`** → Gerencia a conexão com o banco PostgreSQL.
5. **Banco de Dados PostgreSQL** → Tabela chamada **`conta`** que armazena os dados das contas.

---

## **3. Explicação das Classes**

### **3.1 Classe `App.java` (Classe Principal)**
📌 **O que ela faz?**  
- Cria contas bancárias.
- Adiciona essas contas no banco de dados.
- Atualiza o nome de uma conta.
- Lista todas as contas cadastradas.
- Exclui as contas do banco.

📌 **Exemplo de Código**
```java
package com.aulapoo;

public class App {
    public static void main(String[] args) {
        Conta conta1 = new Conta(1, "Letícia", 1412, 500);
        Conta conta2 = new Conta(2, "Raissa", 2500, 1000);
        Conta conta3 = new Conta(3, "Carlos", 80000, 10000);

        ContaDAO gerenciador = new ContaDAO();
        
        gerenciador.adicionarConta(conta1);
        gerenciador.adicionarConta(conta2);
        gerenciador.adicionarConta(conta3);
        
        conta3.setNome("José");
        gerenciador.atualizarConta(conta3);
        
        gerenciador.listarContas();
        
        gerenciador.deletarConta(conta1);
        gerenciador.deletarConta(conta2);
        gerenciador.deletarConta(conta3);
    }
}
```
---

### **3.2 Classe `Conta.java` (Modelo de Conta Bancária)**
📌 **O que ela faz?**  
- Guarda os dados de uma conta bancária: **ID, Nome, Saldo e Limite do Cartão**.
- Permite acessar e modificar esses dados.

📌 **Exemplo de Código**
```java
package com.aulapoo;

public class Conta {
    private int id;
    private String nome;
    private float saldo;
    private float limiteCartao;

    public Conta(int id, String nome, float saldo, float limiteCartao) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.limiteCartao = limiteCartao;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public float getSaldo() { return saldo; }
    public float getLimiteCartao() { return limiteCartao; }
    
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSaldo(float saldo) { this.saldo = saldo; }
    public void setLimiteCartao(float limiteCartao) { this.limiteCartao = limiteCartao; }
}
```
---

### **3.3 Criando o Banco de Dados no PostgreSQL**
📌 **Antes de rodar o programa, crie a tabela no pgAdmin**
```sql
CREATE TABLE conta (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    saldo NUMERIC,
    limiteCartao NUMERIC
);
```
---

### **4. Como Rodar o Projeto**

#### **4.1 Requisitos**
- Java 8 ou superior
- PostgreSQL instalado e configurado
- Maven (caso esteja usando gerenciamento de dependências)

#### **4.2 Passos para Execução**
1. Clone este repositório
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```
2. Abra o projeto em uma IDE como IntelliJ, Eclipse ou VSCode
3. Configure a conexão com o banco no arquivo `BancoDeDados.java`
4. Crie a tabela executando o SQL acima no PostgreSQL
5. Execute a classe `App.java`

---

## **5. Conclusão**
Este projeto simples mostra como conectar Java a um banco de dados PostgreSQL para gerenciar contas bancárias. Ele permite criar, listar, atualizar e excluir contas facilmente.
