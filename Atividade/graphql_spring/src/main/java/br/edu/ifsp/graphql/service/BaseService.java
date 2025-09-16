package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.exceptions.BadRequest;
import br.edu.ifsp.graphql.exceptions.NotFound;

public abstract class BaseService<Type> {
    public abstract List<Type> findAll();
    public abstract Optional<Type> findById(String id) throws NotFound;
    public abstract Type save(Type object);
    public abstract Type update(Type object) throws NotFound, BadRequest;
    public abstract void delete(String id) throws NotFound;
}
