package com.kddi.android.UtaPass.sqa_espresso.common ;

public class PlayButton extends BasicButton {

    public PlayButton( LazyMatcher matcher ) {
        super( matcher ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            String msg = "NotReady: PlayButton" ;
            throw new RuntimeException( msg ) ;
        }
    }
}




