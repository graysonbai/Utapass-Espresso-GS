package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class CardObject extends ViewObject {

    private String title ;
    private int likedCount ;
    private Photo background ;
    private PlayButton playButton ;

    public PlayButton playButton() {
        return this.playButton ;
    }

    public void playButton( ViewInteraction playButton ) {
        this.playButton = new PlayButton( playButton ) ;
    }

    public Photo background() {
        return this.background ;
    }

    public void background( ViewInteraction background ) {
        this.background = new Photo( background ) ;
    }

    public void title( String title ) {
        this.title = title ;
    }

    public String title() {
        return this.title ;
    }

    public void likedCount( int likedCount ) {
        this.likedCount = likedCount ;
    }

    public void likedCount( String likedCount ) {
        this.likedCount( Integer.parseInt( likedCount ) ) ;
    }

    public int likedCount() {
        return this.likedCount ;
    }

    public void play() {
        this.playButton.tap() ;
    }

    public void tap() {
        this.background.tap() ;
    }

    public class PlayButton extends ViewObject {

        public PlayButton( ViewInteraction button ) {
            this.item = button ;
        }

        public void _ready() {
            if( !this.isVisible( this.item ) ) {
                throw new RuntimeException( "PlayButton is not visible" ) ;
            }
        }

        public void tap() {
            this.item.perform( click() ) ;
        }
    }

    public class Photo extends ViewObject {

        public Photo( ViewInteraction photo ) {
            this.item = photo ;
        }

        public void _ready() {
            if( !this.isVisible( this.item ) ) {
                throw new RuntimeException( "BackgroupPhoto is not visible" ) ;
            }
        }

        public void tap() {
            this.item.perform( click() ) ;
        }
    }
}


