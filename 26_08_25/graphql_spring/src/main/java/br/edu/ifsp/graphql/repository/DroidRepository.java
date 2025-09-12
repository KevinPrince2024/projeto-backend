package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;

import br.edu.ifsp.graphql.model.Droid;

public class DroidRepository extends BaseRepository<Droid> {
    private final List<Droid> droids;

    public DroidRepository() {
        this.droids = new ArrayList<>();
    }

    @Override
    public List<Droid> findAll() {
        return this.droids;
    }

    @Override
    public Optional<Droid> findById(String id) throws NotFound {
        return this.droids.stream()
            .filter(d-> d.getId() == id)
            .findFirst();
    }

    @Override
    public Droid save(Droid droid) {
        this.droids.add(droid);

        return droid;
    }

    @Override
    public Droid update(Droid droid) throws NotFound {
        int index = this.droids.indexOf(droid);

        if (index <= 0) throw new NotFound("Post não encontrado!");

        this.droids.set(index, droid);

        return this.droids.get(index);
    }

    @Override
    public void delete(String id) throws NotFound {
        int index = this.droids.indexOf(id);

        if (index < 0) throw new NotFound("Droid não encontrado!");

        this.droids.remove(index);
    }
}
