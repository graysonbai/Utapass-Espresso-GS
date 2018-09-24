package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card ;

import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.PlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;


public class RadioCard extends ViewObject {

    private StringObject name ;
    private PlayButton playButton ;

    public PlayButton playButton() {
        return this.playButton ;
    }

    public void playButton( LazyMatcher matcher ) {
        this.playButton = new PlayButton( matcher ) ;
    }

    public StringObject name() {
        return this.name ;
    }

    public void name( LazyMatcher matcher ) {
        this.name = new StringObject( this.getText( matcher.execute() ) ) ;
    }

    //
    public void play() {
        this.playButton.tap() ;
    }
}


