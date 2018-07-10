package com.kddi.android.UtaPass.sqatest.common ;

import android.support.test.espresso.ViewInteraction;
import static android.support.test.espresso.action.ViewActions.click;

public class LibrarySongObject extends ViewObject {

    private String songName ;
    private String artistName ;
    private ViewInteraction coverPhoto ;

    public void setSongName( String songName ) {
        this.songName = songName ;
    }

    public String getSongName() {
        return this.songName ;
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


