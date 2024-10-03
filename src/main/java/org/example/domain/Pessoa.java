package org.example.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private ArrayList<Pessoa> filhos;

    public static Pessoa build() {
        var filha = new ArrayList<Pessoa>();
        filha.add(new Pessoa().setNome("Maria").setFilhos(new ArrayList<>()).setDataDeNascimento(LocalDate.of(2002, 1, 23)));

        return new Pessoa()
                .setNome("João")
                .setDataDeNascimento(LocalDate.of(1986, 7, 12))
                .setFilhos(filha);
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Pessoa setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public ArrayList<Pessoa> getFilhos() {
        return filhos;
    }

    public Pessoa setFilhos(ArrayList<Pessoa> filhos) {
        this.filhos = filhos;
        return this;
    }
}
