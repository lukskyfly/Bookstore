package pl.sda.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutoLoginService {

    void autoLogin(String username, String password);

   }
