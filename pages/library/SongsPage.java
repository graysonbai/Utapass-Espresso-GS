package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.SongsLineUp;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class SongsPage extends BasicPage {

    private SongsLineUp songsLineUp ;
    private LazyString tapHere ;

    public SongsPage() {
        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        if( UserStatus.isLibrarySongSynced ) {
            return;
        }

        UtaPassUtil.sleep( 30, "for local song synced" ) ;
        UserStatus.isReadExternalStorageGranted = true ;
    }

    public StringObject tapHere() {
        if( this.tapHere == null ) {
            this.tapHere = new LazyString( () -> withId( R.id.link_library_notice_text ) ) {

                public String name() {
                    return "Library > Songs > 'tap here' link" ;
                }
            } ;
        }
        return this.tapHere.text() ;
    }

    public String totalTracks() {
        String raw = this.getText( withId( R.id.view_all_track_shuffle_play_length ) ) ;
        return raw.split( " tracks · " )[ 0 ] ;
    }

    public String totalTime() {
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
