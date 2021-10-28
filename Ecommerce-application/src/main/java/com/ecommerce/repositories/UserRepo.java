package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String username);
	
}
