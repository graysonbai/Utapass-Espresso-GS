package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card ;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.action.ViewActions.click;

public class CardObject extends ViewObject {

    private Photo background ;

    private LazyMatcher matcherPlayButton ;
    private LazyMatcher matcherTitle ;
    private LazyMatcher matcherLikedCount ;

    public BasicButton playButton() {
        return new BasicButton( this.matcherPlayButton ) ;
    }

    public void playButton( LazyMatcher matcher ) {
        this.matcherPlayButton = matcher ;
    }

    public Photo background() {
        return this.background ;
    }

    public void background( ViewInteraction background ) {
        this.background = new Photo( background ) ;
    }

    public void title( LazyMatcher matcher ) {
        this.matcherTitle = matcher ;
    }

    public LazyString title() {
        return new LazyString( this.matcherTitle ) ;
    }

    public void likedCount( LazyMatcher matcher ) {
        this.matcherLikedCount = matcher ;
    }

    public LazyString likedCount() {
        return new LazyString( this.matcherLikedCount ) ;
    }

    public void play() {
        this.playButton().tap() ;
    }

    public void tap() {
        this.background.tap() ;
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


