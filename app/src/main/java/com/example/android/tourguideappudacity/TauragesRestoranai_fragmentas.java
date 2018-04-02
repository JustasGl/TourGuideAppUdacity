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

public class TauragesRestoranai_fragmentas extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public TauragesRestoranai_fragmentas() {
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

        final ArrayList<word> Taurestoranai = new ArrayList<word>();
        Taurestoranai.add(new word(R.drawable.taurages_restoranai,  getActivity().getString(R.string.UzsukiteTaurageje)));
        Taurestoranai.add(new word(R.drawable.saukstelis,  getActivity().getString(R.string.Saukstelis)));
        Taurestoranai.add(new word(R.drawable.starrpizza,  getActivity().getString(R.string.StarrPizza)));
        Taurestoranai.add(new word(R.drawable.skoniodziazas, getActivity().getString(R.string.SkonioDzazas)));
        Taurestoranai.add(new word(R.drawable.elgreco, getActivity().getString(R.string.ElGrecoTitle)));
        Taurestoranai.add(new word(R.drawable.hesburger, getActivity().getString(R.string.hesburger)));
        Taurestoranai.add(new word(R.drawable.daugiaup, ""));

        Adaptoreditor adapteris = new Adaptoreditor(getActivity(), Taurestoranai);
        ListView Listtranslated = (ListView) rootView.findViewById(R.id.list);
        Listtranslated.setAdapter(adapteris);
        Listtranslated.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                word listas = Taurestoranai.get(position);

                switch (position) {
                    case 1:
                        skamb();
                        Intent intent = new Intent(getActivity(), saukstelis.class);
                        startActivity(intent);
                        break;
                    case 2:
                        skamb();
                        Intent intentas = new Intent(getActivity(), starrpizza.class);
                        startActivity(intentas);
                        break;
                    case 3:
                        skamb();
                        Intent intentas1 = new Intent(getActivity(), skoniodziazas.class);
                        startActivity(intentas1);
                        break;
                    case 4:
                        skamb();
                        Intent intentas2 = new Intent(getActivity(), elgreco.class);
                        startActivity(intentas2);
                        break;
                    case 5:
                        skamb();
                        Intent intentas3 = new Intent(getActivity(), hesburger.class);
                        startActivity(intentas3);
                        break;

                    case 6:
                        skamb();
                        String daugiau = getActivity().getString(R.string.TauragesRestoranaiUrl);
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(daugiau));
                        startActivity(i);
                        break;
                }
            }
        });
        return rootView;
    }

}
