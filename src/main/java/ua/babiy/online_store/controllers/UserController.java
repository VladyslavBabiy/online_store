package ua.babiy.online_store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.babiy.online_store.entity.Product;
import ua.babiy.online_store.entity.User;
import ua.babiy.online_store.service.ProductService;
import ua.babiy.online_store.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String userHome(@AuthenticationPrincipal User user, HttpServletRequest request, Model model) {
        String category = request.getParameter("category");
        String sortBy = request.getParameter("sortBy");
        if (sortBy == null) {
            sortBy = "nameAsc";
        }
        List<Product> products;
        if (category == null || category.equals("all")) {
            products = productService.findAll();
            products = productService.sortProductsBy(products, sortBy);
            category = "all";
        } else {
            Long categoryId = Long.valueOf(category);
            products = productService.findAllByCategoryId(categoryId);
            products = productService.sortProductsBy(products, sortBy);
        }
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        model.addAttribute("sortBy", sortBy);

        return "/user/user_home";
    }

    @GetMapping("/account")
    public String editOwnAccount(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "/user/user_account";
    }

    // TODO: 1. Make validation of fields.
    @PostMapping("/account/{userId}")
    public String updateUserInfo(@AuthenticationPrincipal User user,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String password) {
//        if (bindingResult.hasErrors())
//            return "user/user_account";

        userService.updateUser(user, firstName, lastName, password);
        return "redirect:/user/cart";
    }
}
