package pl.walaszczyk.restdemo.lotr.breed.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NameOnlyBreedMemberDTO {

    private Long id;
    private String firstName;
    private String lastName;

    public NameOnlyBreedMemberDTO(BreedMember breedMember) {
        this.id = breedMember.getId();
        this.firstName = breedMember.getFirstName();
        this.lastName = breedMember.getLastName();
    }
}
