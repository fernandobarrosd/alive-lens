package br.com.alive_lens;

import androidx.annotation.NonNull;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public abstract class FirebaseServices {
    @NonNull
    public static FirebaseFirestore getFirestore() {
        return FirebaseFirestore.getInstance();
    }

    @NonNull
    public static FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}