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
import org.springframework.validation.BindingResult;
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
    // Hiển thị giao diện đổi mật khẩu
    @GetMapping("/admin/change-password")
    public String showChangePasswordPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("username", currentPrincipalName);
        model.addAttribute("passwordForm", new ChangePasswordForm());
        return "administrator/change_password";
    }

    //    @PostMapping("/admin/change-password")
//    public String processChangePassword(
//            @ModelAttribute("passwordForm") ChangePasswordForm passwordForm,
//            RedirectAttributes redirectAttributes,
//            Model model) {
//
//        User user = userService.getCurrentUser();
//
//        if (user != null && passwordEncoder.matches(passwordForm.getCurrentPassword(), user.getPassword())) {
//            if (passwordForm.getNewPassword().equals(passwordForm.getConfirmPassword())) {
//                // Update password logic with encoding
//                user.setPassword(passwordEncoder.encode(passwordForm.getNewPassword()));
//                userService.save(user);
//                redirectAttributes.addFlashAttribute("successMessage", "Password changed successfully!");
//                return "redirect:/admin/change-password";
//            } else {
//                model.addAttribute("error", "New password does not match confirm password.");
//            }
//        } else {
//            model.addAttribute("error", "Incorrect current password.");
//        }
//        return "administrator/change_password";
//    }
    //Thao tác với việc thay đổi mật khẩu
    @PostMapping("/admin/change-password")
    public String processChangePassword(
            @ModelAttribute("passwordForm") ChangePasswordForm passwordForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {

        User user = userService.getCurrentUser();

        if (user != null && passwordEncoder.matches(passwordForm.getCurrentPassword(), user.getPassword())) {
            if (passwordForm.getNewPassword().equals(passwordForm.getConfirmPassword())) {
                // Để cập nhật mật khẩu với mã hóa
                user.setPassword(passwordEncoder.encode(passwordForm.getNewPassword()));
                userService.save(user);
//                redirectAttributes.addFlashAttribute("successMessage", "Password changed successfully!");
                return "redirect:/admin/change-password?successPasswordChange=true";
            } else {
//                bindingResult.rejectValue("confirmPassword", "error.user", "New password does not match confirm password.");
                return "redirect:/admin/change-password?confirmPassword_error=true";
            }
        } else {
//            bindingResult.rejectValue("currentPassword", "error.user", "Incorrect current password.");
            redirectAttributes.addFlashAttribute("changepw_error", "true");
            //Mật khẩu cũ không đúng
            return "redirect:/admin/change-password?changepw_error=true";
        }
//        return "administrator/change_password";
    }

}
