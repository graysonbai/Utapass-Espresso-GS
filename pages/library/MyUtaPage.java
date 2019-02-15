package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import android.support.test.espresso.action.ViewActions;
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
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IMoreActionsButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.StringInvisibleException;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.MyUtaHistoryPage;

import org.hamcrest.Matcher;

import java.util.regex.Pattern;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class MyUtaPage extends BasicPage {
    private InternalLineUp lineUp ;

    public MyUtaPage() {
        this.label( "MyUtaPage" ) ;
    }

    public LazyString remainingQuotas() {
        return new LazyString( this.label() + " > RemainingQuotas",
                () -> withId( R.id.myuta_available_quota_count ) ) ;
    }

    public BasicButton myUtaHistoryButton() {
        return new BasicButton( this.label() + " > MyUtaHistoryButton",
                () -> withId( R.id.myuta_to_management  ) ) ;
    }

    public BasicButton playButton() {
        return new BasicButton( this.label() + " > PlayButton",
                () -> withId( R.id.myuta_play_all  ) ) ;
    }

    public LazyString downloadedSongs() {
        return new LazyString( this.label() + " > DownloadedSongs",
                () -> withId( R.id.myuta_downloaded_songs_count ) ) {

            @Override
            public String string() {
                this.ready() ;
                java.util.regex.Matcher regexMatcher =
                        Pattern.compile( "([0-9]+)" ).matcher( super.string() ) ;

                if( regexMatcher.find() ) {
                    return regexMatcher.group( 1 ) ;
                }

                throw new StringInvisibleException( this.label() ) ;
            }
        } ;
    }

    public MyUtaHistoryPage myUtaHistoryPage(){
        return new MyUtaHistoryPage( this.label() );
    }

    public BasicButton tooltip(){
        UtaPassUtil.sleep( 5 );
       return new BasicButton( this.label() + " > Tooltip",
               () -> allOf(
                       withId( android.R.id.text1 ),
                       withText( "You can find My Uta History here, including those that are not downloaded.")));
    }

    public InternalLineUp lineUp() {
        if( this.myUtaHistoryButton().isVisible() ) {
            this.swipeUp() ;
            this.swipeUp() ;
        }

        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public void swipeUp() {
        onView( withId( R.id.myuta_coordinator_layout ) ).perform( ViewActions.swipeUp() ) ;
    }

    public class InternalLineUp extends LineUpObject {
        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.local_track_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.item_library_lazy_track_layout ),
                          isCompletelyDisplayed(),
                          isDescendantOfA( this.getMatcherToFindRecycleView() ) ) ;
        }

        protected int swipeToCardViewAndGetIndexOfWindow( int index ) {

            // TODO: Swipe up/down doesn't work
            //   In this case, our target, RecyclerView, is nested in ScrollView
            //   and probably causes this issue
            this.swipeToPosition( 1 ) ;

            if( index <= this.maxIndexFirstWindow() ) {
                return index ;
            }

            this.swipeToPosition( index + 2 ) ;
            return this.maxIndexOtherWindow() ;
        }

        public InternalCard card(int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_icon ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.songName(  label + " > SongName",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.artistName( label + " > ArtistName",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_subtitle ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.moreActionsButton( label + " > MoreActionsButton",
                    () -> allOf(
                            withId( R.id.item_library_lazy_track_overflow ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IMoreActionsButton, ISongName, IArtistName {

        String labelCover ;
        String labelSongName ;
        String labelArtistName ;
        String labelMoreActionsButton ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherSongName ;
        private LazyMatcher matcherArtistName ;
        private LazyMatcher matcherMoreActionsButton ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void moreActionsButton( String label, LazyMatcher matcher ) {
            this.labelMoreActionsButton = label ;
            this.matcherMoreActionsButton = matcher ;
        }

        public BasicButton moreActionsButton() {
            return new BasicButton( this.labelMoreActionsButton, this.matcherMoreActionsButton ) ;
        }

        public void songName( String label, LazyMatcher matcher ) {
            this.labelSongName = label;
            this.matcherSongName = matcher;
        }

        public LazyString songName() {
            return new LazyString( this.labelSongName, this.matcherSongName ) ;
        }

        public void artistName( String label, LazyMatcher matcher ) {
            this.labelArtistName = label;
            this.matcherArtistName = matcher;
        }

        public LazyString artistName() {
            return new LazyString( this.labelArtistName, this.matcherArtistName ) ;
        }

        public void tap() {
            this.cover().tap() ;
        }
    }
}
