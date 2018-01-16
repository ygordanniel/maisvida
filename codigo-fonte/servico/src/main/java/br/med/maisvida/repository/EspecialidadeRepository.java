package br.med.maisvida.repository;

import br.med.maisvida.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> , JpaSpecificationExecutor<Especialidade> {
}
