package com.projectphase.zero.repositories;
import com.projectphase.zero.models.Civilization;
import com.projectphase.zero.models.Result;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CivilizationRepository extends CrudRepository<Civilization, Long> {

    Civilization findById(int id);

    @Query(value = "select * from civilization where (army_type = 'The Conquerors')", nativeQuery = true)
    List<Civilization> listingFuckingConquerors();

}
