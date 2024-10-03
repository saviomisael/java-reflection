package org.example.refl;

import org.example.domain.Pessoa;
import org.example.dto.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class TransformatorTests {
    @Test
    public void shouldTransform() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        var pessoa = Pessoa.build();
        var pessoaDTO = transformator.transform(pessoa, PessoaDTO.class, Map.ofEntries(
                Map.entry("nome", "nomeCompleto")
        ));

        Assertions.assertNotNull(pessoaDTO);
        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);

        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNomeCompleto());
    }
}
