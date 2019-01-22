package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IAlbumsName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMoreButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;


public class ArtistAlbumsPage extends BasicPage {

    private InternalLineUp lineup ;
    private BasicButton allSongsButton ;

    public ArtistAlbumsPage(){
        this.label( "ArtistAlbumsPage" ) ;
    }

    public String getTotalSongs() {
        String raw = this.getText( withId( R.id.detail_artist_description ) ) ;
        return raw.split( " · " )[ 0 ] ;
    }

    public String getTotalTime() {
        String raw = this.getText( withId( R.id.detail_artist_description ) ) ;
        return raw.split( " · " )[ 1 ] ;
    }

    public void _ready() {
        this.allSongsButton().ready() ;
    }

    public BasicButton allSongsButton() {
        return new BasicButton( () ->
                    withId( R.id.item_detail_artist_all_song_root_layout ) ) {
            public LazyString text() {
                    return new LazyString( this.label(),
                            () -> allOf(
                                    withClassName( endsWith( "TextView" ) ),
                                    isDescendantOfA( super.matcher.execute() ) ) ) ;
            }
        } ;
    }

    public InternalLineUp lineUp(){
        if( this.lineup == null){
            this.lineup = new InternalLineUp( this.label() );
        }
        return this.lineup;
    }

    public class InternalLineUp extends LineUpObject {
        public InternalLineUp( String label ){
            this.label( label + " > LineUp" );
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.detail_artist_recycler_view );
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return withId( R.id.item_detail_album_layout );
        }

        public InternalCard card(int index) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index );

            InternalCard card = new InternalCard();

            card.albumsName( this.label(),
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.item_detail_album_title ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.artistName( this.label(),
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.item_detail_album_artist ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.cover( this.label(),
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.item_detail_album_image ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.moreButton( this.label(),
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId( R.id.item_detail_album_overflow ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            return card;
        }

        public class InternalCard implements ICover, IArtistName, IAlbumsName, IMoreButton {

            String labelAlbumName;
            String labelArtistName;
            String labelCover;
            String labelMoreButton;

            LazyMatcher matcherAlbumName;
            LazyMatcher matcherArtistName;
            LazyMatcher matcherCover;
            LazyMatcher matcherMoreButton;

            @Override
            public void cover(String label, LazyMatcher matcher) {
                this.labelCover = label;
                this.matcherCover = matcher;
            }

            @Override
            public BasicImage cover() {
                return new BasicImage(this.labelCover, this.matcherCover);
            }

            @Override
            public void artistName(String label, LazyMatcher matcher) {
                this.matcherArtistName = matcher;
                this.labelArtistName = label;
            }

            public LazyString artistName() {
                return new LazyString(this.labelArtistName, this.matcherArtistName);
            }

            @Override
            public void albumsName(String label, LazyMatcher matcher) {
                this.labelAlbumName = label;
                this.matcherAlbumName = matcher;
            }

            @Override
            public LazyString albumsName() {
                return new LazyString(this.labelAlbumName, this.matcherAlbumName);
            }

            @Override
            public void moreButton(String label, LazyMatcher matcher) {
                this.labelMoreButton = label;
                this.matcherMoreButton = matcher;
            }

            @Override
            public BasicButton moreButton() {
                return new BasicButton(this.labelMoreButton, this.matcherMoreButton);
            }
        }
    }
}
