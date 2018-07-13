package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class AlbumObject extends ViewObject {

    private String albumName ;
    private String artistName ;
    private ViewInteraction photo ;

    public void albumName( String albumName ) {
        this.albumName = albumName ;
    }

    public String albumName() {
        return this.albumName ;
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


