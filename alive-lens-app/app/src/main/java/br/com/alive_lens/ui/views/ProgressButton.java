package br.com.alive_lens.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import br.com.alive_lens.R;
import br.com.alive_lens.databinding.LayoutProgressButtonBinding;

public class ProgressButton extends LinearLayoutCompat {
    private LayoutProgressButtonBinding binding;
    private TypedArray typedArray;

    public ProgressButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBinding(context);
        initTypedArray(context, attrs);
        setupUI();
    }




    private void initBinding(Context context) {
        binding = LayoutProgressButtonBinding.inflate(
                LayoutInflater.from(context),
                this,
                false
        );
        addView(binding.getRoot());
    }

    private void initTypedArray(Context context, AttributeSet attrs) {
        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressButton);
        }
    }

    private void setupUI() {
        String buttonText = typedArray.getString(R.styleable.ProgressButton_buttonText);
        typedArray.recycle();
        removeLoading();

        if (buttonText != null) {
            binding.buttonText.setText(buttonText);
        }
    }

    private void disable() {
        setClickable(false);
        setActivated(false);
    }

    private void enable() {
        setClickable(true);
        setActivated(true);
    }


    public void showLoading() {
        binding.buttonText.setVisibility(GONE);
        binding.progressBar.setVisibility(VISIBLE);
        disable();
    }

    public void removeLoading() {
        binding.buttonText.setVisibility(VISIBLE);
        binding.progressBar.setVisibility(GONE);
        enable();
    }
}