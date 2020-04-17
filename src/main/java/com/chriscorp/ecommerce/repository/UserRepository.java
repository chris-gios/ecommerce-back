package com.chriscorp.ecommerce.repository;

import com.chriscorp.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "from User t where t.username = :username")
    User findUserByUsername(@Param("username") String userName);

    @Query(value = "from User t where t.username = :username and t.password = :password")
    User login(@Param("username") String username, @Param("password") String password);

}

