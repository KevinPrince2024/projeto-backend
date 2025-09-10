package br.edu.ifsp.bra.rest_api.service;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.bra.rest_api.exception.BadRequest;
import br.edu.ifsp.bra.rest_api.exception.NotFound;
import br.edu.ifsp.bra.rest_api.model.Post;
import br.edu.ifsp.bra.rest_api.repository.PostRepository;

public class PostService {
    private PostRepository postRepository;
    
    public PostService(PostRepository postRepo) {
        this.postRepository = postRepo;
    }

    public List<Post> getAllPosts() {
        return this.postRepository.getAll();
    }

    public Post createPost(Post post) {
        return this.postRepository.create(post);
    }

    public Optional<Post> getPostById(int id) throws NotFound, BadRequest {
        if (id <= 0) throw new BadRequest("Id é requerido!");

        Optional<Post> post = this.postRepository.getById(id);

        if (post == null) throw new NotFound("Post não encontrado! Tente outro id");

        return post;
    }

    public Post updatePost(Post post, int id) throws NotFound, BadRequest {
        if (id <= 0) throw new BadRequest("Id é requerido!");

        return this.postRepository.update(post, id);
    }

    public void deletePost(int id) {
        this.postRepository.deleteById(id);
    }
}
