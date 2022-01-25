package com.zaitsava.spring_project_notes.repository;

import com.zaitsava.spring_project_notes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
