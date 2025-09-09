package br.edu.ifsp.bra.rest_api.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Post> getById(int id) {
        return this.postRepository.getById(id);
    }

    public Post updatePost(Post post, int id) {
        return this.postRepository.updatePost(post, id);
    }

    public void deletePost(int id) {
        this.postRepository.deleteById(id);
    }
}
