package ai.ecma.apppdpfoodbot.repository;

import ai.ecma.apppdpfoodbot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}