package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.HumanRepository;

public class HumanService extends BaseService<Human> {
    private final HumanRepository humanRepository;

    public HumanService(HumanRepository humanRepo) {
        this.humanRepository = humanRepo;
    }

    @Override
    public List<Human> findAll() {
        return this.humanRepository.findAll();
    }

    @Override
    public Optional<Human> findById(String id) throws NotFound {
        return this.humanRepository.findById(id);
    }

    @Override
    public Human save(Human human) {
        return this.humanRepository.save(human);
    }

    @Override
    public Human update(Human human) throws NotFound {
        return this.humanRepository.update(human);
    }

    @Override
    public void delete(String id) throws NotFound {
        this.humanRepository.delete(id);
    }
}
