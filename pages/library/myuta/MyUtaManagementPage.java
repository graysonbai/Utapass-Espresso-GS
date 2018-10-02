package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.SongsLineUp ;

import java.util.regex.Pattern ;

import static android.support.test.espresso.matcher.ViewMatchers.* ;


public class MyUtaManagementPage extends BasicPage {

    private MyUtaHistoryButton myUtaHistoryButton ;
    private SongsLineUp songsLineUp ;

    public MyUtaManagementPage() {
        super() ;

        this.retryWhenNotReady( false ) ;
    }

    public String remainingQuotas() {
        return this.getText( withId( R.id.myuta_available_quota_count ) ) ;
    }

    public MyUtaHistoryButton myUtaHistoryButton() {
        if( this.myUtaHistoryButton == null ) {
            this.myUtaHistoryButton = new MyUtaHistoryButton() ;
        }
        return this.myUtaHistoryButton ;
    }

    public String downloadedSongs() {
        java.util.regex.Matcher matcher =
            Pattern.compile( "([0-9]+)" )
                   .matcher( this.getText( withId( R.id.myuta_downloaded_songs_count ) ) ) ;

        if( matcher.find() ) {
            return matcher.group( 1 ) ;
        }

        return "" ;
    }

    public SongsLineUp lineUp() {

        // Since the maxIndexOfLineUpObject will be changed after swiping,
        // We need to reuse the SongsLineUp object ...
        if( this.songsLineUp == null ) {
            this.songsLineUp = new SongsLineUp() ;
        }
        return this.songsLineUp ;
    }
}
