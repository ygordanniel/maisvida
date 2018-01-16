package br.med.maisvida.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_especialidade", schema = "maisvida")
public class Especialidade implements Serializable {

    @Id
    @Column(name = "id_especialidade")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "maisvida.tb_especialidade_seq", name = "tb_especialidade_seq")
    @GeneratedValue(generator = "tb_especialidade_seq", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_especialidade")
    private String descricao;
}
