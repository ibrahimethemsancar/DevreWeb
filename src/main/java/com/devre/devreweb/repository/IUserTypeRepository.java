package com.devre.devreweb.repository;

import com.devre.devreweb.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
}
