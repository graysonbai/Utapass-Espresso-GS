package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.ViewInteraction;
import static android.support.test.espresso.action.ViewActions.click;

public class CardObject extends ViewObject {

    private String title ;

    private int indexInLineUpObject ;
    private int likedCount ;

    private ViewInteraction background ;
    private ViewInteraction playButton ;

    public CardObject( int indexInLineUpObject ) {
        this.indexInLineUpObject = indexInLineUpObject ;
    }

    public CardObject( ViewInteraction playButton ) {
        this.setPlayButton( playButton ) ;
    }

    public CardObject( ViewInteraction background, ViewInteraction playButton ) {
        this.setBackground( background ) ;
        this.setPlayButton( playButton ) ;
    }

    public void setPlayButton( ViewInteraction playButton ) {
        this.playButton = playButton ;
    }

    public void setBackground( ViewInteraction background ) {
        this.background = background ;
    }

    public void setTitle( String title ) {
        this.title = title ;
    }

    public String getTitle() {
        return this.title ;
    }

    public void setLikedCount( int likedCount ) {
        this.likedCount = likedCount ;
    }

    public void setLikedCount( String likedCount ) {
        this.setLikedCount( Integer.parseInt( likedCount ) ) ;
    }

    public int getLikedCount() {
        return this.likedCount ;
    }

    public void play() {
        this.playButton.perform( click() ) ;
    }

    public void tap() {
        this.background.perform( click() ) ;
    }
}


