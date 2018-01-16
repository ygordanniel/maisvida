package br.med.maisvida.repository;

import br.med.maisvida.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    Usuario findUsuarioByEmailAndSenha(String email, String senha);

    Usuario findUsuarioByEmail(String email);
}
