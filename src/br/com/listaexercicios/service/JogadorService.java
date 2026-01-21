package br.com.listaexercicios.service;

import br.com.listaexercicios.model.Jogador;
import java.time.LocalDate;
import java.time.Period;

public class JogadorService {

    // Calcula idade
    public int getIdade(Jogador jogador) {
        LocalDate hoje = LocalDate.now();
        LocalDate nascimento = jogador.getDataNascimento();
        if (nascimento != null && !nascimento.isAfter(hoje)) {
            return Period.between(nascimento, hoje).getYears();
        } else {
            return 0;
        }
    }

    // Determina a posição automaticamente com base na idade
    public String determinarPosicao(Jogador jogador) {
        int idade = getIdade(jogador);

        if (idade <= 35) return "Atacante";
        else if (idade <= 38) return "Meio-campo";
        else if (idade <= 40) return "Defesa";
        else return "Aposentado";
    }
}
