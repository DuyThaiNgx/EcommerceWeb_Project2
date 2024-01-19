package com.selena.controller.administrator;

import com.selena.controller.BaseController;
import com.selena.dto.ChangePasswordForm;
import com.selena.model.User;
import com.selena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AdminChangePasswordController extends BaseController {
    private final UserService userService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AdminChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/change-password")
    public String showChangePasswordPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("username", currentPrincipalName);
        model.addAttribute("passwordForm", new ChangePasswordForm());
        return "administrator/change_password";
    }

    @PostMapping("/admin/change-password")
    public String processChangePassword(
            @ModelAttribute("passwordForm") ChangePasswordForm passwordForm,
            RedirectAttributes redirectAttributes,
            Model model) {

        User user = userService.getCurrentUser();

        if (user != null && passwordEncoder.matches(passwordForm.getCurrentPassword(), user.getPassword())) {
            if (passwordForm.getNewPassword().equals(passwordForm.getConfirmPassword())) {
                // Update password logic with encoding
                user.setPassword(passwordEncoder.encode(passwordForm.getNewPassword()));
                userService.save(user);
                redirectAttributes.addFlashAttribute("successMessage", "Password changed successfully!");
                return "redirect:/admin/change-password";
            } else {
                model.addAttribute("error", "New password does not match confirm password.");
            }
        } else {
            model.addAttribute("error", "Incorrect current password.");
        }
        return "administrator/change_password";
    }
}
