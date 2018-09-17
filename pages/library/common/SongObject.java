package com.kddi.android.UtaPass.sqa_espresso.pages.library.common ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.MyUtaButton;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SongObject extends ViewObject {

    private String songName ;
    private String artistName ;

    private LazyMatcher matcherCoverPhoto ;
    private LazyMatcher matcherMoreActionButton ;

    public boolean isVisible() {
        return this.isVisible( this.matcherCoverPhoto.execute() ) ;
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

    public void tap() {
        this.matcherCoverPhoto.execute().perform( click() ) ;
    }

    public void cover( LazyMatcher workaround ) {
        this.matcherCoverPhoto = workaround ;
    }

    public void moreActionButton( LazyMatcher workaround ) {
        this.matcherMoreActionButton = workaround ;
    }

    public MoreActionButton moreActionButton() {
        return new MoreActionButton( this.matcherMoreActionButton.execute() ) ;
    }

    public interface LazyMatcher {
        ViewInteraction execute() ;
    }
}


