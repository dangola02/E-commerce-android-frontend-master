package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.ecommerce.fragments.Bage;
import com.example.ecommerce.fragments.Home;
import com.example.ecommerce.fragments.Profile;
import com.example.ecommerce.fragments.ShopFregment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN );

        chipNavigationBar = findViewById(R.id.bottom_nav_menu) ;
        // default fregment
        getSupportFragmentManager().beginTransaction().replace(R.id.fregment_container , new ShopFregment()).addToBackStack(null).commit();
        navbarMenu();

    }

    private void navbarMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null ;
                switch (i){
                    case R.id.shop :
                        fragment = new ShopFregment() ;
                        break;
                    case R.id.prof :
                        fragment = new Profile() ;
                        break;
                    case R.id.bage :
                        fragment = new Bage() ;
                        break;
                    case R.id.home :
                        fragment = new Home() ;
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fregment_container , fragment ).commit();
            }
        });
    }


}