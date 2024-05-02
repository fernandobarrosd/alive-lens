package br.com.alive_lens;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import br.com.alive_lens.ui.activities.AuthenticatedActivity;
import br.com.alive_lens.ui.activities.LoginActivity;
import br.com.alive_lens.ui.view_models.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(
                this
        ).get(MainViewModel.class);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mainViewModel.isAuthenticated().observe(this, isAuthenticated -> {
            if (isAuthenticated) {
                navigateToOtherActivity(AuthenticatedActivity.class);
            }
            else {
                navigateToOtherActivity(LoginActivity.class);
            }
        });

    }
    public void navigateToOtherActivity(Class<?> activityClass) {
        startActivity(new Intent(this, activityClass));
        finish();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mainViewModel.checkIsAuthenticated();
    }
}