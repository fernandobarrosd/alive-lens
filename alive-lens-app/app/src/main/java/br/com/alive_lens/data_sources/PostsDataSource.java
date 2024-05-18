package br.com.alive_lens.data_sources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import br.com.alive_lens.ui.models.PostListItem;
import br.com.alive_lens.ui.models.PostOwner;

public class PostsDataSource {
    private static PostsDataSource postsDataSource;
    private final List<PostListItem> posts = new ArrayList<>();

    private PostsDataSource() {
        int randomLike = 0;

        PostOwner postOwner = PostOwner.builder()
                .setId(randomID())
                .setUsername("fernandobarrosd")
                .setPhoto("https://github.com/fernandobarrosd.png")
                .build();

        for (int i = 0; i < 20; i ++) {
            randomLike = new Random().nextInt(4000 + 1);
            PostListItem postListItem = PostListItem.builder()
                    .setId(randomID())
                    .setContent("Post " + i)
                    .setMediaURL("https://github.com/fernandobarrosd.png")
                    .setLikes(randomLike)
                    .setPostOwner(postOwner)
                    .build();
            posts.add(postListItem);
        }
    }



    public List<PostListItem> findAllPosts() {
        return posts;
    }

    private String randomID() {
        return UUID.randomUUID().toString();
    }


    public static PostsDataSource getInstance() {
        if (postsDataSource == null) {
            postsDataSource = new PostsDataSource();
        }
        return postsDataSource;
    }


}