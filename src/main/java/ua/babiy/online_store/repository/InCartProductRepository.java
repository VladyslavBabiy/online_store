package ua.babiy.online_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.babiy.online_store.entity.Cart;
import ua.babiy.online_store.entity.InCartProduct;

import java.util.Optional;
import java.util.Set;

public interface InCartProductRepository extends JpaRepository<InCartProduct, Long> {
    Set<InCartProduct> findAllByCart(Cart cart);
    void deleteAllByCart(Cart cart);
    void deleteByCartAndProductId(Cart cart, Long productId);
    Optional<InCartProduct> findByCartAndProductId(Cart cart, Long productId);
}
