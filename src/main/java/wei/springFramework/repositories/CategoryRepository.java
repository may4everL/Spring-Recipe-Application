package wei.springFramework.repositories;

import org.springframework.data.repository.CrudRepository;
import wei.springFramework.models.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
