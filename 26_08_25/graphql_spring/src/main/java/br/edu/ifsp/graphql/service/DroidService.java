package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.repository.DroidRepository;

public class DroidService extends BaseService<Droid> {
    private final DroidRepository droidRepository;

    public DroidService(DroidRepository droidRepo) {
        this.droidRepository = droidRepo;
    }

    @Override
    public List<Droid> findAll() {
        return this.droidRepository.findAll();
    }

    @Override
    public Optional<Droid> findById(String id) {
        return this.droidRepository.findById(id);
    }

    @Override
    public Droid save(Droid droid) {
        return this.droidRepository.save(droid);
    }

    @Override
    public Droid update(Droid droid) throws NotFound {
        return this.droidRepository.update(droid);
    }

    @Override
    public void delete(String id) {
        this.droidRepository.delete(id);
    }
}
