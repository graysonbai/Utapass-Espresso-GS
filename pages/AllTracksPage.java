package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.lineup.LibrarySongsLineUp ;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class AllTracksPage extends BasicPage{

    private LibrarySongsLineUp librarySongsLineUp ;

    public String getTotalTracks() {
        String raw = this.getText( withId( R.id.view_all_track_shuffle_play_length ) ) ;
        return raw.split( " tracks · " )[ 0 ] ;
    }

    public String getTotalTime() {
        String raw = this.getText( withId( R.id.view_all_track_shuffle_play_length ) ) ;
        return raw.split( " tracks · " )[ 1 ] ;
    }

    public LibrarySongsLineUp songsLineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the LibrarySongsLineUpObject ...
        if( this.librarySongsLineUp == null ) {
            this.librarySongsLineUp = new LibrarySongsLineUp() ;
        }
        return this.librarySongsLineUp ;
    }
}
