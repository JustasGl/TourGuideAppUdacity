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

public class TelsiuRestoranai_fragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public TelsiuRestoranai_fragment() {
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

        Toolbar myToolbar = (Toolbar) rootView.findViewById(R.id.my_toolbar);
        myToolbar.setVisibility(View.GONE);

        final ArrayList<word> Trestoranai = new ArrayList<word>();
        Trestoranai.add(new word(R.drawable.telsiu_restoranai, getActivity().getString(R.string.UzsukiteTelsiuose)));
        Trestoranai.add(new word(R.drawable.dziugonamai, getActivity().getString(R.string.DziugoNamaiTitle)));
        Trestoranai.add(new word(R.drawable.teatro, getActivity().getString(R.string.TeatroKavine)));
        Trestoranai.add(new word(R.drawable.tela, getActivity().getString(R.string.Tela)));
        Trestoranai.add(new word(R.drawable.ljancauskienes, getActivity().getString(R.string.Jancauskienes)));
        Trestoranai.add(new word(R.drawable.guesthouse, getActivity().getString(R.string.SinchronasTitle)));
        Trestoranai.add(new word(R.drawable.oldquart, getActivity().getString(R.string.OldQuart)));
        Trestoranai.add(new word(R.drawable.antkalno, getActivity().getString(R.string.AntKalno)));
        Trestoranai.add(new word(R.drawable.raudonasissanchajus, getActivity().getString(R.string.Sanchajus)));
        Trestoranai.add(new word(R.drawable.jonziedis, getActivity().getString(R.string.JonziedisTitle)));
        Trestoranai.add(new word(R.drawable.lisiteja, getActivity().getString(R.string.LisitejaTitle)));
        Trestoranai.add(new word(R.drawable.daugiaup, ""));

        Adaptoreditor adapteris = new Adaptoreditor(getActivity(), Trestoranai);
        ListView Listtranslated = (ListView) rootView.findViewById(R.id.list);
        Listtranslated.setAdapter(adapteris);
        Listtranslated.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                word listas = Trestoranai.get(position);

                switch (position) {
                    case 1:
                        skamb();
                        Intent intent = new Intent(getActivity(), dziugonamai.class);
                        startActivity(intent);
                        break;
                    case 2:
                        skamb();
                        Intent intentas = new Intent(getActivity(), teatrokavine.class);
                        startActivity(intentas);
                        break;
                    case 3:
                        skamb();
                        Intent intentas1 = new Intent(getActivity(), tela.class);
                        startActivity(intentas1);
                        break;
                    case 4:
                        skamb();
                        Intent intentas2 = new Intent(getActivity(), jancauskienes.class);
                        startActivity(intentas2);
                        break;
                    case 5:
                        skamb();
                        Intent intentas3 = new Intent(getActivity(), guesthouse.class);
                        startActivity(intentas3);
                        break;
                    case 6:
                        skamb();
                        Intent intentas4 = new Intent(getActivity(), oldquart.class);
                        startActivity(intentas4);
                        break;
                    case 7:
                        skamb();
                        Intent intentas5 = new Intent(getActivity(), antkalno.class);
                        startActivity(intentas5);
                        break;
                    case 8:
                        skamb();
                        Intent intentas6 = new Intent(getActivity(), sanchajus.class);
                        startActivity(intentas6);
                        break;
                    case 9:
                        skamb();
                        Intent intentas7 = new Intent(getActivity(), jonziedis.class);
                        startActivity(intentas7);
                        break;
                    case 10:
                        skamb();
                        Intent intentas8 = new Intent(getActivity(), lisiteja.class);
                        startActivity(intentas8);
                        break;
                    case 11:
                        skamb();
                        String daugiau = getActivity().getString(R.string.TelsiuRestoranaiUrl);
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
