package com.example.android.tourguideappudacity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class dziugonamai extends AppCompatActivity {

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

    private void skamb() {
        mMediaPlayer = MediaPlayer.create(dziugonamai.this, R.raw.garsas);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dziugonamai);

        ImageView adress = (ImageView) findViewById(R.id.adreso);
        ImageView tel = (ImageView) findViewById(R.id.telefono);
        adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skamb();
                String str_location = getApplicationContext().getString(R.string.DziugoNamaiAddresJava);
                String map = getApplicationContext().getString(R.string.mapsLink) + str_location;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(i);
            }
        });
        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skamb();
                String phone = getString(R.string.DziugoNamaiTelNrJava);
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(getApplicationContext().getString(R.string.tel), phone, null));
                startActivity(intent);
            }
        });
        ImageView googlesearch = (ImageView) findViewById(R.id.google);
        googlesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skamb();
                String daugiau = getApplicationContext().getString(R.string.DziugoNamaiUrl);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                startActivity(i);
            }
        });

    }
}
