package com.kddi.android.UtaPass.sqa_espresso.pages.library.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;

public abstract class LibraryLineUp extends LineUpObject {

    private TitleBar titleBar ;

    public LibraryLineUp() {
        this.setMaxIndexOfLineUpObject( 25 ) ;
    }

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        if( this.titleBar().isVisible() ) {
            this.titleBar().swipeUp() ;
            this.resetMaxIndexOfWindow() ;
        }

        this.swipeToLeftmost() ;
        this.swipeToPosition( index ) ;

        if( index > this.getMaxIndexOfWindow() ) {
            return this.getMaxIndexOfWindow() ;
        }

        return index ;
    }

    public TitleBar titleBar() {
        if( this.titleBar == null ) {
            this.titleBar = new TitleBar() ;
        }
        return this.titleBar ;
    }
}