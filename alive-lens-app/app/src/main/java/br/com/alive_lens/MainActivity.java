package br.com.alive_lens;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
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
            navigateToOtherActivity(AuthenticatedActivity.class);
        }
        else {
            navigateToOtherActivity(LoginActivity.class);
        }
    }

    private boolean isAuthenticated() {
        FirebaseAuth firebaseAuth = FirebaseServices.getFirebaseAuth();
        return firebaseAuth.getCurrentUser() != null;
    }

    public void navigateToOtherActivity(Class<?> activityClass) {
        startActivity(new Intent(this, activityClass));
        finish();
    }

}