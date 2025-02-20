package com.example.roomease.repository.role;

import com.example.roomease.model.Role;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long>,
        JpaSpecificationExecutor<Role> {
    @Query("from Role r where r.name in :rolesSet")
    Set<Role> findAllByNameContaining(Set<Role.RoleName> rolesSet);
}
