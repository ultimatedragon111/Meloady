package com.example.meloady;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;


public class SignUpFragment extends Fragment {

    private Button btnLogin,btnSignUp;
    private EditText user2,password2,email2;
    private String user,password,email;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up,container,false);
        btnLogin = view.findViewById(R.id.btnLogin2);
        btnSignUp = view.findViewById(R.id.btnSignUp2);
        user2 = view.findViewById(R.id.User2);
        password2 = view.findViewById(R.id.Password2);
        email2 = view.findViewById(R.id.Email2);

        btnSignUp.setOnClickListener(v -> {
            user = user2.getText().toString().trim();
            password = password2.getText().toString().trim();
            email= email2.getText().toString().trim();
            FirebaseFirestore.getInstance().collection("users").add(new User(user, password,email));
        });
        btnLogin.setOnClickListener(v ->{
            replaceFragment();
        });
        return view;
    }
    public void replaceFragment(){
        fragment = new LoginFragment();
        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}