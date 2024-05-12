package br.com.alive_lens.class_utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ActivityViewBinding<T extends ViewBinding> extends AppCompatActivity {
    protected T binding;

    abstract public Class<T> getViewBindingClass();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = executeInflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @SuppressWarnings("unchecked")
    private T executeInflate(LayoutInflater layoutInflater) {
        Class<T> viewBindingClass = getViewBindingClass();
        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class);
            return (T) method.invoke(null, layoutInflater);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}