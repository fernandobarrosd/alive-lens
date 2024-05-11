package br.com.alive_lens.ui.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.alive_lens.class_utils.ActivityViewBinding;
import br.com.alive_lens.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends ActivityViewBinding<ActivityCreateAccountBinding> {

    @Override
    public Class<ActivityCreateAccountBinding> getViewBindingClass() {
        return ActivityCreateAccountBinding.class;
    }

    private boolean isEmail(@NonNull String text) {
        return text.matches("[a-z][a-zA-Z0-9-_.]+@[a-z]+\\.[a-z]+(\\.[a-z]+)*");
    }
}
