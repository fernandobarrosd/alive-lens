package br.com.alive_lens.ui.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import static androidx.navigation.NavController.OnDestinationChangedListener;

import java.util.HashMap;
import java.util.Map;

import br.com.alive_lens.databinding.ActivityAuthenticatedBinding;

public class AuthenticatedActivity extends AppCompatActivity implements OnDestinationChangedListener {
    private ActivityAuthenticatedBinding binding;
    private static final Map<String, String> TOOLBAR_TITLES = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthenticatedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initToolbarTitles();
        initNavigation();
    }

    private void initToolbarTitles() {
        TOOLBAR_TITLES.put("home", "Página inicial");
        TOOLBAR_TITLES.put("messages", "Mensagens");
        TOOLBAR_TITLES.put("profile", "Perfil");
    }


    private void initNavigation()  {
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(binding.fragmentContainerView.getId());

        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        navController.addOnDestinationChangedListener(this);

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);
    }


    @Override
    public void onDestinationChanged(
            @NonNull NavController navController,
            @NonNull NavDestination navDestination,
            @Nullable Bundle bundle) {
        assert navDestination.getRoute() != null;
        String toolbarTitle = TOOLBAR_TITLES.get(navDestination.getRoute());
        binding.toolbarTitle.setText(toolbarTitle);

    }
}