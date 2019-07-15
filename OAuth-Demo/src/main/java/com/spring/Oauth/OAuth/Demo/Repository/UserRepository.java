package com.spring.Oauth.OAuth.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Oauth.OAuth.Demo.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{ 
	public User findOneByUsername(String userName);

}
