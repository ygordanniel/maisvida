package br.med.maisvida.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario", schema = "maisvida")
public class Usuario implements Serializable, UserDetails {

    @Id
    @Column(name = "id_usuario")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "maisvida.tb_usuario_seq", name = "tb_usuario_seq")
    @GeneratedValue(generator = "tb_usuario_seq", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email_usuario")
    private String email;

    @Column(name = "senha_usuario")
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = Collections.emptyList();
        return authorities;
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
