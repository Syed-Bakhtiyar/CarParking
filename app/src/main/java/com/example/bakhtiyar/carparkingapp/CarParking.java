package com.example.bakhtiyar.carparkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CarParking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_parking);


        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StaticVariables.book = 1;

                startActivity(new Intent(CarParking.this,OrderParking.class));

            }
        });



        findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StaticVariables.book = 2;

                startActivity(new Intent(CarParking.this,OrderParking.class));

            }
        });


        findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StaticVariables.book = 3;

                startActivity(new Intent(CarParking.this,OrderParking.class));

            }
        });


        findViewById(R.id.four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StaticVariables.book = 4;

                startActivity(new Intent(CarParking.this,OrderParking.class));

            }
        });



        findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StaticVariables.book = 5;

                startActivity(new Intent(CarParking.this,OrderParking.class));

            }
        });

        findViewById(R.id.six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StaticVariables.book = 6;

                startActivity(new Intent(CarParking.this,OrderParking.class));

            }
        });

    }
}
