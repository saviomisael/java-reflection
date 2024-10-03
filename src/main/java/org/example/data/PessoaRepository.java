package org.example.data;

import org.example.domain.Pessoa;

public class PessoaRepository {
    public Pessoa list() {
        return Pessoa.build();
    }
}
