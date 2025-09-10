package br.edu.ifsp.bra.rest_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.rest_api.exception.BadRequest;
import br.edu.ifsp.bra.rest_api.exception.NotFound;
import br.edu.ifsp.bra.rest_api.model.Post;
import br.edu.ifsp.bra.rest_api.service.PostService;

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/postagens")
    List<Post> all() {
        return this.postService.getAllPosts();
    }

    @PostMapping("/postagens")
    Post newPost(@RequestBody Post post) {
        return this.postService.createPost(post);
    }

    @GetMapping("/postagens/{id}")
    Optional<Post> one(@PathVariable int id) throws NotFound, BadRequest {
        return this.postService.getPostById(id);
    }

    @PutMapping("/postagens/{id}")
    Post replacePost(@RequestBody Post post, @PathVariable int id) throws NotFound, BadRequest {
        return this.postService.updatePost(post, id);
    }

    @DeleteMapping("/postagens/{id}")
    void deletePost(@PathVariable int id) {
        this.postService.deletePost(id);
    }
}
