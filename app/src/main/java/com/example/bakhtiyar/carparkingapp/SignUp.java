package com.example.bakhtiyar.carparkingapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    EditText txt_email,txt_password;

    String email,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();


        txt_email = (EditText) findViewById(R.id.email);

        txt_password = (EditText) findViewById(R.id.password);

        findViewById(R.id.Signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = txt_email.getText().toString().trim();

                password = txt_password.getText().toString().trim();

                if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)){

                    txt_email.setText("");

                    txt_password.setText("");

                    Toast.makeText(SignUp.this, "Please Insert form", Toast.LENGTH_SHORT).show();

                    return;

                }else {

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(SignUp.this, "Successfull", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });


                }



            }
        });




    }
}
