package br.com.alive_lens.ui.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "set")
public class PostListItem {
    private String id;
    private String content;
    private String mediaURL;
    private Integer likes;
    private PostOwner postOwner;
}