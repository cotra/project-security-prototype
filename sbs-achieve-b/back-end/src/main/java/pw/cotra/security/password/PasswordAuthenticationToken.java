package pw.cotra.security.password;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class PasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public PasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public PasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
