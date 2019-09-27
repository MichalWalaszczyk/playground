package pl.walaszczyk.restdemo.shared.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("Could not find entity with id: ".concat(id.toString()));
    }
}
