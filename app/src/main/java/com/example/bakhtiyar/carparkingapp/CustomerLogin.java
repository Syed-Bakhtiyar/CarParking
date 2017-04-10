package com.example.bakhtiyar.carparkingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerLogin extends Fragment {

    FirebaseAuth firebaseAuth;

    EditText txt_email,txt_password;

    String email, password;

    View v;


    public CustomerLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_customer_login, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        txt_email = (EditText) v.findViewById(R.id.email);

        txt_password = (EditText) v.findViewById(R.id.password);

        v.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = txt_email.getText().toString().trim();

                password = txt_password.getText().toString().trim();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){

                    Toast.makeText(getContext(), "Please complete form", Toast.LENGTH_SHORT).show();

                    txt_email.setText("");

                    txt_password.setText("");

                    return;
                }
                else {


                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(getActivity(),CarParking.class));

                            }
                            else {

                                txt_email.setText("");

                                txt_password.setText("");

                                Toast.makeText(getContext(), "If your a/c is not created please create your account", Toast.LENGTH_SHORT).show();

                                return;
                            }

                        }
                    });

                }


            }
        });


        v.findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(),SignUp.class));


            }
        });



        return v;
    }

}
