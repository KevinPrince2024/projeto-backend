package br.edu.ifsp.bra.rest_api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.bra.rest_api.exception.NotFound;
import br.edu.ifsp.bra.rest_api.model.Post;

public class PostRepository {
    private final List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<Post>();
    }

    public List<Post> getAll() {
        return this.posts;
    }

    public Post create(Post post) {
        this.posts.add(post);

        return this.posts.getLast();
    }

    public Optional<Post> getById(int id) {
        return this.posts
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst();
    }

    public Post update(Post post, int id) throws NotFound {
        int index = this.posts.indexOf(post);

        if (index <= 0) throw new NotFound("Post não encontrado!");

        this.posts.set(index, post);

        return this.posts.get(index);
    }

    public void deleteById(int id) {
        this.posts.remove(id);
    }
}
