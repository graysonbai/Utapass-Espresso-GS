package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.artists.ArtistsLineUp;


public class ArtistsPage extends BasicPage {

    private ArtistsLineUp artistsLineUp ;

    public ArtistsLineUp artistsLineUp() {
        if( this.artistsLineUp == null ) {
            this.artistsLineUp = new ArtistsLineUp() ;
        }
        return this.artistsLineUp ;
    }
}
