package ua.babiy.online_store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.babiy.online_store.entity.Category;
import ua.babiy.online_store.entity.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllByCategoryId(Long categoryId);
    Optional<Product> findProductById(Long id);
    List<Product> findAll();
    void saveProduct(Product product);
    List<Category> findAllCategory();
    void saveCategory(Category category);
    List<Product> sortProductsBy(List<Product> products, String sortBy);

    Page<Product> findAllByCategoryIdAndSorted(Long categoryId, String sortBy, Pageable pageable);
}
