package br.com.alive_lens.ui.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.firebase.auth.FirebaseAuth;
import br.com.alive_lens.FirebaseServices;


public class MainViewModel extends ViewModel {

    private final MutableLiveData<Boolean> authenticated = new MutableLiveData<>();

    public LiveData<Boolean> isAuthenticated() {
        return authenticated;
    }

    public void checkIsAuthenticated() {
        FirebaseAuth firebaseAuth = FirebaseServices.getFirebaseAuth();
        authenticated.setValue(firebaseAuth.getCurrentUser() != null);
    }

}