package br.com.listaexercicios.model;

import java.time.LocalDate;

public class Jogador {
    public String nome;
    public String posicao;
    public String nacionalidade;
    public double altura;
    public double peso;
    public LocalDate dataNascimento;

    public Jogador(String nome, String posicao, String nacionalidade, double altura, double peso, LocalDate dataNascimento) {
        this.nome = nome;
        this.posicao = posicao;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Posição: " + posicao +
                ", Nacionalidade: " + nacionalidade +
                ", Altura: " + altura + " m" +
                ", Peso: " + peso + " kg" +
                ", Data de Nascimento: " + dataNascimento;
    }
}
