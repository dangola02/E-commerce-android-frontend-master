package com.example.ecommerce.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ecommerce.MainActivity;
import com.example.ecommerce.OnBoarding;
import com.example.ecommerce.R;
import com.example.ecommerce.Splash;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class OnBoardingAdapter extends PagerAdapter {
    private Context context ;
    private LayoutInflater layoutInflater ;

    public OnBoardingAdapter(Context context) {
        this.context = context;
    }

    public int[] onBoardingImage = {
            R.drawable.onboardingpage1 ,
            R.drawable.onboardingpage2 ,
            R.drawable.onboradingpage3 ,
            R.drawable.onboardingpage4 ,
    };

    public String[] onBoardingText = {
           " Welcome to the Ecommerce Here You can see all the fashion things" ,
           " Welcom to the Ecommerce Here You can see all the fastion things" ,
           " Welcom to the Ecommerce Here You can see all the fastion things" ,
           " " ,
    };
    public Boolean[] onBoardingButton = {
            false,
            false,
            false,
            true,
    };


    @Override
    public int getCount() {
        return onBoardingButton.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;
        View  view = layoutInflater.inflate(R.layout.on_barding , container , false) ;

        ImageView imageView = (ImageView) view.findViewById(R.id.onBoarding_image) ;
        TextView textView = (TextView) view.findViewById(R.id.onBoarding_text) ;



        imageView.setImageResource(onBoardingImage[position]);
        textView.setText(onBoardingText[position]);


        container.addView(view);

        return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
