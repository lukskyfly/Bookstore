package pl.sda.service;

import pl.sda.model.Book;
import pl.sda.model.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);

    User findByUsername(String username);

    void save(User user);

    void delete(Integer id);

}
