package wei.springFramework.repositories;

import org.springframework.data.repository.CrudRepository;
import wei.springFramework.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
