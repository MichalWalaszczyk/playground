package pl.walaszczyk.restdemo.lotr.race;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.walaszczyk.restdemo.lotr.breed.member.NameOnlyBreedMemberDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RaceDTO {

    private Long id;
    private String name;
    private List<NameOnlyBreedMemberDTO> employees;

    public RaceDTO(Race race) {
        this.id = race.getId();
        this.name = race.getName();
        this.employees = new ArrayList<NameOnlyBreedMemberDTO>();
        race.getBreedMembers().stream().forEach(employee -> {
            NameOnlyBreedMemberDTO dto = new NameOnlyBreedMemberDTO();
            dto.setId(employee.getId());
            dto.setFirstName(employee.getFirstName());
            dto.setLastName(employee.getLastName());
            this.employees.add(dto);
        });
    }
}
