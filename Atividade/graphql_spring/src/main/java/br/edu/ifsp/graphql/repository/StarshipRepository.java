package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;
import br.edu.ifsp.graphql.model.Starship;

public class StarshipRepository extends BaseRepository<Starship> {
    private final List<Starship> starships;

    public StarshipRepository() {
        this.starships = new ArrayList<>();
    }

    @Override
    public List<Starship> findAll() {
        return this.starships;
    }

    @Override
    public Optional<Starship> findById(String id) throws NotFound {
        Optional<Starship> starship = this.starships.stream()
            .filter(d-> d.getId() == id)
            .findFirst();

        if (starship == null) throw new NotFound("Nave não encontrada!");

        return starship;
    }

    @Override
    public Starship save(Starship starship) {
        this.starships.add(starship);

        return starship;
    }

    @Override
    public Starship update(Starship starship) throws NotFound {
        int index = this.starships.indexOf(starship);

        if (index <= 0) throw new NotFound("Nave não encontrado!");

        this.starships.set(index, starship);

        return this.starships.get(index);
    }

    @Override
    public void delete(String id) throws NotFound {
        int index = this.starships.indexOf(id);

        if (index < 0) throw new NotFound("Nave não encontrado");

        this.starships.remove(index);
    }
}
