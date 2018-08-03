package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.FavoriteButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.ShowMoreButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.PlayButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.ShuffleAllButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.StreamLineUp;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class AlbumBasicPage extends BasicPage {

    private FavoriteButton favoriteButton ;
    private PlayButton playButton ;
    private ShuffleAllButton shuffleAllButton ;
    private StreamLineUp songsLineUp ;
    private ShowMoreButton showMoreButton ;

    // After swiping, structure of this page will be modified.
    // Then, there's no good generic point to verify this page is ready before and after swiping.
    // Thus, use a flag to indicate page is ready at the first time.
    private boolean readyFlag ;

    public void _ready() {
        if( this.readyFlag ) {
            return ;
        }

        if( ! this.favoriteButton().isVisible() ) {
            throw new RuntimeException( "FavoriteButton is not visible" ) ;
        }

        if( ! this.playButton().isVisible() ) {
            throw new RuntimeException( "PlayButton is not visible" ) ;
        }

        this.readyFlag = true ;
    }

    public String title() {
        return this.getText( withId( R.id.detail_editor_title ) ) ;
    }

    public FavoriteButton favoriteButton() {
        if( this.favoriteButton == null ) {
            this.favoriteButton = new FavoriteButton() ;
        }

        this.songsLineUp().swipeToPosition( 0 ) ;
        return this.favoriteButton ;
    }

    public String description() {
        this.songsLineUp().swipeToPosition( 0 ) ;
        return this.getText( withId( R.id.detail_editor_description ) ) ;
    }

    public PlayButton playButton() {
        if( this.playButton == null ) {
            this.playButton = new PlayButton() ;
        }

        this.songsLineUp().swipeToPosition( 1 ) ;
        return this.playButton ;
    }

    public ShuffleAllButton shuffleAllButton() {
        if( this.shuffleAllButton == null ) {
            this.shuffleAllButton = new ShuffleAllButton() ;
        }

        this.songsLineUp().swipeToPosition( 1 ) ;
        return this.shuffleAllButton ;
    }

    public StreamLineUp songsLineUp() {
        if( this.songsLineUp == null ) {
            this.songsLineUp = new StreamLineUp() ;
        }
        return this.songsLineUp ;
    }

    public ShowMoreButton showMoreButton() {
        if( this.showMoreButton == null ) {
            this.showMoreButton = new ShowMoreButton( this.songsLineUp() ) ;
        }
        this.songsLineUp().swipeToShowMoreButton() ;
        return this.showMoreButton ;
    }
}



