package ru.kata.test_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.test_3.models.Role;
import ru.kata.test_3.repositories.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepo roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
