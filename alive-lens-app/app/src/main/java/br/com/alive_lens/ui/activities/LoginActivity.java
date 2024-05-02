package br.com.alive_lens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.alive_lens.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    @Override
    protected void onResume() {
        super.onResume();

        binding.textGoToCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
        });

        binding.btnLoginEmailAndPassword.setOnClickListener(view -> {
            binding.btnLoginEmailAndPassword.showLoading();
            binding.btnLoginEmailAndPassword.disable();
        });
    }

}
