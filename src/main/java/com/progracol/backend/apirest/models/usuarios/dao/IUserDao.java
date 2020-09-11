package com.progracol.backend.apirest.models.usuarios.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.progracol.backend.apirest.models.usuarios.entity.User;

@Repository
public interface IUserDao extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}
