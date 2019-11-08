package com.johnpantoja.service;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.johnpantoja.Exception.CustomeFieldValidationException;
import com.johnpantoja.Exception.UsernameOrIdNotFound;
import com.johnpantoja.entity.User;
import com.johnpantoja.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new CustomeFieldValidationException("Username no disponible", "username");
		}
		return true;
	}

	@Override
	public User getUserById(Long id) throws UsernameOrIdNotFound {
		return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));
	}

	protected void mapUser(User from, User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws UsernameOrIdNotFound {
		User user = getUserById(id);
		repository.delete(user);
	}

	private boolean isLoggedUserADMIN() {
		// Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UserDetails loggedUser = null;
		Object roles = null;

		// Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;

			roles = loggedUser.getAuthorities().stream().filter(x -> "ROLE_ADMIN".equals(x.getAuthority())).findFirst()
					.orElse(null);
		}
		return roles != null ? true : false;
	}

	@Override
	public User getLoggedUser() throws Exception {
		// Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UserDetails loggedUser = null;

		// Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		}

		User myUser = repository.findByUsername(loggedUser.getUsername())
				.orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));

		
	

		return myUser;
	}
}
