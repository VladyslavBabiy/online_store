package ua.babiy.online_store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.babiy.online_store.entity.User;
import ua.babiy.online_store.service.UserService;


import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String adminHome() {
        return "/admin/admin_home";
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/admin/users";
    }

    @GetMapping("/users/delete")
    public String removeUser(@RequestParam("userId") Long userId) throws Exception {
        Optional<User> userFromDB = userService.findById(userId);
        User user = userFromDB.orElseThrow(Exception::new);
        userService.delete(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/block")
    public String blockUser(@RequestParam("userId") Long userId) {
        userService.blockUser(userId);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/unblock")
    public String unBlockUser(@RequestParam("userId") Long userId) {
        userService.unblockUser(userId);
        return "redirect:/admin/users";
    }

    @GetMapping("/account")
    public String editOwnAccount(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "/admin/admin_account";
    }

    // TODO: 1. Make validation of fields. 2. Adjust Method
    @PostMapping("/account/{userId}")
    public String updateUserInfo(@AuthenticationPrincipal User user,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String password) {

        userService.updateUser(user, firstName, lastName, password);
        return "redirect:/admin";
    }

}
