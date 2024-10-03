package org.example.business;

import org.example.data.PessoaRepository;
import org.example.dto.PessoaDTO;
import org.example.refl.Transformator;

import java.util.HashMap;

public class PessoaService {
    public PessoaDTO list() {
        try {
            return new Transformator().transform(new PessoaRepository().list(), PessoaDTO.class, new HashMap<>());
        } catch (Exception e) {
            return null;
        }
    }
}
