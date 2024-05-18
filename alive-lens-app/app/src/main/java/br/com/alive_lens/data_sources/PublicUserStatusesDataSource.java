package br.com.alive_lens.data_sources;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.alive_lens.ui.models.PublicUserStatus;

public class PublicUserStatusesDataSource {
    private static PublicUserStatusesDataSource publicUserStatusesDataSource;
    private final List<PublicUserStatus> publicUserStatuses;

    private PublicUserStatusesDataSource() {
        publicUserStatuses = new ArrayList<>();

        for (int i = 0; i < 8; i ++) {
            PublicUserStatus publicUserStatus = PublicUserStatus.builder()
                    .setOwnerID(randomID())
                    .setOwnerUsername("fernandobarros")
                    .setOwnerPhoto("https://github.com/fernandobarrosd.png")
                    .build();
            publicUserStatuses.add(publicUserStatus);
        }
    }

    private String randomID() {
        return UUID.randomUUID().toString();
    }

    public List<PublicUserStatus> findAll() {
        return publicUserStatuses;
    }
    public static PublicUserStatusesDataSource getInstance() {
        if (publicUserStatusesDataSource == null) {
            publicUserStatusesDataSource = new PublicUserStatusesDataSource();
        }
        return publicUserStatusesDataSource;
    }
}
