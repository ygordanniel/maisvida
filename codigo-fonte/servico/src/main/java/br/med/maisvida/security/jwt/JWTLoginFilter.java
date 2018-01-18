package br.med.maisvida.security.jwt;

import br.med.maisvida.model.Usuario;
import br.med.maisvida.security.AccountCredentials;
import br.med.maisvida.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * @see <a href="http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/">andreybleme blog</>
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    private UsuarioService usuarioService;

    public JWTLoginFilter(String url, AuthenticationManager authManager, UsuarioService usuarioService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.usuarioService = usuarioService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException, IOException, ServletException {

        AccountCredentials credentials = new ObjectMapper()
            .readValue(request.getInputStream(), AccountCredentials.class);

        //Caso o usuario e senha nao existam, invalida a autenticacao
        Usuario usuario = usuarioService.buscarPorEmailESenha(ofNullable(credentials.getEmail()), ofNullable(credentials.getSenha()));

        if(usuario == null) {
            return null;
        }

        return getAuthenticationManager().authenticate(
            new UsernamePasswordAuthenticationToken(
                usuario.getEmail(),
                usuario.getSenha(),
                Collections.emptyList()
            )
        );
    }

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain,
        Authentication auth) throws IOException, ServletException {

        TokenAuthenticationService.addAuthentication(response, auth.getName());
    }
}
