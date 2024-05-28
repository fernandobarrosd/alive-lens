package br.com.alive_lens.ui.auth.fragments;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import br.com.alive_lens.R;
import br.com.alive_lens.class_utils.FirebaseServices;
import br.com.alive_lens.databinding.FragmentLoginBinding;
import br.com.alive_lens.ui.authenticated.AuthenticatedActivity;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        setupListeners();
    }

    private void setupListeners() {
        NavController navController = findNavController(this);

        binding.textGoToCreateAccount.setOnClickListener(view -> {
            navController.navigate(R.id.action_loginFragment_to_createAccountFirstStepFragment);
        });

        binding.btnLoginEmailAndPassword.setOnClickListener(view -> {
            String email = binding.emailEditText.getText().toString();
            String password = binding.passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                showSnackBar("Preencha os campos");
            }
            else {
                binding.btnLoginEmailAndPassword.showLoading();
                authenticateWithEmailAndPassword(email, password);
            }
        });
    }

    private void showSnackBar(String message) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show();
    }

    private void authenticateWithEmailAndPassword(String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseServices.getFirebaseAuth();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    sharedPreferences
                            .edit()
                            .putBoolean("IS_AUTHENTICATED", true)
                            .apply();

                    startActivity(new Intent(requireActivity(), AuthenticatedActivity.class));
                })
                .addOnFailureListener(exception -> showSnackBar("Usuário inexistente"))
                .addOnCompleteListener(authResult -> binding.btnLoginEmailAndPassword.removeLoading());
    }
}
