package com.example.game.app.role.dao;

import com.example.game.app.role.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleDao {
    private final RoleRepository roleRepository;

    public RoleDao(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role get(Integer roleId) {
        Optional<Role> optional = this.roleRepository.findById(roleId);
        return optional.orElse(null);
    }

    public Role save(Role role) {
        return this.roleRepository.save(role);
    }
}
