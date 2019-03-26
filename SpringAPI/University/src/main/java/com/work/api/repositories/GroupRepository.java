package com.work.api.repositories;

import com.work.api.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository <Group, Long> {
    Optional<Group> findByName(String name);
    Group getByName(String name);
    boolean existsByName(String name);
}
