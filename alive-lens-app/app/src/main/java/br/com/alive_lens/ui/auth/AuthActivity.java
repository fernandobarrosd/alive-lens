package br.com.alive_lens.ui.auth;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.alive_lens.databinding.ActivityAuthBinding;
import lombok.Getter;
import lombok.Setter;

public class AuthActivity extends AppCompatActivity {
    private ActivityAuthBinding binding;
    @Getter @Setter
    private String username, email, password, photoURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}