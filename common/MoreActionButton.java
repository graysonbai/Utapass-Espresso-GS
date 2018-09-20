package com.kddi.android.UtaPass.sqa_espresso.common ;

public class MoreActionButton extends BasicButton {
    public MoreActionButton( LazyMatcher matcher ) {
        super( matcher ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            String msg = "NotReady: Song > MoreActionButton" ;
            throw new RuntimeException( msg ) ;
        }
    }
}




