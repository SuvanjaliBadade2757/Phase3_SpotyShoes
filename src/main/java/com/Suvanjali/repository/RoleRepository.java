package com.Suvanjali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Suvanjali.entity.CustomRole;
import com.Suvanjali.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(CustomRole role);
}
