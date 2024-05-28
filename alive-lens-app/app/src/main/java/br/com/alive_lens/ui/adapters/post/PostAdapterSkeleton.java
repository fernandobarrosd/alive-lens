package br.com.alive_lens.ui.adapters.post;

import br.com.alive_lens.ui.adapters.SkeletonAdapter;
import br.com.alive_lens.R;

public class PostAdapterSkeleton extends SkeletonAdapter {
    @Override
    public int getSkeletonLayoutRes() {
        return R.layout.post_item_skeleton;
    }

    @Override
    public int getSkeletonItemsLength() {
        return 5;
    }
}



