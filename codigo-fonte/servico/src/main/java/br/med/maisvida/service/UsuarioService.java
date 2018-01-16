package br.med.maisvida.service;

import br.med.maisvida.model.Usuario;
import br.med.maisvida.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {

    public Usuario buscarPorEmailESenha(Optional<String> email, Optional<String> senha) {
        return repository.findUsuarioByEmailAndSenha(email.orElse(""), senha.orElse(""));
    }

    public Usuario buscarPorEmail(Optional<String> email) {
        return repository.findUsuarioByEmail(email.orElse(""));
    }
}
