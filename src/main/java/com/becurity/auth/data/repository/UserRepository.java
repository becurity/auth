package com.becurity.auth.data.repository;

import com.becurity.auth.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Long number);
    User findByEmailAndPassword(String email, String password);
}
