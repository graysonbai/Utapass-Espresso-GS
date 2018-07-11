package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class AlbumObject extends ViewObject {

    private String albumName ;
    private String artistName ;
    private ViewInteraction coverPhoto ;

    public void setAlbumName( String albumName ) {
        this.albumName = albumName ;
    }

    public String getAlbumName() {
        return this.albumName ;
    }

    public void setArtistName( String artistName ) {
        this.artistName = artistName ;
    }

    public String getArtistName() {
        return this.artistName ;
    }

    public void setCoverPhoto( ViewInteraction coverPhoto ) {
        this.coverPhoto = coverPhoto ;
    }

    public void tap() {
        this.coverPhoto.perform( click() ) ;
    }
}


