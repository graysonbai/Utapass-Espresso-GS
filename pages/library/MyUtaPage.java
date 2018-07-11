package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.SongsLineUp ;

import java.util.regex.Pattern ;

import static android.support.test.espresso.action.ViewActions.click ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;


public class MyUtaPage extends BasicPage {

    private SongsLineUp songsLineUp ;

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

    public SongsLineUp songsLineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the SongsLineUp object ...
        if( this.songsLineUp == null ) {
            this.songsLineUp = new SongsLineUp() ;
        }
        return this.songsLineUp ;
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
