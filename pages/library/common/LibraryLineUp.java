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

        //                                 Max
        //         swipe      IndexOf    IndexOf
        // index    to        Window     Window
        // ========================================
        //  0        0          0           8
        //  1        1          1           8
        //  2        2          2           8
        //  ...      ...        ...         ...
        //  8        8          8           8

        //  9        9          8           8
        // 10       10          8           8
        // 11       11          8           8
        // 12       12          8           8
        //
        this.swipeToPosition( index ) ;

        if( index > this.maxIndexFirstWindow() ) {
            return this.maxIndexFirstWindow() + 1 ;
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