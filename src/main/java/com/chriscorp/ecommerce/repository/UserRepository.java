package com.chriscorp.ecommerce.repository;

import com.chriscorp.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

