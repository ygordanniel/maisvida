package br.med.maisvida.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MedicoDTO implements Serializable {

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private Boolean isAtivo;
    private Boolean isOcupado;
    private EspecialidadeDTO especialidade;
    private CidadeDTO cidade;

}
