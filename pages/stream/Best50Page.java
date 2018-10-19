package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

public class Best50Page extends AlbumBasicPage {

    public InternalLineUp lineUp() {
        InternalLineUp lineUp = super.lineUp() ;
        lineUp.setMaxIndexOfLineUpObject( 49 ) ;
        return lineUp ;
    }
}
