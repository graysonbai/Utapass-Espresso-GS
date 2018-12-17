package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumsLineUp ;


public class AlbumsPage extends BasicPage {

    private AlbumsLineUp albumsLineUp ;

    public void _ready(){
        if( ! UserStatus.isLibrarySongSynced ) {
            UtaPassUtil.sleep( 30, "for local song synced" ) ;
            UserStatus.isLibrarySongSynced = true ;
        }
    }

    public AlbumsLineUp albumsLineUp() {
        if( this.albumsLineUp == null ) {
            this.albumsLineUp = new AlbumsLineUp() ;
        }
        return this.albumsLineUp ;
    }
}
