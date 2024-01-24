package com.mate.onlinebookstore.onlinebookstore.repository.user;

import com.mate.onlinebookstore.onlinebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
