package com.upa.codigorupestre.api;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserAPI {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody UserEntity user) {
		log.info("Create USER - POST");
		userRepository.save(user);

		return ResponseEntity.ok("User crated : " + user.getName());
	}

	@GetMapping("/{userName}")
	public ResponseEntity<Object> getUser(@PathVariable String userName) {

		log.info("Obteniedo el usuario" + userName + " - GET");
		List<UserEntity> lstUsers = userRepository.findByUserName(userName);

		if (!lstUsers.isEmpty()) {
			return ResponseEntity.ok(lstUsers.get(0));
		} else {
			return ResponseEntity.ok("Usuario no existe con el nombre " + userName);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {

		log.info("UPDATE User " + user + " UPDATE");

		Optional<UserEntity> updateUsers = userRepository.findById(id);

		if (!updateUsers.isEmpty()) {
			// UserEntity userBD = userRepository.save(user);
			UserEntity userBD = updateUsers.get();
			userBD.setName(user.getName());
			userBD.setLastName(user.getLastName());
			userBD.setEmail(user.getEmail());
			userBD.setUserName(user.getUserName());
			userBD.setPassword(user.getPassword());
			userRepository.save(userBD);
			return ResponseEntity.ok(userBD);
		} else {
			return ResponseEntity.ok("Usuario no existe con el id " + id);
		}
	}

	@PatchMapping("/{id}/{newPassword}")
	public ResponseEntity<Object> updatePasswordUser(@PathVariable Integer id, @PathVariable String newPassword) {

		log.info("PATH User " + newPassword + " PATH");

		Optional<UserEntity> bdUser = userRepository.findById(id);

		if (!bdUser.isEmpty()) {
			UserEntity user = bdUser.get();
			user.setPassword(newPassword);
			userRepository.save(user);
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.ok("Usuario no existe con el id " + id);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {

		log.info("Eliminando usuario por el id" + id + "DELETE");

		Optional<UserEntity> userBD = userRepository.findById(id);

		if (!userBD.isEmpty()) {
			userRepository.delete(userBD.get());

			return ResponseEntity.ok("Usuario eliminado con exito ");
		} else {
			return ResponseEntity.ok("Usuario no existe con el id " + id);
		}
	}

	@RequestMapping(method = RequestMethod.HEAD, path = "/{id}")
	public ResponseEntity<Object> validateUser(@PathVariable Integer id) {

		log.info("VAlidate user HEAD");

		Optional<UserEntity> userBD = userRepository.findById(id);

		if (!userBD.isEmpty()) {
			return ResponseEntity.ok("El usuario si existe" + userBD.get());

		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	public void updateUser() {
		log.info("mthod OPTIONS");

	}
}
