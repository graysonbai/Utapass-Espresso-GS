package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;


public class ShowMoreButton extends BasicButton {

    private StreamLineUp streamLineUp ;

    public ShowMoreButton( StreamLineUp streamLineUp, LazyMatcher matcher ) {
        super( matcher ) ;

        this.streamLineUp = streamLineUp ;
    }

    public void tap() {
        super.tap() ;

        this.streamLineUp.resetMaxIndexOfWindow() ;
    }
}




