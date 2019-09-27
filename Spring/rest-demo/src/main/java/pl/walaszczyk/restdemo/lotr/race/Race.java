package pl.walaszczyk.restdemo.lotr.race;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.walaszczyk.restdemo.lotr.breed.member.BreedMember;
import pl.walaszczyk.restdemo.shared.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "idSeq", sequenceName = "role_id_seq")
public class Race extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private List<BreedMember> breedMembers;

    public Race(String name) {
        this.name = name;
    }

//    public Race(RaceDTO dto) {
//        this.name = dto.getName();
//        this.employees = dto.getEmployees().stream().map(Employee::new).collect(Collectors.toList());
//    }

    public Race(NameOnlyRaceDTO dto) {
        this.setId(dto.getId());
        this.name = dto.getName();
    }
}
