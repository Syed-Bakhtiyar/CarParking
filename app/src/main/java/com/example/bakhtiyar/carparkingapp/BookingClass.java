package com.example.bakhtiyar.carparkingapp;

/**
 * Created by Bakhtiyar on 2/3/2017.
 */
public class BookingClass {
    String name,push,date;

    int before , after, booknumber;



    public BookingClass(String name, int before, int after, int booknumber,  String date,String push) {
        this.name = name;
        this.before = before;
        this.after = after;
        this.booknumber = booknumber;

        this.date = date;
        this.push = push;
    }

    public BookingClass() {
    }

    public String getPush() {
        return push;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getBefore() {
        return before;
    }

    public int getAfter() {
        return after;
    }

    public int getBooknumber() {
        return booknumber;
    }


}
