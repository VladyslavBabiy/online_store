package ua.babiy.online_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.babiy.online_store.entity.Cart;


public interface CartRepository extends JpaRepository<Cart, Long> {
}
