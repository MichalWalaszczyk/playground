package pl.walaszczyk.restdemo.lotr.race;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NameOnlyRaceDTO {

    private Long id;
    private String name;

    public NameOnlyRaceDTO(Race race) {
        this.id = race.getId();
        this.name = race.getName();
    }
}
