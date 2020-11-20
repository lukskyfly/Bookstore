package pl.sda.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority grantedAuthority : authorities) {

            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                new DefaultRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "/book-list");
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                new DefaultRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "/admin/admin-page");
            }
        }
    }
}