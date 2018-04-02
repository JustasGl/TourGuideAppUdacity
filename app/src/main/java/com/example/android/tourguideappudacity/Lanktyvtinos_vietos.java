package com.example.android.tourguideappudacity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lanktyvtinos_vietos extends AppCompatActivity {

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
        mMediaPlayer = MediaPlayer.create(Lanktyvtinos_vietos.this, R.raw.garsas);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.up);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        final ArrayList<word> visiRestoranai = new ArrayList<word>();
        visiRestoranai.add(new word(R.drawable.plungesdvar, getApplicationContext().getString(R.string.PlungesDvaras)));
        visiRestoranai.add(new word(R.drawable.labirintas, getApplicationContext().getString(R.string.EnergetiniaiLabirintai)));
        visiRestoranai.add(new word(R.drawable.gardu, getApplicationContext().getString(R.string.GurduOzo)));
        visiRestoranai.add(new word(R.drawable.baznyc, getApplicationContext().getString(R.string.SvMergelsMarijos)));
        visiRestoranai.add(new word(R.drawable.muziejus, getApplicationContext().getString(R.string.ZemaitijosKaimoBuities)));
        visiRestoranai.add(new word(R.drawable.skulpturos, getApplicationContext().getString(R.string.SkulpturuParkas)));
        visiRestoranai.add(new word(R.drawable.restoranai_skuode, getApplicationContext().getString(R.string.VentosApzvalgosBokstas)));
        visiRestoranai.add(new word(R.drawable.kmuziejus, getApplicationContext().getString(R.string.KretingosMuziejus)));
        visiRestoranai.add(new word(R.drawable.baznycia_plati, getApplicationContext().getString(R.string.KretingoViespaties)));
        visiRestoranai.add(new word(R.drawable.malunas_platus, getApplicationContext().getString(R.string.KretingosMalunas)));
        visiRestoranai.add(new word(R.drawable.baznycia_platus, getApplicationContext().getString(R.string.LenkimuSvOnosBaznycia)));
        visiRestoranai.add(new word(R.drawable.birzuvenud_platus, getApplicationContext().getString(R.string.BirzuvenuDvaras)));
        visiRestoranai.add(new word(R.drawable.renavas_platus, getApplicationContext().getString(R.string.RenavoDvaras)));
        visiRestoranai.add(new word(R.drawable.zemkalv_plokscias, getApplicationContext().getString(R.string.ZemaiciuKalvarija)));
        visiRestoranai.add(new word(R.drawable.skaro_plokscias, getApplicationContext().getString(R.string.SaltojoKaroMuziejus)));
        visiRestoranai.add(new word(R.drawable.dautarai_plokscias, getApplicationContext().getString(R.string.DautarųDvaras)));

        Collections.sort(visiRestoranai, new Comparator<word>() {
            @Override
            public int compare(word word, word t1) {
                return word.getTag().compareTo(t1.getTag());
            }
        });
        visiRestoranai.add(new word(R.drawable.daugiaup, ""));
        Adaptoreditor2 adapteris = new Adaptoreditor2(Lanktyvtinos_vietos.this, visiRestoranai);
        ListView Listtranslated = (ListView) findViewById(R.id.list);
        Listtranslated.setAdapter(adapteris);
        Listtranslated.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                word listas = visiRestoranai.get(position);

                switch (position) {
                    case 0:
                        skamb();
                        Intent intent = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intent.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intent);
                        break;
                    case 1:
                        skamb();
                        Intent intentas = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas);
                        break;
                    case 2:
                        skamb();
                        Intent intentas1 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas1.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas1);
                        break;
                    case 3:
                        skamb();
                        Intent intentas2 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas2.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas2);
                        break;
                    case 4:
                        skamb();
                        Intent intentas3 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas3.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas3);
                        break;
                    case 5:
                        skamb();
                        Intent intentas4 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas4.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas4);
                        break;
                    case 6:
                        skamb();
                        Intent intentas5 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas5.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas5);
                        break;
                    case 7:
                        skamb();
                        Intent intentas6 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas6.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas6);
                        break;
                    case 8:
                        skamb();
                        Intent intentas7 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas7.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas7);
                        break;
                    case 9:
                        skamb();
                        Intent intentas8 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas8.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas8);
                        break;
                    case 10:
                        skamb();
                        Intent intentas9 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas9.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas9);
                        break;
                    case 11:
                        skamb();
                        Intent intentas10 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas10.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas10);
                        break;
                    case 12:
                        skamb();
                        Intent intentas11 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas11.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas11);
                        break;
                    case 13:
                        skamb();
                        Intent intentas12 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas12.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas12);
                        break;
                    case 14:
                        skamb();
                        Intent intentas13 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas13.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas13);
                        break;
                    case 15:
                        skamb();
                        Intent intentas15 = new Intent(Lanktyvtinos_vietos.this, lankytinos_vietosgalerry.class);
                        intentas15.putExtra(getApplicationContext().getString(R.string.IREIKSME), position);
                        startActivity(intentas15);
                        break;
                    case 16:
                        skamb();
                        String daugiau = getApplicationContext().getString(R.string.LankytinosVietosUrlJava);
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                        startActivity(i);
                        break;

                }
            }
        });
    }
}
