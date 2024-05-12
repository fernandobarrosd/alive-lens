package br.com.alive_lens.class_utils;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public abstract class ActivityUtils {
    public static void navigateToActivity(@NonNull AppCompatActivity activity, Class<?> activityClass) {
        activity.startActivity(new Intent(activity, activityClass));
    }
}