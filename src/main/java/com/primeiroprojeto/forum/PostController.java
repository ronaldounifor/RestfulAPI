package com.primeiroprojeto.forum;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojeto.model.Post;

@RestController
@RequestMapping("/posts")
public class PostController {
    private Post post = new Post("Primeiro Post", "Corpo do primeiro post");

    @GetMapping("/titulo")
    public String getTitulo() {
        StringBuilder builder = new StringBuilder(post.getTitulo());
        builder.append(": ");
        builder.append(post.getCorpo());
        return builder.toString();
    }

    // @GetMapping("{id}")
    // public String getTitulo(String id) {
    //     int postID = Integer.parseInt(id);
    //     return posts.get(postID).getTitulo();
    // }

    @PostMapping("/")
    public String createPost(@RequestBody Post post) {
        this.post = post;
        return "Post criado com sucesso";
    }

    @PutMapping("/")
    public String updatePost(@RequestBody Post post) {
        this.post = post;
        return "Post atualizado com sucesso";
    }

    @DeleteMapping("/")
    public String deletePost() {
        post = null;
        return "Post deletado com sucesso";
    }


}
