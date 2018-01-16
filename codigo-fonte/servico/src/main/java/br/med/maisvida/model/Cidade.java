package br.med.maisvida.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "td_cidade", schema = "maisvida")
public class Cidade implements Serializable{
    
    @Id
    @Column(name = "id_cidade")
    private Long id;

    @Column(name = "nome_cidade")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "co_estado")
    private Estado estado;
}
