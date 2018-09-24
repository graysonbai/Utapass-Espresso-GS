package com.kddi.android.UtaPass.sqa_espresso.common ;

public class NextButton extends BasicButton {

    public NextButton( LazyMatcher matcher ) {
        super( matcher ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            String msg = "NotReady: " + this.getClass().getSimpleName() ;
            throw new RuntimeException( msg ) ;
        }
    }
}




