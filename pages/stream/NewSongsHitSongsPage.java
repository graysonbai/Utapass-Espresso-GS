package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import android.support.test.espresso.action.ViewActions;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ILikeCount;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.core.AllOf.allOf;


public class NewSongsHitSongsPage extends BasicPage {

    private InternalLineUp lineUp ;

    public void _ready() {
      this.lineUp().assertVisible();
      this.lineUp().card( 0 ).cover().assertVisible();
    }

    public BasicImage cover() {
        return new BasicImage( "Stream > NewSongsHitSongs > See All > Cover",
                () -> withId( R.id.category_folder_cover ) ) ;
    }

    public BasicButton sortButton() {
        return new BasicButton( "Stream > NewSongsHitSongs > See All > Sort Button",
                () -> withId( R.id.sort ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> withId( R.id.label_sort ) ) ;
            }
        } ;
    }

    public LazyString title() {
        return new LazyString( "Stream > NewSongsHitSongs > See All > Title",
                () -> withId( R.id.category_toolbar_title ) ) ;
    }

    public BasicButton filterButton() {
        return new BasicButton("Stream > NewSongsHitSongs > See All > Filter",
                () -> withId( R.id.category_toolbar_filter ) ) ;
    }

    public InternalLineUp lineUp() {
        if( this.cover().isVisible() ) {
            onView( withId( R.id.category_layout ) ).perform( ViewActions.swipeUp() ) ;
        }

        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp() ;
            this.lineUp.setMaxIndexOfLineUpObject( 249 ) ;
        }

        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {

        private int maxWidthOfWindow = 1 ;

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.category_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.item_playlist_content_layout ),
                    isCompletelyDisplayed() ) ;
        }

        private int topPosition( String id, int index ) {
            try {
                return UtaPassUtil.findObjectByResourceIdMatches( id, index ).getBounds().top ;

            } catch( UiObjectNotFoundException e ) {
                return -1 ;
            }
        }

        protected int calculateMaxIndexOfRow() {
            int count = -1 ;
            int _top = -1 ;
            int top = -1 ;
            String id = "item_playlist_content_layout" ;

            for( int i = 0 ; i <= this.maxIndexFirstWindow(); i++ ) {
                top = this.topPosition( id, i ) ;

                if( top == -1 ) {
                    return count ;
                }

                count++ ;
                if( _top == -1 ) {
                    _top = top ;
                }

                else if( _top != top ) {
                    return count ;
                }
            }

            return count ;
        }

        protected int calculateMaxIndexOfWindow() {
            int count = -1 ;
            for( int i = 0 ; i <= this.getMaxIndexOfLineUpObject(); i++ ) {
                if( ! this.isDisplayedCompletely(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(), i ) ) ) {
                    return count;
                }

                count++ ;
            }

            return count ;
        }

        protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
            this.swipeToLeftmost() ;
            this.checkIndexValid( index ) ;
            this.swipeToPosition( index ) ;

            if( index <= this.maxIndexFirstWindow() ) {
                return index ;
            }

//                int offset = this.getMaxIndexOfWindow()
//                        / Best50LineUp.MAX_CARD_IN_COLUMN
//                        * Best50LineUp.MAX_CARD_IN_COLUMN ;
//
//                return offset + ( index % Best50LineUp.MAX_CARD_IN_COLUMN ) ;
            return 0 ;
        }

        public InternalCard card( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            card.cover( "Stream > NewSongsHisSongs > See All > Card > Cover",
                    () -> Matchers.allOf(
                            withId( R.id.item_playlist_card_image ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton("Stream > NewSongsHisSongs > See All > Card > PlayButton",
                    () -> Matchers.allOf(
                            withId( R.id.view_playlist_play_icon ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.title( "Stream > NewSongsHisSongs > See All > Card > Title",
                    () -> Matchers.allOf(
                            withId( R.id.item_playlist_card_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.likeCount( "Stream > NewSongsHisSongs > See All > Card > LikeCount",
                    () -> Matchers.allOf(
                            withId( R.id.item_playlist_card_like_count ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IPlayButton, ITitle, ILikeCount {

        String labelCover ;
        String labelTitle ;
        String labelPlayButton ;
        String labelLikeCount ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherTitle ;
        private LazyMatcher matcherPlayButton ;
        private LazyMatcher matcherLikeCount ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void playButton( String label, LazyMatcher matcher ) {
            this.labelPlayButton = label ;
            this.matcherPlayButton = matcher ;
        }

        public BasicButton playButton() {
            return new BasicButton( this.labelPlayButton, this.matcherPlayButton ) ;
        }

        public void title( String label, LazyMatcher matcher ) {
            this.labelTitle = label ;
            this.matcherTitle = matcher ;
        }

        public LazyString title() {
            return new LazyString( this.labelTitle, this.matcherTitle ) ;
        }

        public void likeCount( String label, LazyMatcher matcher ) {
            this.labelLikeCount = label ;
            this.matcherLikeCount = matcher ;
        }

        public LazyString likeCount() {
            return new LazyString( this.labelLikeCount, this.matcherLikeCount ) ;
        }
    }
}




