package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

public class Best50Page extends AlbumDetailPage {

    public InternalLineUp lineUp() {
        InternalLineUp lineUp = super.lineUp() ;
        lineUp.setMaxIndexOfLineUpObject( 49 ) ;
        return lineUp ;
    }
}
