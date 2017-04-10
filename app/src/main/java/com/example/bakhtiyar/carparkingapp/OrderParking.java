package com.example.bakhtiyar.carparkingapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OrderParking extends AppCompatActivity {

    EditText txt_name;

    TextView txt_before,txt_after;

    static final int D_ID=0;

    Query test;

    String name;

    int before , after, booknumber;

    FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    BookingClass bookingClass;

    ArrayList<BookingClass> arrayList;

    int bhour,ahour;

    int bmint,amint;

    int check = 0;

    int count =0;




    TimePickerDialog.OnTimeSetListener kTimePickerListner = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int h, int m) {


            if(count==1){

                bhour = h;

                bmint = m;


                txt_before.setText("Hour: "+bhour+" Minute "+bmint);

            }
            else if(count == 2) {

                ahour = h;

                amint = m;

                if (bhour == 23 && ahour == 0){

                    txt_after.setText("Hour: "+ahour+" Minute "+amint);

                    return;

                }

                if(ahour < bhour){

                    Toast.makeText(OrderParking.this, "Please select time greater than previous", Toast.LENGTH_SHORT).show();

                    return;

                }

                txt_after.setText("Hour: "+ahour+" Minute "+amint);

            }


        }
    };


    @Override
    protected Dialog onCreateDialog(int id) {
//        return super.onCreateDialog(id);



        if(id==D_ID){

            if(count == 1){

                return new TimePickerDialog(OrderParking.this, kTimePickerListner, bhour,bmint, true);

            }
            else if(count == 2){

                return new TimePickerDialog(OrderParking.this, kTimePickerListner, ahour,amint,true);


            }



        }

        return null;

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_parking);

        arrayList = new ArrayList<>();


        FirebaseDatabase.getInstance().getReference().child("Booking").orderByChild("booknumber").equalTo(StaticVariables.book).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                BookingClass bookingClass = dataSnapshot.getValue(BookingClass.class);

                Log.d("Array", "onChildAdded: "+dataSnapshot.getValue());

                arrayList.add(bookingClass);



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        txt_name = (EditText) findViewById(R.id.name);

        txt_before = (TextView) findViewById(R.id.before);

        txt_after = (TextView) findViewById(R.id.after);




        txt_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count = 1;

                showDialog(D_ID);

            }
        });





        txt_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count = 2;

                showDialog(D_ID);

            }
        });





        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                Date date = new Date();

                String dttm = dateFormat.format(date);




                // boolean is = arrayList.get(0).getDate() == dttm;

           //     Toast.makeText(OrderParking.this, ""+is, Toast.LENGTH_SHORT).show();

                    try {

                        name = txt_name.getText().toString();

                        before = bhour;

                        after = ahour;


//                        Log.d("test", "onClick: "+test);

                    }catch (Exception e){


                        Toast.makeText(OrderParking.this, ""+e, Toast.LENGTH_SHORT).show();

                        return;

                    }

                    if (TextUtils.isEmpty(name)){

                        Toast.makeText(OrderParking.this, "Please Enter Your name", Toast.LENGTH_SHORT).show();

                        txt_name.setText("");

                        return;
                    }


                    for (int i =0; i< arrayList.size() ; i++){


                        if (dttm.equals(arrayList.get(i).date) &&
                                (bhour <= arrayList.get(i).before  || bhour <= arrayList.get(i).after )){

                            check = 1;


                            break;
//                            Toast.makeText(OrderParking.this, ""+date, Toast.LENGTH_SHORT).show();


                        }


                    }

                for (int i =0; i< arrayList.size() ; i++){


                    if (dttm.equals(arrayList.get(i).date) &&
                            (bhour == arrayList.get(i).before || bhour == arrayList.get(i).after)){

                        check = 1;


                        break;
//                            Toast.makeText(OrderParking.this, ""+date, Toast.LENGTH_SHORT).show();


                    }


                }



                if (check != 0){

                        Toast.makeText(OrderParking.this, " Already booked ", Toast.LENGTH_SHORT).show();



                    }
                    else {

                        BookingClass bookingClass = new BookingClass(name,before,after,StaticVariables.book,dttm,FirebaseDatabase.getInstance().getReference().child("Booking").push().getKey());



                        FirebaseDatabase.getInstance().getReference().child("Booking").child(bookingClass.getPush()).setValue(bookingClass);



                        Toast.makeText(OrderParking.this, "Submitted", Toast.LENGTH_SHORT).show();


                    }


                    check = 0;











            }
        });


    }



    @Override
    protected void onStart() {
        super.onStart();
 }




}
