package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class ArtistObject extends ViewObject {

    private String name ;
    private String albums ;
    private String songs ;
    private ViewInteraction photo ;

    public void name( String name ) {
        this.name = name ;
    }

    public String name() {
        return this.name ;
    }

    public void albums( String albums ) {
        this.albums = albums ;
    }

    public String albums() {
        return this.albums ;
    }

    public void songs( String songs ) {
        this.songs = songs ;
    }

    public String getTotalSongs() {
        return this.songs ;
    }

    public void photo( ViewInteraction photo ) {
        this.photo = photo ;
    }

    public void tap() {
        this.photo.perform( click() ) ;
    }
}


