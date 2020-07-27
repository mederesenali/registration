package com.example.registration.controller;

import com.example.registration.exception.CustomerAlreadyRegisteredException;
import com.example.registration.model.User;
import com.example.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String firtsPage(){
        return "redirect:/login";
    }
    @GetMapping("/home")
    public String home(Model model, Principal principal){
        User user=userService.findByEmail(principal.getName());
         model.addAttribute("user", user);
        return "home";
    }
    @GetMapping("/login")
    public String loignPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model){
        model.addAttribute("error", error);

        return "login";
    }
    @GetMapping("/registration")
    public String register(){
        return "register";
    }
    @PostMapping("/registration")
    public String registerSubmit(@Valid User user,BindingResult bindingResult,
                                 RedirectAttributes attributes  ) throws CustomerAlreadyRegisteredException {
        attributes.addFlashAttribute("dto", user);

        if (bindingResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/registration";
        }
        userService.register(user);
        return "redirect:/login";
    }


}
