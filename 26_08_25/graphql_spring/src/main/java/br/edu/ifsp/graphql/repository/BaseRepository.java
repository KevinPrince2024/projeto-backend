package br.edu.ifsp.graphql.repository;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.NotFound;

public abstract class BaseRepository<Type> {
    public abstract List<Type> findAll();
    public abstract Optional<Type> findById(String id) throws NotFound;
    public abstract Type save(Type object);
    public abstract Type update(Type object) throws NotFound;
    public abstract void delete(String id) throws NotFound;
}
