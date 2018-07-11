package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.SongsLineUp;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class SongsPage extends BasicPage {

    private SongsLineUp songsLineUp ;

    public String getTotalTracks() {
        String raw = this.getText( withId( R.id.view_all_track_shuffle_play_length ) ) ;
        return raw.split( " tracks · " )[ 0 ] ;
    }

    public String getTotalTime() {
        String raw = this.getText( withId( R.id.view_all_track_shuffle_play_length ) ) ;
        return raw.split( " tracks · " )[ 1 ] ;
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
