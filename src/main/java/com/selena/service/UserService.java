package com.selena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.selena.model.User;
import com.selena.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService extends BaseService<User> {
	@Autowired
	private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Override
	protected Class<User> clazz() {
		return User.class;
	}

	public User loadUserByUsername(String userName) {
		return userRepository.getUserByUsername(userName);
	}
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public boolean changePassword(User user, String newPassword) {
		// Update password logic without encoding
		user.setPassword(newPassword);
		userRepository.save(user);
		return true;
	}
	public User getCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByUsername(username);
	}
	public void save(User user) {
		userRepository.save(user);
	}
}