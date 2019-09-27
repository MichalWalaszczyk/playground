package pl.walaszczyk.restdemo.lotr.breed.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedMemberRepository extends JpaRepository<BreedMember, Long> {

    List<BreedMemberDTO> findAllBreedMemberDTOBy();

//        @Query("SELECT e FROM Employee e JOIN FETCH e.race r WHERE e.firstName = ?1 OR e.lastName = ?2")
    List<BreedMemberDTO> findBreedMemberDTOByFirstNameOrLastName(String firstName, String lastName);

    List<BreedMemberDTO> findBreedMemberDTOByRaceName(String raceName, Sort sort);

    // TODO: Stworzyć resty dla poniższych zapytań
    Page<BreedMemberDTO> findBreedMemberDTOByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);
}
