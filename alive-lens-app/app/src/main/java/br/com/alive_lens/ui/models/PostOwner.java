package br.com.alive_lens.ui.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PostOwner {
    private String id;
    private String username;
    private String photo;
}