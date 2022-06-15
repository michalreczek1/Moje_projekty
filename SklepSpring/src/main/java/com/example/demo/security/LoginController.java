package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/whoami")
    public String whoAmI(Authentication authentication, Model model) {
        // Zamiast wstrzykiwania parametru można też tak:
        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("userName", authentication.getName());
            model.addAttribute("authorities", authentication.getAuthorities());
        }
        return "whoami";
    }
}



