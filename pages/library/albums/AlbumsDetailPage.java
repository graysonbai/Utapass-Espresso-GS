package com.kddi.android.UtaPass.sqa_espresso.pages.library.albums ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IArtistName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMoreButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;


public class AlbumsDetailPage extends BasicPage {
    private SongsLineUp songsLineUp;
    private BasicButton shuffleAllButton ;

    public AlbumsDetailPage(){
        this.label( "AlbumInfoPage" );
    }

    public String totalSongs() {
        String raw = this.getText( withId( R.id.detail_album_description ) ) ;
        return raw.split( " · " )[ 0 ] ;
    }

    public String totalTime() {
        String raw = this.getText( withId( R.id.detail_album_description ) ) ;
        return raw.split( " · " )[ 1 ] ;
    }

    public BasicButton shuffleAllButton() {
        if( this.shuffleAllButton == null ) {
            this.shuffleAllButton = new BasicButton( () ->
                    allOf( withId( R.id.view_shuffle_play_layout ),
                           withParent( withId( R.id.detail_album_recycler_view ) ) ) ) ;
        }
        return this.shuffleAllButton ;
    }

    public SongsLineUp songsLineUp(){
        if( this.songsLineUp == null ){
            this.songsLineUp = new SongsLineUp( this.label() );
        }
        return this.songsLineUp;
    }

    public class SongsLineUp extends LineUpObject{

        public SongsLineUp(String label) {
            this.label( label + " > SongsLineUp" );
        }

            protected Matcher<View> getMatcherToFindRecycleView () {
            return withId( R.id.detail_album_recycler_view );
        }

            protected Matcher<View> getMatcherToCountMaxIndexOfWindow () {
            return withId( R.id.item_detail_local_audio_layout );
        }

            public InternalSong song ( int index){
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow(index);
            InternalSong song = new InternalSong();

            String label = String.format( "%s > Card(%s)", this.label(), indexInWindow );

            song.songName(label + " > songName ",
                    () -> UtaPassUtil.withIndex(
                            Matchers.allOf(
                                    withId(R.id.item_detail_local_audio_title),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            song.artistName(label + " > artistName ",
                    () -> UtaPassUtil.withIndex(
                            Matchers.allOf(
                                    withId(R.id.item_detail_local_audio_artist),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            song.cover(label + " > cover ",
                    () -> UtaPassUtil.withIndex(
                            Matchers.allOf(
                                    withId(R.id.layout_detail_local_audio_image),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            song.moreButton(label + " > moreButton ",
                    () -> UtaPassUtil.withIndex(
                            Matchers.allOf(
                                    withId(R.id.item_detail_local_audio_overflow),
                                    isDescendantOfA(this.getMatcherToFindRecycleView())), indexInWindow));

            return song;
        }

        public class InternalSong implements ICover, IArtistName, ISongName, IMoreButton {

            String labelSongName;
            String labelArtistName;
            String labelCover;
            String labelMoreButton;

            LazyMatcher matcherSongName;
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
            public void songName(String label, LazyMatcher matcher) {
                this.labelSongName = label;
                this.matcherSongName = matcher;
            }

            @Override
            public LazyString songName() {
                return new LazyString(this.labelSongName, this.matcherSongName);
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
