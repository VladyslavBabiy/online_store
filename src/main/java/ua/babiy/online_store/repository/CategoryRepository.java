package ua.babiy.online_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.babiy.online_store.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
