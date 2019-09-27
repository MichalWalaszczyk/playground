package pl.walaszczyk.restdemo.lotr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.walaszczyk.restdemo.lotr.breed.member.BreedMember;
import pl.walaszczyk.restdemo.lotr.breed.member.BreedMemberRepository;
import pl.walaszczyk.restdemo.lotr.race.Race;
import pl.walaszczyk.restdemo.lotr.race.RaceRepository;
import pl.walaszczyk.restdemo.shared.CustomSimpleJpaRepositoryImpl;

@Configuration
@Slf4j
@EnableJpaRepositories(repositoryBaseClass = CustomSimpleJpaRepositoryImpl.class)
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(RaceRepository raceRepository, BreedMemberRepository breedMemberRepository) {
        return args -> {
            Race hobbit = new Race("Hobbit");
            Race human = new Race("Human");
            raceRepository.save(hobbit);
            raceRepository.save(human);
            log.info("Preloading ".concat(hobbit.toString()));
            BreedMember bilbo = breedMemberRepository.save(new BreedMember("Bilbo", "Baggins", hobbit));
            BreedMember frodo = breedMemberRepository.save(new BreedMember("Frodo", "Baggins", hobbit));
            log.info("Preloading ".concat(bilbo.toString()));
            log.info("Preloading ".concat(frodo.toString()));
            BreedMember gandalf = breedMemberRepository.save(new BreedMember("Gandalf", "White", human));
            BreedMember aragorn = breedMemberRepository.save(new BreedMember("Aragorn", "Obieżyświat", human));
            log.info("Preloading ".concat(gandalf.toString()));
            log.info("Preloading ".concat(aragorn.toString()));
        };
    }
}
