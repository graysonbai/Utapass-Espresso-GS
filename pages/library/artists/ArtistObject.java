package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class ArtistObject extends ViewObject {

    private String artistName ;
    private String totalAlbums ;
    private String totalSongs ;
    private ViewInteraction coverPhoto ;

    public void setArtistName( String artistName ) {
        this.artistName = artistName ;
    }

    public String getArtistName() {
        return this.artistName ;
    }

    public void setTotalAlbums( String totalAlbums ) {
        this.totalAlbums = totalAlbums ;
    }

    public String getTotalAlbums() {
        return this.totalAlbums ;
    }

    public void setTotalSongs( String totalSongs ) {
        this.totalSongs = totalSongs ;
    }

    public String getTotalSongs() {
        return this.totalSongs ;
    }

    public void setCoverPhoto( ViewInteraction coverPhoto ) {
        this.coverPhoto = coverPhoto ;
    }

    public void tap() {
        this.coverPhoto.perform( click() ) ;
    }
}


