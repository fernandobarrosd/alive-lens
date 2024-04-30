package br.com.alive_lens;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import br.com.alive_lens.ui.activities.AuthenticatedActivity;
import br.com.alive_lens.ui.activities.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Class<?> activityClass;

        if (isAuthenticated()) {
            activityClass = AuthenticatedActivity.class;
        }
        else {
            activityClass = LoginActivity.class;
        }
        startActivity(new Intent(this, activityClass));
        finish();
    }

    private boolean isAuthenticated() {
        FirebaseAuth firebaseAuth = FirebaseServices.getFirebaseAuth();
        return firebaseAuth.getCurrentUser() != null;
    }
}