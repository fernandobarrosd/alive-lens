package br.com.alive_lens.ui.models;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PublicUserStatus {
    private String ownerID;
    private String ownerPhoto;
    private String ownerUsername;
}