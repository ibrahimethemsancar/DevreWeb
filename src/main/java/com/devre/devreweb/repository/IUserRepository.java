package com.devre.devreweb.repository;

import com.devre.devreweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
