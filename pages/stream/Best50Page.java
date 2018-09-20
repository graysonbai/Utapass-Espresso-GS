package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.StreamLineUp;

public class Best50Page extends AlbumBasicPage {

    public StreamLineUp songsLineUp() {
        StreamLineUp lineup = super.songsLineUp() ;
        lineup.setMaxIndexOfLineUpObject( 50 ) ;

        return lineup ;
    }
}




