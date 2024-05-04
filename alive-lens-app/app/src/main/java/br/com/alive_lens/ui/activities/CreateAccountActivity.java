package br.com.alive_lens.ui.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;
import br.com.alive_lens.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends AppCompatActivity {
    private ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.btnContinue.setOnClickListener(view -> {

        });
    }

    private boolean isEmail(@NonNull String text) {
        return text.matches("[a-z][a-zA-Z0-9-_.]+@[a-z]+\\.[a-z]+(\\.[a-z]+)*");
    }
}
