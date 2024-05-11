package br.com.alive_lens.class_utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class FragmentViewBinding<T extends ViewBinding> extends Fragment {
    protected T binding;
    public abstract Class<T> getViewBindingClass();

    private T executeInflate(LayoutInflater layoutInflater, ViewGroup container) {
        try {
            Class<T> viewBindingClass = getViewBindingClass();
            Method inflateMethod = viewBindingClass.getMethod(
                    "inflate",
                    LayoutInflater.class,
                    ViewGroup.class,
                    Boolean.class);
            return (T) inflateMethod.invoke(
                    null,
                    layoutInflater,
                    container,
                    false);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = executeInflate(inflater, container);
        return binding.getRoot();
    }




}