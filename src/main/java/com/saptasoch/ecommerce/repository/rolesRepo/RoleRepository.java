package com.saptasoch.ecommerce.repository.rolesRepo;

import com.saptasoch.ecommerce.model.users.eRole.ERole;
import com.saptasoch.ecommerce.model.users.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
