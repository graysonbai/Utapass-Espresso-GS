package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card ;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

public class CardObject extends ViewObject {
    private LazyMatcher matcherImage ;
    private LazyMatcher matcherPlayButton ;
    private LazyMatcher matcherTitle ;
    private LazyMatcher matcherLikedCount ;

    public BasicImage image() {
        return new BasicImage( this.matcherImage ) ;
    }

    public void image( LazyMatcher matcher ) {
        this.matcherImage = matcher ;
    }

    public BasicButton playButton() {
        return new BasicButton( this.matcherPlayButton ) ;
    }

    public void playButton( LazyMatcher matcher ) {
        this.matcherPlayButton = matcher ;
    }

    public LazyString title() {
        return new LazyString( this.matcherTitle ) ;
    }

    public void title( LazyMatcher matcher ) {
        this.matcherTitle = matcher ;
    }

    public LazyString likedCount() {
        return new LazyString( this.matcherLikedCount ) ;
    }

    public void likedCount( LazyMatcher matcher ) {
        this.matcherLikedCount = matcher ;
    }

    public void play() {
        this.playButton().tap() ;
    }

    public void tap() {
        this.image().tap() ;
    }
}


