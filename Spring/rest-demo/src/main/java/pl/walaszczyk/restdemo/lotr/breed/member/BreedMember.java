package pl.walaszczyk.restdemo.lotr.breed.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.walaszczyk.restdemo.lotr.race.Race;
import pl.walaszczyk.restdemo.shared.BaseEntity;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name= "idSeq", sequenceName = "employee_id_seq")
public class BreedMember extends BaseEntity {

    private String firstName;
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "race_id", referencedColumnName="id")
    @JsonIgnore
    private Race race;

    public BreedMember(String firstName, String lastName, Race race) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.race = race;
    }

    public BreedMember(BreedMemberDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.race = new Race(dto.getRace());
    }

    @Override
    public String toString() {
        String var10000 = this.getFirstName();
        return "Employee(firstName=" + var10000 + ", lastName=" + this.getLastName() + ", race=" + this.getRace().getName() + ")";
    }
}
