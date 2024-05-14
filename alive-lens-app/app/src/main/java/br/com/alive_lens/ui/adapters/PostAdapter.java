package br.com.alive_lens.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.com.alive_lens.databinding.PostItemBinding;
import br.com.alive_lens.ui.models.PostListItem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private final List<PostListItem> posts;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding binding = PostItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {
        PostListItem post = posts.get(position);
        postViewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private PostItemBinding binding;
        public PostViewHolder(@NonNull PostItemBinding binding) {
            super(binding.getRoot());
        }

        public void bind(PostListItem post) {

        }
    }
}
