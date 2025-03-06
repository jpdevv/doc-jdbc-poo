// Isso aqui define em qual pacote essa classe está guardada
package com.aulapoo;

// Criamos a classe chamada "Conta"
public class Conta {
    // Essas são as informações que cada conta vai ter:
    private int id; // Um número que identifica a conta
    private String nome; // O nome da pessoa dona da conta
    private float saldo; // O dinheiro que tem na conta
    private float limiteCartao; // O limite do cartão de crédito da conta

    // Aqui criamos um "molde" para quando uma nova conta for criada
    public Conta(int id, String nome, float saldo, float limiteCartao) {
        this.id = id; // Guardamos o ID passado na criação da conta
        this.nome = nome; // Guardamos o nome da pessoa
        this.saldo = saldo; // Guardamos o saldo inicial
        this.limiteCartao = limiteCartao; // Guardamos o limite do cartão
    }

    // Métodos "getter" e "setter"
    // Servem para pegar e mudar os valores das informações da conta

    // Pega o ID da conta
    public int getId() {
        return id;
    }

    // Muda o ID da conta
    public void setId(int id) {
        this.id = id;
    }

    // Pega o nome da conta
    public String getNome() {
        return nome;
    }

    // Muda o nome da conta
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Pega o saldo da conta
    public float getSaldo() {
        return saldo;
    }

    // Muda o saldo da conta
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Pega o limite do cartão
    public float getLimiteCartao() {
        return limiteCartao;
    }

    // Muda o limite do cartão
    public void setLimiteCartao(float limiteCartao) {
        this.limiteCartao = limiteCartao;
    }
}
