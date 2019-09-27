package pl.walaszczyk.restdemo.lotr.race;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@RestController
@RequestMapping("races")
public class RaceController {

    private final RaceRepository raceRepository;

    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping
    public List<RaceDTO> getAll() {
        return this.raceRepository.findAllRaceDTOBy();
    }

    @GetMapping("{id}")
    public List<RaceDTO> getAllById(@PathVariable Long id) {
        return this.raceRepository.findRaceDTOById(id);
    }

    @PostMapping
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return ResponseEntity.ok(this.raceRepository.save(race));
    }

    @GetMapping("specifications")
    public List<RaceDTO> getBySpecifications(@RequestParam(value = "id", required = false) Long id,
                                             @RequestParam(value = "name", required = false) String name) {
        return this.raceRepository.findAll(Specification.where(RaceSpecifications.hasId(id).or(RaceSpecifications.hasName(name))));
    }

    @GetMapping("queryByExample")
    public List<RaceDTO> getByQueryByExample(@RequestParam(value = "name", required = false) String name) {
        Race race = new Race();
        if (name != null) race.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", contains().ignoreCase());
        Example<Race> example = Example.of(race, matcher);
        return this.raceRepository.findAll(example).stream().map(RaceDTO::new).collect(Collectors.toList());
    }
}
