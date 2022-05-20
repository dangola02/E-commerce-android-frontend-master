package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ecommerce.adapters.OnBoardingAdapter;

public class OnBoarding extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private OnBoardingAdapter onBoardingAdapter ;
    private TextView[]  dots ;
    private Button button1 , button2 ;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = (ViewPager) findViewById(R.id.viewPager_onboarding) ;
        linearLayout = (LinearLayout) findViewById(R.id.onBoarding_dots) ;
        button1 = (Button) findViewById(R.id.onBoarding_login_buttom);
        button2 = (Button) findViewById(R.id.onBoarding_loginLater_button);
        relativeLayout = (RelativeLayout) findViewById(R.id.onBoarding_buttons_layout);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoarding.this , MainActivity.class) ;
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoarding.this , Login.class) ;
                startActivity(intent);
            }
        });
        onBoardingAdapter = new OnBoardingAdapter(this) ;
        viewPager.setAdapter(onBoardingAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }


    public void addDots (int postion) {
        dots = new TextView[4] ;
        linearLayout.removeAllViews();
        for(int i = 0 ; i < dots.length ; i++) {
            dots[i] = new TextView(this) ;
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            linearLayout.addView(dots[i]);
        };
        if(dots.length > 0) {
            dots[postion].setTextColor(getResources().getColor(R.color.dark_gray));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            if(position == 3){
                relativeLayout.setVisibility(View.VISIBLE);
            }
            else {
                relativeLayout.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}