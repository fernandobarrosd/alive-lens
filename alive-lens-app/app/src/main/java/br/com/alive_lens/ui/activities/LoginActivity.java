package br.com.alive_lens.ui.activities;

import android.content.Intent;
import br.com.alive_lens.class_utils.ActivityViewBinding;
import br.com.alive_lens.databinding.ActivityLoginBinding;

public class LoginActivity extends ActivityViewBinding<ActivityLoginBinding> {
    @Override
    public Class<ActivityLoginBinding> getViewBindingClass() {
        return ActivityLoginBinding.class;
    }


    @Override
    protected void onResume() {
        super.onResume();
        binding.textGoToCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);

            binding.btnLoginEmailAndPassword.removeLoading();
            binding.btnLoginEmailAndPassword.enable();
        });

        binding.btnLoginEmailAndPassword.setOnClickListener(view -> {
            binding.btnLoginEmailAndPassword.showLoading();
            binding.btnLoginEmailAndPassword.disable();
        });
    }

}
