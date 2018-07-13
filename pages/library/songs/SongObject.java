package com.kddi.android.UtaPass.sqa_espresso.pages.library.songs ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class SongObject extends ViewObject {

    private String songName ;
    private String artistName ;
    private ViewInteraction photo ;

    public void songName( String songName ) {
        this.songName = songName ;
    }

    public String songName() {
        return this.songName ;
    }

    public void artistName( String artistName ) {
        this.artistName = artistName ;
    }

    public String artistName() {
        return this.artistName ;
    }

    public void photo( ViewInteraction coverPhoto ) {
        this.photo = coverPhoto ;
    }

    public void tap() {
        this.photo.perform( click() ) ;
    }
}


