package br.com.alive_lens.ui.adapters.public_user_status;

import br.com.alive_lens.R;
import br.com.alive_lens.class_utils.SkeletonAdapter;

public class PublicUserStatusAdapterSkeleton extends SkeletonAdapter {
    @Override
    public int getSkeletonLayoutRes() {
        return R.layout.public_user_status_item_skeleton;
    }

    @Override
    public int getSkeletonItemsLength() {
        return 10;
    }
}
