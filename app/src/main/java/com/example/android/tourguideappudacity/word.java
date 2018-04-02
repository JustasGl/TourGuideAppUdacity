package com.example.android.tourguideappudacity;


public class word {

    private String mPavadinimas;
    private int mFoto;

    public word(int foto, String Pavadinimas) {
        mFoto = foto;
        mPavadinimas = Pavadinimas;
    }

    public String getTag() {
        return mPavadinimas;
    }

    public int getFoto() {
        return mFoto;
    }

}
