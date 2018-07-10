package com.kddi.android.UtaPass.sqa_espresso.common.lineup ;

public abstract class LibraryLineUp extends LineUpObject {

    public LibraryLineUp() {
        this.setMaxIndexOfLineUpObject( 25 ) ;
    }

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        this.swipeToLeftmost() ;

        if( index > this.maxIndexOfWindow ) {
            this.swipeToPosition( index + 1 ) ;
            return this.maxIndexOfWindow + 1 ;
        }

        return index ;
    }
}