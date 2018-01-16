package br.med.maisvida.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstadoDTO implements Serializable {

    private Long id;
    private String nome;
    private String sigla;
}
