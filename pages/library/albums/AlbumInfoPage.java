package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.info.SongsLineUp;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.ShuffleAllButton;

import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class AlbumInfoPage extends BasicPage {

    private SongsLineUp songsLineUp ;
    private ShuffleAllButton shuffleAllButton ;

    public String totalSongs() {
        String raw = this.getText( withId( R.id.detail_album_description ) ) ;
        return raw.split( " · " )[ 0 ] ;
    }

    public String totalTime() {
        String raw = this.getText( withId( R.id.detail_album_description ) ) ;
        return raw.split( " · " )[ 1 ] ;
    }

    public SongsLineUp songsLineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the LibrarySongsLineUpObject ...
        if( this.songsLineUp == null ) {
            this.songsLineUp = new SongsLineUp() ;
        }
        return this.songsLineUp ;
    }

    public ShuffleAllButton shuffleAllButton() {
        if( this.shuffleAllButton == null ) {
            this.shuffleAllButton = new ShuffleAllButton() ;
        }
        return this.shuffleAllButton ;
    }
}
