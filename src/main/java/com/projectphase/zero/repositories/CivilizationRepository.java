package com.projectphase.zero.repositories;
import com.projectphase.zero.models.Civilization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CivilizationRepository extends CrudRepository<Civilization, Long> {

}
