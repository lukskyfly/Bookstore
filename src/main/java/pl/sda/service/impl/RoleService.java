package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Role;
import pl.sda.repository.RoleRepository;

@Service
public class RoleService implements pl.sda.service.RoleService {

    private final RoleRepository roleRepository;

    public RoleService(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
