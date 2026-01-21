package br.com.listaexercicios.service;

import br.com.listaexercicios.model.Pessoa;
import java.time.LocalDate;
import java.time.Period;

public class PessoaService {

    // Calcula a idade da pessoa
    public int getIdade(Pessoa pessoa) {
        LocalDate hoje = LocalDate.now();
        LocalDate nascimento = pessoa.getDataNascimento();

        // Se a data de nascimento for válida (não futura), calcula idade
        if (nascimento != null && !nascimento.isAfter(hoje)) {
            return Period.between(nascimento, hoje).getYears();
        } else {
            return 0; // ou lançar exceção se quiser tratar erro
        }
    }
}
