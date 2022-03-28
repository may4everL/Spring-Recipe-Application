package wei.springFramework.repositories;

import org.springframework.data.repository.CrudRepository;
import wei.springFramework.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
