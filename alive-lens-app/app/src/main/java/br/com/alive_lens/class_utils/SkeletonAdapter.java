package br.com.alive_lens.class_utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SkeletonAdapter extends RecyclerView.Adapter<SkeletonAdapter.SkeletonViewHolder> {
    public abstract @LayoutRes int getSkeletonLayoutRes();
    public abstract int getSkeletonItemsLength();

    @NonNull
    @Override
    public SkeletonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getSkeletonLayoutRes(), parent, false);
        return new SkeletonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkeletonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return getSkeletonItemsLength();
    }

    public static class SkeletonViewHolder extends RecyclerView.ViewHolder {
        public SkeletonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
