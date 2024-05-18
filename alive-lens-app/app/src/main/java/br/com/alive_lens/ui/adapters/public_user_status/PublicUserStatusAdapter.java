package br.com.alive_lens.ui.adapters.public_user_status;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import br.com.alive_lens.databinding.PublicUserStatusItemBinding;
import br.com.alive_lens.ui.models.PublicUserStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PublicUserStatusAdapter extends RecyclerView.Adapter<PublicUserStatusAdapter.PublicUserStatusViewHolder> {

    private final List<PublicUserStatus> publicUserStatuses;

    @NonNull
    @Override
    public PublicUserStatusAdapter.PublicUserStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PublicUserStatusItemBinding binding = PublicUserStatusItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new PublicUserStatusViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicUserStatusAdapter.PublicUserStatusViewHolder viewHolder, int position) {
        PublicUserStatus publicUserStatus = publicUserStatuses.get(position);
        viewHolder.bind(publicUserStatus);
    }


    @Override
    public int getItemCount() {
        return publicUserStatuses.size();
    }

    public static class PublicUserStatusViewHolder extends RecyclerView.ViewHolder {
        private final PublicUserStatusItemBinding binding;

        public PublicUserStatusViewHolder(@NonNull PublicUserStatusItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PublicUserStatus publicUserStatus) {
            Glide.with(binding.getRoot())
                    .load(publicUserStatus.getOwnerPhoto())
                    .into(binding.statusOwnerProfile);

            binding.statusOwnerUsername.setText(publicUserStatus.getOwnerUsername());
        }
    }

}
