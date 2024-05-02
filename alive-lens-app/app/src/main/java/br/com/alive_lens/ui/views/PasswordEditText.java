package br.com.alive_lens.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import br.com.alive_lens.R;
import br.com.alive_lens.databinding.LayoutPasswordEditTextBinding;

public class PasswordEditText extends ConstraintLayout {
    private LayoutPasswordEditTextBinding binding;
    private boolean isPasswordType;

    public PasswordEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        binding = LayoutPasswordEditTextBinding.inflate(
                LayoutInflater.from(context),
                this,
                false
        );
        addView(binding.getRoot());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        binding.passwordVisibilityIcon.setOnClickListener(view -> {
            Log.d("OnClick Eye", String.valueOf(binding.passwordEditText.getInputType()));
            if (isPasswordType) {
                updatePasswordState(PasswordTransformationMethod.getInstance(), R.drawable.eye_slash_icon);
                isPasswordType = false;
            }
            else {
                updatePasswordState(HideReturnsTransformationMethod.getInstance(), R.drawable.eye_icon);
                isPasswordType = true;
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void updatePasswordState(TransformationMethod transformationMethod, @DrawableRes int drawableIcon) {
        binding.passwordEditText.setTransformationMethod(transformationMethod);
        binding.passwordVisibilityIcon.setImageResource(drawableIcon);
    }


    public Editable getText() {
        return binding.passwordEditText.getText();
    }
}