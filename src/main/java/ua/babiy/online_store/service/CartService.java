package ua.babiy.online_store.service;


import ua.babiy.online_store.entity.Product;
import ua.babiy.online_store.entity.User;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {
    void addProductToCart(User user, Long productId) throws Exception;
    void removeProductFromCart(User user, Long productId) throws Exception;
    Map<Product, Integer> getAllProductsInCart(User user);
    BigDecimal getTotal(Map<Product, Integer> productsWithNeededQuantity);
    void clearProductsFromCart(User user);
    void updateNeededQuantity(User user, Long productId, Integer neededQuantity) throws Exception;
}
