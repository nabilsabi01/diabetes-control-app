package com.diabetes.control.repository;

import com.diabetes.control.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}