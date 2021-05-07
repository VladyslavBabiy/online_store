package ua.babiy.online_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.babiy.online_store.entity.Order;
import ua.babiy.online_store.entity.OrderedProduct;

import java.util.Set;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {

    Set<OrderedProduct> findAllByOrder(Order order);
}
