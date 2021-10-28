package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {

}
