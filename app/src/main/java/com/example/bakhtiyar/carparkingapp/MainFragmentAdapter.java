package com.example.bakhtiyar.carparkingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bakhtiyar on 2/3/2017.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

    int count;

    public MainFragmentAdapter(FragmentManager fm, int a) {
        super(fm);

        count = a;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(count == 1){

            switch (position){
                case 0:

                    return "Admin Panel";

                case 1:

                    return "Customer Login";

                default:

                    return null;



            }

        }
        else if(count == 2){

            return null;

        }
        else {

            return null;

        }
    }

    @Override
    public Fragment getItem(int position) {

        if(count == 1){

            switch (position){
                case 0:

                    return new AdminLogin();

                case 1:

                    return new CustomerLogin();

                default:

                    return null;



            }

        }
        else if(count == 2){

            return null;

        }
        else {

            return null;

        }





    }

    @Override
    public int getCount() {
        if(count ==1){

            return 2;

        }else if (count == 2){

            return 0;
        }else {

            return 0;

        }
    }
}
