package com.example.android.tourguideappudacity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Vibrator vibrator;
    boolean tiesa;
    int skaiciuoklis = 1;
    int kelintas = 0;
    RelativeLayout zemgid;
    ImageView vietos,restoranai, finger;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void startZoomAnimation() {
        if (skaiciuoklis == 1) {
            ViewGroup view = (ViewGroup) findViewById(R.id.realitivasrestoranu);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_animation);
            view.startAnimation(animation);
            finger.setImageResource(R.drawable.finger);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    if (kelintas < 99) {
                        kelintas++;
                        if (kelintas % 14 != 0)
                            startZoomAnimation();
                        if (kelintas % 7 == 0) {
                            kelintas++;
                            Intent intent = new Intent(MainActivity.this, Restoranai.class);
                            intent.putExtra(getApplicationContext().getString(R.string.ARTAIMOKYMAI), true);
                            startActivity(intent);
                            mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.garsas);
                            mMediaPlayer.start();
                            mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        }
                        if (kelintas % 13 == 0)
                            if (kelintas % 13 == 0) {
                                movevack();
                                String daugiau = getApplicationContext().getString(R.string.RestoranaiGoogleMapsLayer);
                                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                                startActivity(i);
                                vibrator.vibrate(200);
                                mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.garsas);
                                mMediaPlayer.start();
                                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                                kelintas = 100;
                            }
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void fadein() {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        finger.setAnimation(anim);
        move();
    }

    private void move() {
        TranslateAnimation cloud_moving = new TranslateAnimation(
                Animation.ABSOLUTE, 1000,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 500,
                Animation.ABSOLUTE, 100
        );

        cloud_moving.setDuration(1500);
        cloud_moving.setFillAfter(true);
        finger.setAnimation(cloud_moving);
    }

    private void movevack() {

        finger.setImageResource(R.drawable.empty);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        finger = findViewById(R.id.finger);
        finger.setVisibility(View.GONE);
        vietos = findViewById(R.id.lankytinosvietos);
        restoranai = findViewById(R.id.Restoranai);
        kelintas = 0;
        zemgid = (RelativeLayout) findViewById(R.id.zgidas);
        tiesa = getIntent().getBooleanExtra(getApplicationContext().getString(R.string.KELINTOSUMA), false);
        if (tiesa) {
            Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.SpauskiteIrAtsidarys), Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.SpauskiteIrAtsidarys), Toast.LENGTH_SHORT).show();
            finger.setVisibility(View.VISIBLE);
            finger.setImageResource(R.drawable.finger);
            skaiciuoklis = 1;
            kelintas = 9;
            startZoomAnimation();
        }
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        restoranai.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String daugiau = getApplicationContext().getString(R.string.RestoranaiGoogleMapsLayer);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                startActivity(i);
                vibrator.vibrate(200);
                mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.garsas);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                return false;
            }
        });
        restoranai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movevack();
                skaiciuoklis = 0;
                Intent intent = new Intent(MainActivity.this, Restoranai.class);
                startActivity(intent);
                mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.garsas);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                skaiciuoklis++;
            }
        });
        vietos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movevack();
                skaiciuoklis = 0;
                Intent intent = new Intent(MainActivity.this, Lanktyvtinos_vietos.class);
                startActivity(intent);
                mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.garsas);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
        vietos.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String daugiau = getApplicationContext().getString(R.string.LankytinosVietosGoogleMapLayer);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                startActivity(i);
                vibrator.vibrate(200);
                mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.garsas);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.info) {
                skaiciuoklis = 1;
                startZoomAnimation();
                finger.setVisibility(View.VISIBLE);
                fadein();
                Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.ToOpenSuggested), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.ToOpenSuggested), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.ToOpenSuggested), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}