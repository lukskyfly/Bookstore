package pl.sda.service;

import pl.sda.model.User;

public interface UserService {

    User findByUsername(String username);

    void save(User user);

    void delete(User user);
}
