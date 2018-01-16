package br.med.maisvida.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_medico", schema = "maisvida")
public class Medico implements Serializable {

    @Id
    @Column(name = "id_medico")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "maisvida.tb_medico_seq", name = "tb_medico_seq")
    @GeneratedValue(generator = "tb_medico_seq", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prim_nome_medico")
    private String primeiroNome;

    @Column(name = "ult_nome_medico")
    private String ultimoNome;

    @Column(name = "email_medico")
    private String email;

    @Column(name = "ic_ativo")
    private Boolean isAtivo;

    @Column(name = "ic_ocupado")
    private Boolean isOcupado;

    @ManyToOne
    @JoinColumn(name = "co_especialidade")
    private Especialidade especialidade;

    @ManyToOne
    @JoinColumn(name = "co_cidade")
    private Cidade cidade;


}
