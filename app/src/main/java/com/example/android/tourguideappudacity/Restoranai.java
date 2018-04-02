package com.example.android.tourguideappudacity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class Restoranai extends AppCompatActivity {
    boolean i;
    int a = 0;
    ImageView fng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restoranai);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        i = getIntent().getBooleanExtra(getApplicationContext().getString(R.string.ARTAIMOKYMAI), false);
        fng = (ImageView) findViewById(R.id.finger);
        fng.setVisibility(View.GONE);
        if (i) {
            fng.setVisibility(View.VISIBLE);
            move();
        } else {
            fng.setVisibility(View.GONE);
        }
        ViewPager viewPager = findViewById(R.id.viewpager);

        swiperis adapter = new swiperis(getSupportFragmentManager());
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);

    }

    private void move() {
        TranslateAnimation cloud_moving = new TranslateAnimation(
                Animation.ABSOLUTE, 1450,
                Animation.ABSOLUTE, 10,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0
        );

        cloud_moving.setDuration(1000);
        cloud_moving.setFillAfter(false);
        fng.setAnimation(cloud_moving);
        cloud_moving.setRepeatCount(5);
        cloud_moving.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(Restoranai.this, getApplicationContext().getString(R.string.BraukiameISona), Toast.LENGTH_LONG).show();
                Toast.makeText(Restoranai.this, getApplicationContext().getString(R.string.BraukiameISona), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                a++;
                if (a == 5) {
                    fng.setVisibility(View.GONE);
                    Intent intent = new Intent(Restoranai.this, TelsiuRestoranai.class);

                    startActivity(intent);
                }
            }
        });
    }

}