package com.selena.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.selena.model.Categories;
import com.selena.model.User;
import com.selena.service.CategoriesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public abstract class BaseController {
	@Autowired
	private CategoriesService categoriesService;
	/*
	Hiển thị ra toàn bộ category
	 */
	@ModelAttribute("categories")
	public List<Categories> getAllCategories() {
		return categoriesService.findAll();
	}
	/*
	 Cung cấp thông tin về người dùng đã đăng nhập
	 */
	@ModelAttribute("userLogined")
	public User getUserLogined() {
		// Lấy thông tin người dùng đã được xác thực với spring security
		Object userLogined=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userLogined != null && userLogined instanceof UserDetails) {
			// Kiểm tra object userLogined là 1 kiểu đối tượng UserDetails thì ép kiểu về User
			return (User) userLogined;
		}
		return new User();
	}

	public void isLogin(final HttpServletRequest request, final HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object userLogined=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("user", userLogined);
	}
}
