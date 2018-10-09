package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.MyUtaHistoryButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.common.SongsLineUp ;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.PlayButton ;

import java.util.regex.Pattern ;

import static android.support.test.espresso.matcher.ViewMatchers.* ;


public class MyUtaPage extends BasicPage {

    private MyUtaHistoryButton myUtaHistoryButton ;
    private PlayButton playButton ;
    private SongsLineUp songsLineUp ;

    public MyUtaPage() {
        super() ;

        this.retryWhenNotReady( false ) ;
    }

    @Override
    public void _ready() {
        this.myUtaHistoryButton().ready() ;
    }

    public LazyString remainingQuotas() {
        return new LazyString( () -> withId( R.id.myuta_available_quota_count ) ) ;
    }

    public MyUtaHistoryButton myUtaHistoryButton() {
        if( this.myUtaHistoryButton == null ) {
            this.myUtaHistoryButton = new MyUtaHistoryButton() ;
        }
        return this.myUtaHistoryButton ;
    }

    public PlayButton playButton() {
        if( this.playButton == null ) {
            this.playButton = new PlayButton() ;
        }
        return this.playButton ;
    }

    public LazyString downloadedSongs() {
        return new LazyString( () -> withId( R.id.myuta_downloaded_songs_count ) ) {

            @Override
            public String string() {
                this.ready() ;
                java.util.regex.Matcher regexMatcher =
                        Pattern.compile( "([0-9]+)" ).matcher( super.string() ) ;

                if( regexMatcher.find() ) {
                    return regexMatcher.group( 1 ) ;
                }

                throw new StringInvisibleException(
                        "Library > MyUta > MyUta Page > Downloaded Songs" ) ;
            }
        } ;
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
