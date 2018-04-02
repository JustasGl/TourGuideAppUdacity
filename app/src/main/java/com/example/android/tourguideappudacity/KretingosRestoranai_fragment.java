package com.example.android.tourguideappudacity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class KretingosRestoranai_fragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public KretingosRestoranai_fragment() {
    }

    @Override
    public void onStop() {
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
        mMediaPlayer = MediaPlayer.create(getActivity(), R.raw.garsas);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        Toolbar myToolbar = (Toolbar) rootView.findViewById(R.id.my_toolbar);
        myToolbar.setVisibility(View.GONE);

        final ArrayList<word> Prestoranai = new ArrayList<word>();
        Prestoranai.add(new word(R.drawable.kretingos_restoranai, getActivity().getString(R.string.UzsukiteKretingoje)));
        Prestoranai.add(new word(R.drawable.pasgrafa, getActivity().getString(R.string.PasGrafaTitle)));
        Prestoranai.add(new word(R.drawable.smagratis, getActivity().getString(R.string.SmagratisTitle)));
        Prestoranai.add(new word(R.drawable.vienaragiomalunas, getActivity().getString(R.string.VienaragioMalunasTitle)));
        Prestoranai.add(new word(R.drawable.daugiaup, ""));

        Adaptoreditor adapteris = new Adaptoreditor(getActivity(), Prestoranai);
        ListView Listtranslated = (ListView) rootView.findViewById(R.id.list);
        Listtranslated.setAdapter(adapteris);
        Listtranslated.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                switch (position) {
                    case 1:
                        skamb();
                        Intent intent = new Intent(getActivity(), pasgrafa.class);
                        startActivity(intent);
                        break;
                    case 2:
                        skamb();
                        Intent intentas = new Intent(getActivity(), smagratis.class);
                        startActivity(intentas);
                        break;
                    case 3:
                        skamb();
                        Intent intentas1 = new Intent(getActivity(), vienaragiomalunas.class);
                        startActivity(intentas1);
                        break;
                    case 4:
                        skamb();
                        String daugiau = getActivity().getString(R.string.KretingosRestoranaiUrl);
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                        startActivity(i);
                        break;
                }
            }
        });
        return rootView;
    }

}
