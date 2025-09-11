package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;
import br.edu.ifsp.graphql.model.Human;

public class HumanRepository extends BaseRepository<Human> {
    private final List<Human> humans;

    public HumanRepository() {
        this.humans = new ArrayList<>();
    }

    @Override
    public List<Human> findAll() {
        return this.humans;
    }

    @Override
    public Optional<Human> findById(String id) {
        return this.humans.stream()
            .filter(d-> d.getId() == id)
            .findFirst();
    }

    @Override
    public Human save(Human human) {
        this.humans.add(human);

        return human;
    }

    @Override
    public Human update(Human human) throws NotFound {
        int index = this.humans.indexOf(human);

        if (index <= 0) throw new NotFound("Post não encontrado!");

        this.humans.set(index, human);

        return this.humans.get(index);
    }

    @Override
    public void delete(String id) {
        int index = this.humans.indexOf(id);

        this.humans.remove(index);
    }    
}
