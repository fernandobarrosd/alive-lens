package br.com.alive_lens.ui.adapters.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import br.com.alive_lens.databinding.PostItemBinding;
import br.com.alive_lens.ui.models.PostListItem;
import br.com.alive_lens.ui.models.PostOwner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private final List<PostListItem> posts;

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding binding = PostItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder postViewHolder, int position) {
        PostListItem post = posts.get(position);
        postViewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



    public static class PostViewHolder extends RecyclerView.ViewHolder {
        private final PostItemBinding binding;
        public PostViewHolder(@NonNull PostItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PostListItem post) {
            PostOwner postOwner = post.getPostOwner();
            String postOwnerUsername = postOwner.getUsername();
            String postOwnerPhoto = postOwner.getPhoto();
            String likeText = post.getLikes().toString() + " ";

            binding.postContent.setText(post.getContent());
            setupImageViewImageURL(binding.postOwnerProfile, postOwnerPhoto);
            binding.postOwnerUsername.setText(postOwnerUsername);

            if (post.getLikes() == 0) {
                binding.likesNumberText.setVisibility(View.GONE);
            }
            else {
                if (post.getLikes() == 1) {
                    likeText += "curtiu isso";
                }
                else {
                    likeText += "curtiram isso";
                }
                binding.likesNumberText.setText(likeText);
            }
        }

        private void setupImageViewImageURL(ImageView imageView, String imageURL) {
            Glide.with(binding.getRoot())
                    .load(imageURL)
                    .into(imageView);
        }
    }
}
