package org.example.dto;

import org.example.domain.Pessoa;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class PessoaDTO {
    private String nomeCompleto;
    private LocalDate dataDeNascimento;
    private ArrayList<Pessoa> filhos;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public PessoaDTO setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public PessoaDTO setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public ArrayList<Pessoa> getFilhos() {
        return filhos;
    }

    public PessoaDTO setFilhos(ArrayList<Pessoa> filhos) {
        this.filhos = filhos;
        return this;
    }
}
