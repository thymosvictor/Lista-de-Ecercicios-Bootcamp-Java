package br.com.listaexercicios.model;

public class Elevador {
    private int andarAtual;
    private int totalAndares; // desconsiderando o térreo
    private int capacidade;
    private int pessoasPresentes;

    // Construtor
    public Elevador(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0; // térreo
        this.pessoasPresentes = 0;
    }

    // Inicializar elevador (opcional: reinicia valores)
    public void inicializar(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
        System.out.println("Elevador inicializado!");
    }

    // Entrar pessoa
    public void entra() {
        if (pessoasPresentes < capacidade) {
            pessoasPresentes++;
            System.out.println("Uma pessoa entrou. Total no elevador: " + pessoasPresentes);
        } else {
            System.out.println("Elevador cheio! Capacidade máxima: " + capacidade);
        }
    }

    // Sair pessoa
    public void sai() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
            System.out.println("Uma pessoa saiu. Total no elevador: " + pessoasPresentes);
        } else {
            System.out.println("Elevador vazio!");
        }
    }

    // Subir um andar
    public void sobe() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            System.out.println("Elevador subiu para o andar " + andarAtual);
        } else {
            System.out.println("Já está no último andar!");
        }
    }

    // Descer um andar
    public void desce() {
        if (andarAtual > 0) {
            andarAtual--;
            System.out.println("Elevador desceu para o andar " + andarAtual);
        } else {
            System.out.println("Já está no térreo!");
        }
    }

    // Getters
    public int getAndarAtual() { return andarAtual; }
    public int getTotalAndares() { return totalAndares; }
    public int getCapacidade() { return capacidade; }
    public int getPessoasPresentes() { return pessoasPresentes; }
}
