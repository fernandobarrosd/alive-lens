package br.com.alive_lens.ui.authenticated.fragments;

import br.com.alive_lens.class_utils.FragmentViewBinding;
import br.com.alive_lens.databinding.FragmentHomeBinding;

public class HomeFragment extends FragmentViewBinding<FragmentHomeBinding> {
    @Override
    public Class<FragmentHomeBinding> getViewBindingClass() {
        return FragmentHomeBinding.class;
    }
}