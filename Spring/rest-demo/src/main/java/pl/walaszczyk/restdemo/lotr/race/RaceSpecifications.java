package pl.walaszczyk.restdemo.lotr.race;

import org.springframework.data.jpa.domain.Specification;

public class RaceSpecifications {

    public static Specification<Race> hasId(Long id) {
        return (root, query, criteriaBuilder) -> {
            if (id != null) return criteriaBuilder.equal(root.get("id"), id);
            return null;
        };
    }

    public static Specification<Race> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name != null) return criteriaBuilder.equal(root.get("name"), name);
            return null;
        };
    }
}
