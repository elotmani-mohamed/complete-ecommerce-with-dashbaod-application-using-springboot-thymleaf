package com.ecommerce.upload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersFileRepo extends JpaRepository<UsersFile, Long> {

}
