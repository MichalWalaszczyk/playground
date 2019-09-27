package pl.walaszczyk.restdemo.lotr.race;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long>, JpaSpecificationExecutor {

//    @Query("SELECT DISTINCT new pl.walaszczyk.restdemo.payroll.race.RaceDTO(r) FROM Race r " +
//            "LEFT JOIN r.employees " +
//            "WHERE r.id = ?1")
    List<RaceDTO> findRaceDTOById(Long id);

    List<RaceDTO> findAllRaceDTOBy();
}
