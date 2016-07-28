package com.example.non_jid.tabapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(),"");
        viewPagerAdapter.addFragments(new ListCenterFragment(), "");
        viewPagerAdapter.addFragments(new RegisCenterFragment(), "");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        setTabIcons();

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
        } else {
            Toast.makeText(this, "Network is not available", Toast.LENGTH_LONG).show();
        }


    }

    private void setTabIcons() {

        int[] tabIcons = {
                R.drawable.ic_directions_black_24dp,
                R.drawable.ic_directions_bike_black_24dp,
                R.drawable.ic_add_shopping_cart_black_24dp
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]).setText("AllMap");
        tabLayout.getTabAt(1).setIcon(tabIcons[1]).setText("ListShop");
        tabLayout.getTabAt(2).setIcon(tabIcons[2]).setText("AddShop");
    }


}
