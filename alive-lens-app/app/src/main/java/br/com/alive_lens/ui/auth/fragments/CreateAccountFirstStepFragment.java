package br.com.alive_lens.ui.auth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import br.com.alive_lens.databinding.FragmentCreateAccountFirstStepBinding;

public class CreateAccountFirstStepFragment extends Fragment {
    private FragmentCreateAccountFirstStepBinding binding;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateAccountFirstStepBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
