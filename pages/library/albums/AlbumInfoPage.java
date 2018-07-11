package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.info.SongsLineUp;

import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class AlbumInfoPage extends BasicPage {

    private SongsLineUp songsLineUp ;

    public String getTotalSongs() {
        String raw = this.getText( withId( R.id.detail_album_description ) ) ;
        return raw.split( " songs · " )[ 0 ] ;
    }

    public String getTotalTime() {
        String raw = this.getText( withId( R.id.detail_album_description ) ) ;
        return raw.split( " songs · " )[ 1 ] ;
    }

    public SongsLineUp songsLineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the LibrarySongsLineUpObject ...
        if( this.songsLineUp == null ) {
            this.songsLineUp = new SongsLineUp() ;
        }
        return this.songsLineUp ;
    }
}
