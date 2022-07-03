package com.ctspod.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ctspod.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 
	User findByUsername(String userName);
}
