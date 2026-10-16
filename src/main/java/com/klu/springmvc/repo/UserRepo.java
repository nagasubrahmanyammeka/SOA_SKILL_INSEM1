package com.klu.springmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.springmvc.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String Username);
}
