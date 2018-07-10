package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.* ;
import com.kddi.android.UtaPass.sqa_espresso.common.lineup.* ;

import java.util.regex.Pattern ;

import static android.support.test.espresso.action.ViewActions.click ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;


public class MyUtaPage extends BasicPage{

    private LibrarySongsLineUp librarySongsLineUp ;

    @Override
    public void _ready() {
        this.retryWhenNotReady = false ;
        this.playButton().ready() ;
    }

    public String getTotalDownloadedSongs() {
        java.util.regex.Matcher matcher =
            Pattern.compile( "Downloaded: ([0-9]+) Songs?" )
                   .matcher( this.getText( withId( R.id.myuta_downloaded_songs_count ) ) ) ;

        if( matcher.find() ) {
            return matcher.group( 1 ) ;
        }

        return "" ;
    }

    public PlayButton playButton() {
        return new PlayButton() ;
    }

    public LibrarySongsLineUp songsLineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the LibrarySongsLineUpOjbect ...
        if( this.librarySongsLineUp == null ) {
            this.librarySongsLineUp = new LibrarySongsLineUp() ;
        }
        return this.librarySongsLineUp ;
    }

    public class PlayButton extends ViewObject {

        public PlayButton() {
            this.item = onView( withId( R.id.myuta_play_all ) ) ;
        }

        public void _ready() {
            if( !this.isVisible( this.item ) ) {
                throw new RuntimeException( "MyUta play button is not visible" ) ;
            }
        }

        public void tap() {
            this.item.perform( click() ) ;
        }
    }
}
