package pl.walaszczyk.restdemo.lotr.breed.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.walaszczyk.restdemo.lotr.race.NameOnlyRaceDTO;

@Data
@NoArgsConstructor
public class BreedMemberDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private NameOnlyRaceDTO race;

    public BreedMemberDTO(BreedMember breedMember) {
        this.id = breedMember.getId();
        this.firstName = breedMember.getFirstName();
        this.lastName = breedMember.getLastName();
        this.race = new NameOnlyRaceDTO();
        this.race.setId(breedMember.getRace().getId());
        this.race.setName(breedMember.getRace().getName());
    }
}
