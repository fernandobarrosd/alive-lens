package br.com.alive_lens.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import br.com.alive_lens.R;
import br.com.alive_lens.class_utils.ActivityUtils;
import br.com.alive_lens.class_utils.FirebaseServices;
import br.com.alive_lens.ui.activities.LoginActivity;
import br.com.alive_lens.ui.authenticated.AuthenticatedActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (isAuthenticated()) {
            ActivityUtils.navigateToActivity(this, AuthenticatedActivity.class);
        }
        else {
            ActivityUtils.navigateToActivity(this, LoginActivity.class);
        }
        finish();
    }

    private boolean isAuthenticated() {
        FirebaseAuth firebaseAuth = FirebaseServices.getFirebaseAuth();
        return firebaseAuth.getCurrentUser() != null;
    }



}