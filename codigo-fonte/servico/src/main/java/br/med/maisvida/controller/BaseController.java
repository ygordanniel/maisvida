package br.med.maisvida.controller;

import br.med.maisvida.service.BaseService;
import br.med.maisvida.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Controller base com os metodos mais comuns de um controller padrao
 * @param <S> classe base de servico
 * @param <DTO> dto base da entidade
 * @param <E> entidade base
 */
@RestController
public abstract class BaseController<S extends BaseService<E, ?>, DTO extends Serializable, E extends Serializable> {

    @Autowired
    protected S service;

    @Autowired
    protected EntityConverter converter;

    public abstract ResponseEntity<List<DTO>> listar();

    public abstract ResponseEntity<DTO> buscarPorId(@PathVariable Long id);

    public abstract ResponseEntity<DTO> adicionar(@RequestBody DTO dto);

    protected abstract ResponseEntity buildResposta(List<E> list);

    protected abstract ResponseEntity buildResposta(E e);

}
