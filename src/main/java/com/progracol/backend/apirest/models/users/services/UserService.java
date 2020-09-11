package com.progracol.backend.apirest.models.users.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progracol.backend.apirest.models.usuarios.dao.IUserDao;
import com.progracol.backend.apirest.models.usuarios.entity.User;

@Service
public class UserService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			logger.error("Error en el login: no existe el usuario " + username + " en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario " + username + " en el sistema!");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRol().getName()));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true,
				(Collection<? extends GrantedAuthority>) authorities);
	}

}
