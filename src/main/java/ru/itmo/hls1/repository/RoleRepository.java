package ru.itmo.hls1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.booking.playground.model.entity.Role;

import java.util.Optional;

public class RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);


}
