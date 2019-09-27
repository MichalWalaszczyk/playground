package pl.walaszczyk.restdemo.lotr.breed.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.walaszczyk.restdemo.lotr.race.RaceRepository;
import pl.walaszczyk.restdemo.shared.exceptions.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("members")
public class BreedMemberController {

    private final BreedMemberRepository breedMemberRepository;
    private final RaceRepository raceRepository;

    public BreedMemberController(BreedMemberRepository breedMemberRepository, RaceRepository raceRepository) {
        this.breedMemberRepository = breedMemberRepository;
        this.raceRepository = raceRepository;
    }

    @GetMapping()
    public List<BreedMemberDTO> getByName(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return this.breedMemberRepository.findBreedMemberDTOByFirstNameOrLastName(name, name);
        } else {
            return this.breedMemberRepository.findAllBreedMemberDTOBy();
        }
    }

    @PostMapping()
    ResponseEntity<BreedMemberDTO> newEmployee(@RequestBody BreedMemberDTO dto) {
        if (this.breedMemberRepository.existsById(dto.getId())) throw new EntityAlreadyExistsException(dto.getId());
        return new ResponseEntity<BreedMemberDTO>(new BreedMemberDTO(this.breedMemberRepository.save(new BreedMember(dto))), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<BreedMemberDTO> one(@PathVariable Long id) {
        BreedMember foundedBreedMember = this.breedMemberRepository.findById(id)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException(id);
                });
        return ResponseEntity.ok(new BreedMemberDTO(foundedBreedMember));
    }

    @PutMapping("{id}")
    ResponseEntity<BreedMemberDTO> replaceEmployee(@PathVariable Long id, @RequestBody BreedMemberDTO employee) {
        BreedMember foundedBreedMember = this.breedMemberRepository.findById(id)
                .map(foundEmployee -> {
                    foundEmployee.setFirstName(employee.getFirstName());
                    foundEmployee.setLastName(employee.getLastName());
                    foundEmployee.setRace(this.raceRepository.findById(employee.getRace().getId()).orElse(null));
                    return this.breedMemberRepository.save(foundEmployee);
                })
                .orElseThrow(() -> {
                    throw new EntityNotFoundException(id);
                });
        return ResponseEntity.ok(new BreedMemberDTO(foundedBreedMember));
    }

    @DeleteMapping("{id}")
    ResponseEntity deleteEmployee(@PathVariable Long id) {
        this.breedMemberRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("raceName/{raceName}")
    List<BreedMemberDTO> findByRaceName(@PathVariable String raceName) {
        return this.breedMemberRepository.findBreedMemberDTOByRaceName(raceName, new Sort(Sort.Direction.ASC, "lastName"));
    }
}
