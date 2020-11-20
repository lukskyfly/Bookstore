package pl.sda.service;

import pl.sda.model.Role;

public interface RoleService {

    Role findByName(String name);
}
