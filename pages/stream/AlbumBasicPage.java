package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.ShowMoreButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.StreamLineUp;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;


public class AlbumBasicPage extends BasicPage {

    private BasicButton favoriteButton ;
    private BasicButton playButton ;
    private BasicButton shuffleAllButton ;
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

    public BasicButton favoriteButton() {
        if( this.favoriteButton == null ) {
            this.favoriteButton = new BasicButton( () ->
                    withId( R.id.detail_editor_like_layout ) ) ;
        }

        this.songsLineUp().swipeToPosition( 0 ) ;
        return this.favoriteButton ;
    }

    public String description() {
        this.songsLineUp().swipeToPosition( 0 ) ;
        return this.getText( withId( R.id.detail_editor_description ) ) ;
    }

    public BasicButton playButton() {
        if( this.playButton == null ) {
            this.playButton = new BasicButton( () ->
                    withId( R.id.view_shuffle_play_layout ) ) ;
        }

        this.songsLineUp().swipeToPosition( 1 ) ;
        return this.playButton ;
    }

    public BasicButton shuffleAllButton() {
        if( this.shuffleAllButton == null ) {
            this.shuffleAllButton = new BasicButton( () ->
                    allOf( withId( R.id.view_shuffle_play_layout ),
                           withParent( withId( R.id.detail_album_recycler_view ) ) ) ) ;
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
            this.showMoreButton = new ShowMoreButton(
                    this.songsLineUp(),
                    () -> withId( R.id.item_detail_show_more ) ) ;
        }
        this.songsLineUp().swipeToShowMoreButton() ;
        return this.showMoreButton ;
    }
}




