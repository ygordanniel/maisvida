package br.med.maisvida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class BaseService<E extends Serializable, R extends JpaRepository<E, Long> & JpaSpecificationExecutor<E>> {

    @Autowired
    protected R repository;

    @Transactional
    public E salvar(E entity) {
        Objects.requireNonNull(entity, "O objeto a ser salvo nao pode ser nulo!");
        return repository.save(entity);
    }

    public E buscarPorId(Long id) {
        Objects.requireNonNull(id, "O ID para a busca nao pode ser nulo!");
        return repository.findOne(id);
    }

    public List<E> listar() {
        return repository.findAll();
    }
}
