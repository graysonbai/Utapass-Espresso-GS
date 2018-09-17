package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class SongObject extends ViewObject {

    private String songName ;
    private String artistName ;
    private MyUtaButton myUtaButton ;

    private WorkaroundToFindCoverPhoto matcherForCoverPhoto ;

    public boolean isVisible() {
        return this.isVisible( this.matcherForCoverPhoto.execute() ) ;
    }

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

    public void myUtaButton( MyUtaButton myUtaButton ) {
        this.myUtaButton = myUtaButton ;
    }

    public MyUtaButton myUtaButton() {
        return this.myUtaButton ;
    }

    public void tap() {
        this.matcherForCoverPhoto.execute().perform( click() ) ;
    }

    public void cover( WorkaroundToFindCoverPhoto workaround ) {
        this.matcherForCoverPhoto = workaround ;
    }

    public interface WorkaroundToFindCoverPhoto {
        ViewInteraction execute() ;
    }
}


