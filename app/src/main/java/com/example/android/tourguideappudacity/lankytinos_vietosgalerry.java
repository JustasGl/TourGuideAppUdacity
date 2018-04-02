package com.example.android.tourguideappudacity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static android.widget.ImageView.ScaleType.CENTER_CROP;
import static android.widget.ImageView.ScaleType.FIT_CENTER;

public class lankytinos_vietosgalerry extends AppCompatActivity {

    int i, sk = 0, max = 15;
    Vibrator vibrator;
    String str_location;
    String daugiau;
    ImageView plius, minus, img;
    int pirminisnuotraukosplotis, pirminisnuotraukosilgis;
    Animation blink;
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
        mMediaPlayer = MediaPlayer.create(lankytinos_vietosgalerry.this, R.raw.garsas);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lankytinos_vietosgalerry);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.up);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        i = getIntent().getIntExtra(getApplicationContext().getString(R.string.IREIKSME), 0);
        img = findViewById(R.id.galerija);
        plius = findViewById(R.id.pirmyn);
        minus = findViewById(R.id.atgal);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        plius.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                skamb();
                i++;
                if (i > max) {
                    i = max;
                }
                setelements();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                skamb();
                i--;
                if (i < 0) {
                    i = 0;
                }
                setelements();
            }
        });

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                sk++;
                skamb();
                if (sk % 2 != 0) {
                    plius.setVisibility(View.GONE);
                    minus.setVisibility(View.GONE);
                    img.requestLayout();
                    pirminisnuotraukosplotis = img.getLayoutParams().width;
                    pirminisnuotraukosilgis = img.getLayoutParams().height;
                    img.setScaleType(CENTER_CROP);
                    vibrator.vibrate(200);

                } else {
                    if (i == 0) {

                    } else {
                        minus.setVisibility(View.VISIBLE);
                    }

                    if (i == max) {

                    } else {
                        plius.setVisibility(View.VISIBLE);
                    }

                    img.requestLayout();
                    img.getLayoutParams().width = pirminisnuotraukosplotis;
                    img.getLayoutParams().height = pirminisnuotraukosilgis;
                    img.setScaleType(FIT_CENTER);
                    vibrator.vibrate(200);

                }
                return false;
            }
        });

        setelements();
    }

    void setelements() {
        TextView pvd = findViewById(R.id.pavadinimas);
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        TextView apr = findViewById(R.id.aprasymas);
        ImageView map = findViewById(R.id.mapas);
        ImageView gs =  findViewById(R.id.gsearch);

        if (i == 8) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            apr.setText(getApplicationContext().getString(R.string.OginskiuRumaiAprasymas3) +
                    "\n" +
                    getApplicationContext().getString(R.string.OginskiuRumaiAprasymas2) +
                    getApplicationContext().getString(R.string.OginskiuRumaiAprasymas1) +
                    getApplicationContext().getString(R.string.OginskiuRumaiAprasymas));

            apr.startAnimation(blink);
            str_location = getApplicationContext().getString(R.string.OginskiuRumaiAddres);
            daugiau = getApplicationContext().getString(R.string.OginskiuRumaiUrl);
        }

        if (i == 2) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            minus.setVisibility(View.VISIBLE);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.EnergetiniaiLabirintai));
            img.setImageResource(R.drawable.elabirintai);
            apr.setText(getApplicationContext().getString(R.string.EnergetiniaiLabirintaiAprasymas));

            str_location = getApplicationContext().getString(R.string.EnergetiniaiLabirintaiAddres);
            daugiau = getApplicationContext().getString(R.string.EnergetiniaiLabirintaiUrl);
        }

        if (i == 3) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.GarduOzo));
            img.setImageResource(R.drawable.ozo);
            apr.setText(getApplicationContext().getString(R.string.GarduOzoAprasymas));

            str_location = getApplicationContext().getString(R.string.GarduOzoAddres);
            daugiau = getApplicationContext().getString(R.string.GarduOzoUrl);
        }


        if (i == 13) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.SvMergelesEmemoIDanguBaznycia));
            img.setImageResource(R.drawable.baznycia);
            apr.setText(getApplicationContext().getString(R.string.SvMergelesEmemoIDanguBaznyciaAprasymas));

            str_location = getApplicationContext().getString(R.string.SvMergelesEmemoIDanguBaznyciaAddres);
            daugiau = getApplicationContext().getString(R.string.SvMergelesEmemoIDanguBaznyciaUrl);
        }

        if (i == 14) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.ZemaitijosKaimoBuities));
            img.setImageResource(R.drawable.zlbm);
            apr.setText("\n" +
                    getApplicationContext().getString(R.string.ZemaitijosKaimoMuziejusAprasymas4) +
                    getApplicationContext().getString(R.string.ZemaitijosKaimoMuziejusAprasymas3) +
                    getApplicationContext().getString(R.string.ZemaitijosKaimoMuziejusAprasymas2) +
                    getApplicationContext().getString(R.string.ZemaitijosKaimoMuziejusAprasymas1) +
                    getApplicationContext().getString(R.string.ZemaitijosKaimoMuziejusAprasymas));

            str_location = getApplicationContext().getString(R.string.ZemaitijosKaimoBuities);
            daugiau = getApplicationContext().getString(R.string.ZemaitijosKaimoMuziejusUrl);
        }
        if (i == 10) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.SkulpturuParkas));
            img.setImageResource(R.drawable.skultura);
            apr.setText(getApplicationContext().getString(R.string.SkulpturuParkasAprasymas));
            str_location = getApplicationContext().getString(R.string.SkulpturuParkasAddres);
            daugiau = getApplicationContext().getString(R.string.SkulpturuParkasUrl);
        }
        if (i == 11) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.VentosRegioninioParko));
            img.setImageResource(R.drawable.apbokstas);
            apr.setText(getApplicationContext().getString(R.string.VentosRegioninioParkoAprasymas));
            str_location = getApplicationContext().getString(R.string.VentosRegioninioParkoAddres);
            daugiau = getApplicationContext().getString(R.string.VentosRegioninioParkoUrl);
        }

        if (i == 5) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.KretingosRumai));
            img.setImageResource(R.drawable.kretmuziejus);
            apr.setText(getApplicationContext().getString(R.string.KretingosMuziejusAprasymas));
            str_location = getApplicationContext().getString(R.string.KretingosMuziejusAddres);
            daugiau = getApplicationContext().getString(R.string.KretingosMuziejusUrl);
        }

        if (i == 4) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.KretingosViespatsBaznycia));
            img.setImageResource(R.drawable.baznycia_ilga);
            apr.setText(getApplicationContext().getString(R.string.KretingosViespatsBaznyciaAprasymas1) +
                    "\n" +
                    getApplicationContext().getString(R.string.KretingosViespatsBaznyciaAprasymas));
            str_location = getApplicationContext().getString(R.string.KretingosViespatsBaznyciaAddres);
            daugiau = getApplicationContext().getString(R.string.KretingosViespatsBaznyciaUrl);
        }

        if (i == 6) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.VandensMalunas));
            img.setImageResource(R.drawable.malunas_ilgas);
            apr.setText(getApplicationContext().getString(R.string.VandensMalunasAprasymas2) +
                    "\n" +
                    getApplicationContext().getString(R.string.VandensMalunasAprasymas1) +
                    "\n" +
                    getApplicationContext().getString(R.string.VandensMalunasAprasymas));
            str_location = getApplicationContext().getString(R.string.VandensMalunasAddres);
            daugiau = getApplicationContext().getString(R.string.VandensMalunasUrl);
        }

        if (i == 7) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.LenkimuSvOnosBaznycia));
            img.setImageResource(R.drawable.baznycia_ilgas);
            apr.setText(getApplicationContext().getString(R.string.LenkimuBaznyciaAprasymas1) +
                    "\n" +
                    getApplicationContext().getString(R.string.LenkimuBaznyciaAprasymas));
            str_location = getApplicationContext().getString(R.string.LenkimuBaznyciaAddres);
            daugiau = getApplicationContext().getString(R.string.LenkimuBaznyciaRul);
        }
        if (i == 0) {
            minus.setVisibility(View.GONE);
            map.startAnimation(blink);
            gs.startAnimation(blink);
            pvd.setText(getApplicationContext().getString(R.string.PlungesDvaras));
            pvd.startAnimation(blink);
            img.setImageResource(R.drawable.plungesdvaras);
            img.startAnimation(blink);
            pvd.setText(getApplicationContext().getString(R.string.BirzuvenuDvaras));
            img.setImageResource(R.drawable.birzuvenud_ilgas);
            apr.setText(getApplicationContext().getString(R.string.BirzuvenuDvarasAprasymas));
            str_location = getApplicationContext().getString(R.string.BirzuvenuDvarasAddres);
            daugiau = getApplicationContext().getString(R.string.RenavoDvarasmapUrl);
        }
        if (i == 9) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.RenavoDvaras));
            img.setImageResource(R.drawable.renavas_ilgas);
            apr.setText(getApplicationContext().getString(R.string.RenavoDvarasAprasymas1) +
                    getApplicationContext().getString(R.string.RenavoDvarasAprasymas));
            str_location = getApplicationContext().getString(R.string.RenavoDvarasAddres);
            daugiau = getApplicationContext().getString(R.string.RenavoDvarasUrl);
        }

        if (i == 15) {

            plius.setVisibility(View.GONE);
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);

            pvd.setText(getApplicationContext().getString(R.string.ZemaiciuKalvarija));
            img.setImageResource(R.drawable.zemkalv_ilgas);
            apr.setText(getApplicationContext().getString(R.string.ZemaiciuKalvarijaAprasymas));
            str_location = getApplicationContext().getString(R.string.ZemaiciuKalvarija);
            daugiau = getApplicationContext().getString(R.string.ZemaiciuKalvarijaUrl);
        }
        if (i == 12) {
            minus.startAnimation(blink);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);
            plius.startAnimation(blink);
            plius.setVisibility(View.VISIBLE);

            pvd.setText(getApplicationContext().getString(R.string.SaltojoKaroMuziejus));
            img.setImageResource(R.drawable.skaro_ilgas);
            apr.setText(getApplicationContext().getString(R.string.ZemaitijosKalvarijaAprasymas));
            str_location = getApplicationContext().getString(R.string.SaltojoKaroMuziejus);
            daugiau = getApplicationContext().getString(R.string.SaltojoKaroMuziejusUrlJava);
        }
        if (i == 1) {
            minus.startAnimation(blink);
            minus.setVisibility(View.VISIBLE);
            pvd.startAnimation(blink);
            img.startAnimation(blink);
            apr.startAnimation(blink);
            plius.setAnimation(blink);
            map.startAnimation(blink);
            gs.startAnimation(blink);
            pvd.setText(getApplicationContext().getString(R.string.DautaruDvaras));
            img.setImageResource(R.drawable.dautarai_sq);
            apr.setText(getApplicationContext().getString(R.string.DautaruDvarasAprasymas4) +
                    "\n" +
                    getApplicationContext().getString(R.string.DautaruDvarasAprasymas3) +
                    "\n" +
                    getApplicationContext().getString(R.string.DautaruDvarasAprasymas2) +
                    "\n" +
                    getApplicationContext().getString(R.string.DautaruDvarasAprasymas1));
            str_location = getApplicationContext().getString(R.string.DautaruDvaras);
            daugiau = getApplicationContext().getString(R.string.DautaruDvarasUrlJava);
        }
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skamb();
                String map = getApplicationContext().getString(R.string.mapsLink) + str_location;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(i);
            }
        });
        gs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skamb();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                startActivity(i);
            }
        });
    }
}
