package com.cognizant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
