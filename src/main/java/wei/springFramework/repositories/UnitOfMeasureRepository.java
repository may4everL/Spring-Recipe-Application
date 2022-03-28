package wei.springFramework.repositories;

import org.springframework.data.repository.CrudRepository;
import wei.springFramework.models.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
