package wei.springFramework.repositories;

import org.springframework.data.repository.CrudRepository;
import wei.springFramework.models.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String uom);

}
