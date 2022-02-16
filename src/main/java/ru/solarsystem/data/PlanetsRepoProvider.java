package ru.solarsystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.solarsystem.model.Planet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PlanetsRepoProvider implements PlanetsRepo {

    @Autowired
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Planet> findAll() {
        return (List<Planet>) em.createQuery("select p from planets p");
    }


    @Override
    public <S extends Planet> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Planet> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Planet> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Planet> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Planet entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Planet> entities) {

    }

    @Override
    public void deleteAll() {

    }

}
