package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.repository.StarshipRepository;

public class StarshipService extends BaseService<Starship> {
    private final StarshipRepository starshipRepository;

    public StarshipService(StarshipRepository starshipRepo) {
        this.starshipRepository = starshipRepo;
    }

    @Override
    public List<Starship> findAll() {
        return this.starshipRepository.findAll();
    }

    @Override
    public Optional<Starship> findById(String id) throws NotFound {
        return this.starshipRepository.findById(id);
    }

    @Override
    public Starship save(Starship starship) {
        return this.starshipRepository.save(starship);
    }

    @Override
    public Starship update(Starship starship) throws NotFound {
        return this.starshipRepository.update(starship);
    }

    @Override
    public void delete(String id) throws NotFound {
        this.starshipRepository.delete(id);
    }
}
