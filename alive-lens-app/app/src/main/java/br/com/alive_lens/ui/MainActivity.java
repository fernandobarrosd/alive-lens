package br.com.alive_lens.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.com.alive_lens.R;
import br.com.alive_lens.ui.auth.AuthActivity;
import br.com.alive_lens.ui.authenticated.AuthenticatedActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isAuthenticated()) {
            startActivity(new Intent(this, AuthenticatedActivity.class));
        }
        else {
            startActivity(new Intent(this, AuthActivity.class));
        }
        finish();
    }

    private boolean isAuthenticated() {
        return sharedPreferences.getBoolean("IS_AUTHENTICATED", false);
    }
}