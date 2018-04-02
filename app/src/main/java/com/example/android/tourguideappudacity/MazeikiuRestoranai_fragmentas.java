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

public class MazeikiuRestoranai_fragmentas extends Fragment {


    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public MazeikiuRestoranai_fragmentas() {
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        Toolbar myToolbar = rootView.findViewById(R.id.my_toolbar);
        myToolbar.setVisibility(View.GONE);
        final ArrayList<word> Mrestoranai = new ArrayList<word>();
        Mrestoranai.add(new word(R.drawable.mazeikiu_restoranai, getActivity().getString(R.string.UzsukiteMazeikiuose)));
        Mrestoranai.add(new word(R.drawable.pekinas, getActivity().getString(R.string.PekinasTitle)));
        Mrestoranai.add(new word(R.drawable.arkos, getActivity().getString(R.string.Arkos)));
        Mrestoranai.add(new word(R.drawable.haochi, getActivity().getString(R.string.HoaChiTitle)));
        Mrestoranai.add(new word(R.drawable.laisves30, getActivity().getString(R.string.Laisves30Title)));
        Mrestoranai.add(new word(R.drawable.roala, getActivity().getString(R.string.Roala)));
        Mrestoranai.add(new word(R.drawable.rosso, getActivity().getString(R.string.Rosso)));
        Mrestoranai.add(new word(R.drawable.gama, getActivity().getString(R.string.PalmaTitle)));
        Mrestoranai.add(new word(R.drawable.picasso, getActivity().getString(R.string.Picasso)));
        Mrestoranai.add(new word(R.drawable.cacan, getActivity().getString(R.string.Can_Can)));
        Mrestoranai.add(new word(R.drawable.charlie, getActivity().getString(R.string.CharlieMazeikiaiTitle)));
        Mrestoranai.add(new word(R.drawable.daugiaup, ""));

       Adaptoreditor adapteris = new Adaptoreditor(getActivity(), Mrestoranai);
        ListView Listtranslated = rootView.findViewById(R.id.list);
        Listtranslated.setAdapter(adapteris);
        Listtranslated.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                switch (position) {
                    case 1:
                        mMediaPlayer = MediaPlayer.create(getActivity(), R.raw.garsas);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        Intent intent = new Intent(getActivity(), pekinas.class);
                        startActivity(intent);
                        break;
                    case 2:
                        skamb();
                        Intent intentas = new Intent(getActivity(), arkos.class);
                        startActivity(intentas);
                        break;
                    case 3:
                        skamb();
                        Intent intentas1 = new Intent(getActivity(), Haochi.class);
                        startActivity(intentas1);
                        break;
                    case 4:
                        skamb();
                        Intent intentas2 = new Intent(getActivity(), Laisves30.class);
                        startActivity(intentas2);
                        break;
                    case 5:
                        skamb();
                        Intent intentas3 = new Intent(getActivity(), Roala.class);
                        startActivity(intentas3);
                        break;
                    case 6:
                        skamb();
                        Intent intentas4 = new Intent(getActivity(), Rosso.class);
                        startActivity(intentas4);
                        break;
                    case 7:
                        skamb();
                        Intent intentas5 = new Intent(getActivity(), Gama.class);
                        startActivity(intentas5);
                        break;
                    case 8:
                        skamb();
                        Intent intentas6 = new Intent(getActivity(), Picasso.class);
                        startActivity(intentas6);
                        break;
                    case 9:
                        skamb();
                        Intent intentas7 = new Intent(getActivity(), Cancan.class);
                        startActivity(intentas7);
                        break;
                    case 10:
                        skamb();
                        Intent intentas8 = new Intent(getActivity(), Charlie.class);
                        startActivity(intentas8);
                        break;
                    case 11:
                        skamb();
                        String daugiau = getActivity().getString(R.string.MazeikiuRestoranaiUrl);
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                        startActivity(i);
                        break;
                }
            }
        });
        return rootView;
    }

    private void skamb() {
        mMediaPlayer = MediaPlayer.create(getActivity(), R.raw.garsas);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }
}
