package pl.sda.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.model.Role;
import pl.sda.model.User;
import pl.sda.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

private final UserRepository userRepository;

    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userFromDB=userRepository.findByUsername(username);
        List<String> roleList = new ArrayList<>();
        for(Role role : userFromDB.getRoles()){
            roleList.add(role.getName());
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(userFromDB.getUsername())
                .password(userFromDB.getPassword())
                .roles(roleList.toArray(new String[0]))
                .build();

    }
}
