package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton ;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class PlayButton extends BasicButton {

    public PlayButton() {
        super( () -> withId( R.id.myuta_play_all ) ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            throw new RuntimeException( "NotReady: MyUta > PlayButton" ) ;
        }
    }
}




