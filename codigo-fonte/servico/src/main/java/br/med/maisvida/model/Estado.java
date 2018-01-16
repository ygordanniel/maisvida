package br.med.maisvida.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "td_estado", schema = "maisvida")
public class Estado implements Serializable {

    @Id
    @Column(name = "id_estado")
    private Long id;

    @Column(name = "nome_estado")
    private String nome;

    @Column(name = "sig_estado")
    private String sigla;
}
