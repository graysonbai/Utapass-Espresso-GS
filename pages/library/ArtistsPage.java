package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UserStatus;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IAlbumsCount;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMoreButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongsCount;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISubtitle;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import java.util.regex.Pattern;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class ArtistsPage extends BasicPage {
    private  InternalLineUp lineUp;

    public ArtistsPage(){
        this.label( "ArtistsPage" );
    }

    public void _ready(){
        if( ! UserStatus.isLibrarySongSynced ) {
            UtaPassUtil.sleep( 30, "for local song synced" ) ;
            UserStatus.isLibrarySongSynced = true ;
        }
    }

    public InternalLineUp lineUp(){
        if( this.lineUp == null){
            this.lineUp = new InternalLineUp( this.label() );
        }
        return this.lineUp;
    }

    public class InternalLineUp extends LineUpObject {
        public InternalLineUp( String label ){
            this.label( label + " > LineUp" );
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId(R.id.local_track_recycler_view);
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return withId(R.id.item_library_local_artist_layout);
        }

        private String subtitle( int indexInWindow ) {
            return this.getText(
                    UtaPassUtil.withIndex(
                            allOf( withId( R.id.item_library_local_artist_subtitle ),
                                    isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                            indexInWindow ) ) ;
        }

        private String albums( int indexInWindow ) {
            java.util.regex.Matcher matcher =
                    Pattern.compile( "([0-9]+).+([0-9]+).+" )
                            .matcher( this.subtitle( indexInWindow ) ) ;

            if( matcher.find() ) {
                return matcher.group( 1 ) ;
            }

            return "" ;
        }

        private String songs( int indexInWindow ) {
            java.util.regex.Matcher matcher =
                    Pattern.compile( "([0-9]+).+([0-9]+).+" )
                            .matcher( this.subtitle( indexInWindow ) ) ;

            if( matcher.find() ) {
                return matcher.group( 2 ) ;
            }

            return "" ;
        }

        public InternalCard card(int index) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index );
            InternalCard card = new InternalCard();

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.subtitle( label + " > subtitle",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId(R.id.item_library_local_artist_subtitle ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.artistName( label + " > artistName",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId(R.id.item_library_local_artist_title ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.cover( label + " > cover",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId(R.id.item_library_local_artist_icon ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.moreButton( label + " > moreButton",
                    () -> UtaPassUtil.withIndex(
                            allOf(
                                    withId(R.id.item_library_local_artist_overflow ),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            card.subtitle( label + " > subtitle",
                    () -> UtaPassUtil.withIndex(
                                    allOf( withId( R.id.item_library_local_artist_subtitle ),
                                            isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                                    indexInWindow ) ) ;

            card.albumsCount(label + "albumsCount" ,
                    this.albums( indexInWindow ) ) ;

            card.songsCount( label + "songsCount" ,
                    this.songs( indexInWindow ) ) ;

            return card;
        }

        public class InternalCard implements ICover, IArtistName, ISubtitle, IMoreButton, IAlbumsCount, ISongsCount {

            String labelSubtitle;
            String labelArtistName;
            String labelCover;
            String labelMoreButton;
            String labelAlbumsCount;
            String labelSongsCount;

            LazyMatcher matcherSubtitle;
            LazyMatcher matcherArtistName;
            LazyMatcher matcherCover;
            LazyMatcher matcherMoreButton;
            String matcherAlbumsCount;
            String matcherSongsCount;

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
            public void subtitle(String label, LazyMatcher matcher) {
                this.labelSubtitle = label;
                this.matcherSubtitle = matcher;
            }

            @Override
            public LazyString subtitle() {
                return new LazyString(this.labelSubtitle, this.matcherSubtitle);
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

            @Override
            public void albumsCount(String label, String matcher) {
                this.labelAlbumsCount = label;
                this.matcherAlbumsCount = matcher;
            }

            @Override
            public StringObject albumsCount() {
               return new StringObject( this.labelAlbumsCount, this.matcherAlbumsCount );
            }

            @Override
            public void songsCount(String label, String matcher) {
                this.labelSongsCount = label;
                this.matcherSongsCount = matcher;
            }

            @Override
            public StringObject songsCount() {
                return new StringObject( this.labelSongsCount, this.matcherSongsCount );
            }
        }
    }
}
