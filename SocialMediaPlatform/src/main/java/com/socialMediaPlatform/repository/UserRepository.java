package com.socialMediaPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialMediaPlatform.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
