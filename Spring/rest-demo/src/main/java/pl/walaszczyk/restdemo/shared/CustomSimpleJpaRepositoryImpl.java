package pl.walaszczyk.restdemo.shared;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.walaszczyk.restdemo.shared.exceptions.*;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;


public class CustomSimpleJpaRepositoryImpl<T extends BaseEntity, Long extends Serializable> extends SimpleJpaRepository<T, Long> {

    public CustomSimpleJpaRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Transactional
    public void deleteById(Long id) throws RuntimeException {
        Optional<T> baseEntity = super.findById(id);
        baseEntity.ifPresentOrElse(entity -> {
            super.delete(entity);
        }, () -> {
            throw new EntityNotFoundException((java.lang.Long) id);
        });
    }
}
