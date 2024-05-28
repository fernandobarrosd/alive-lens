package br.com.alive_lens.ui.authenticated;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

import br.com.alive_lens.databinding.ActivityAuthenticatedBinding;

public class AuthenticatedActivity extends AppCompatActivity {
    private ActivityAuthenticatedBinding binding;
    private NavController navController;

    private static final Map<String, String> TOOLBAR_TITLES = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthenticatedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initToolbarTitles();
        initToolbarTitle();
        setupNavController();
        setupNavControllerListener();
        setupBottomNavigationWithNavController();
    }

    private void setupNavController() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(binding.fragmentContainerView.getId());
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }

    private void initToolbarTitles() {
        TOOLBAR_TITLES.put("home", "Página inicial");
        TOOLBAR_TITLES.put("messages", "Mensagens");
        TOOLBAR_TITLES.put("profile", "Perfil");
    }

    private void initToolbarTitle() {
        binding.toolbarTitle.setText(TOOLBAR_TITLES.get("home"));
    }


    private void setupNavControllerListener() {
        navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            if (navDestination.getRoute() != null) {
                String toolbarTitle = TOOLBAR_TITLES.get(navDestination.getRoute());
                binding.toolbarTitle.setText(toolbarTitle);
            }
        });
    }
    private void setupBottomNavigationWithNavController() {
        BottomNavigationView bottomNavigation = binding.bottomNavigationView;
        NavigationUI.setupWithNavController(bottomNavigation, navController);
    }


}