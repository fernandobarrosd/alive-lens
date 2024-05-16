package br.com.alive_lens.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.com.alive_lens.databinding.PostItemBinding;
import br.com.alive_lens.ui.models.PostListItem;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import br.com.alive_lens.R;

@RequiredArgsConstructor
public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<PostListItem> posts;

    private boolean isSkeleton;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            PostItemBinding binding = PostItemBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            );
            return new PostViewHolder(binding);
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item_skeleton, parent, false);

        return new PostViewHolderSkeleton(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof PostViewHolder) {
            PostListItem post = posts.get(0);
            PostViewHolder postViewHolder = (PostViewHolder) viewHolder;
            postViewHolder.bind(post);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isSkeleton) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if (isSkeleton) {
            return 5;
        }
        return posts.size();
    }

    public void setSkeleton(boolean skeleton) {
        isSkeleton = skeleton;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private PostItemBinding binding;
        public PostViewHolder(@NonNull PostItemBinding binding) {
            super(binding.getRoot());
        }

        public void bind(PostListItem post) {

        }
    }

    public static class PostViewHolderSkeleton extends RecyclerView.ViewHolder {
        public PostViewHolderSkeleton(@NonNull View itemView) {
            super(itemView);
        }
    }
}
