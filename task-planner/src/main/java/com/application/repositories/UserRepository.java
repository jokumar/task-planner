package com.application.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.entity.User;
/**
 * 
 * @author jokumar
 * @since   2018-03-25 
 *
 *	This is User JPA Repository used for 
 *	doing CRUD operation in DB
 */
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

}
