package pl.walaszczyk.restdemo.shared.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(Long id) {
        super("There is an object with the given id: ".concat(id.toString()));
    }
}
