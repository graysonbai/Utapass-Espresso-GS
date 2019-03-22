package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta;

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
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IRedownloadButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.MyUtaPlayHistoryPopupMessage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class MyUtaHistoryPage extends MyUtaPlayHistoryPopupMessage {
    private InternalLineUp lineUp;

    public MyUtaHistoryPage( String label ){
        this.label( label + "MyUtaHistoryPage" );
    }

    public void _ready(){
        UtaPassUtil.sleep( 5, "for stability");
    }

    public LazyString remainingQuotas() {
        return new LazyString( this.label() + " > RemainingQuotas",
                () -> withId( R.id.myuta_management_available_count ) ) ;
    }

    public BasicButton toolBar(){
        return new BasicButton( this.label() + "filterButton",
                () -> allOf(
                        withId( R.id.myuta_management_toolbar_spinner ),
                        isDescendantOfA( withId( R.id.myuta_management_toolbar ) ) ) );
    }

    public BasicButton allMyUtaButton(){
        return new BasicButton( this.label() + " > All My Uta",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.all_track_filter_layout), 0 ),
                        isDescendantOfA( withId( R.id.myuta_management_toolbar ) ) )){
            public LazyString text(){
                return new LazyString( this.label(),
                        () -> allOf(
                                withId( R.id.all_track_filter_text ),
                                anyOf(
                                        withText( "All My Uta" ),
                                        withText( "全てのMyうた" ) ) ) );
            }
        };
    }

    public BasicButton notDownLoadedButton(){
        return new BasicButton( this.label() + " > Not downloaded",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.all_track_filter_layout), 1 ),
                        isDescendantOfA( withId( R.id.myuta_management_toolbar ) ) ) ){
            public LazyString text(){
                return new LazyString( this.label(),
                        () -> allOf(
                                withId( R.id.all_track_filter_text ),
                                anyOf(
                                        withText( "Not downloaded" ),
                                        withText( "未ダウンロードのMyうた" ) ) ) );
            }
        };
    }

    public BasicButton forQuotaRefundButton(){
        return new BasicButton( this.label() + " > For Quota Refund",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.all_track_filter_layout), 2 ),
                        isDescendantOfA( withId( R.id.myuta_management_toolbar ) ) ) ){
            public LazyString text(){
                return new LazyString( this.label(),
                        () -> allOf(
                                withId( R.id.all_track_filter_text ),
                                anyOf(
                                        withText( "For Quota Refund" ),
                                        withText( "Myうた保存枠の返却" ) ) ) );
            }
        };
    }

    public InternalLineUp lineUp() {
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {
        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.myuta_management_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.item_track_layout ),
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
                            withId( R.id.track_icon_layout ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.songName(  label + " > SongName",
                    () -> allOf(
                            withId( R.id.item_track_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.artistName( label + " > ArtistName",
                    () -> allOf(
                            withId( R.id.item_track_subtitle ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.redownloadButton( label + " > redownloadButton",
                    () -> allOf(
                            withId( R.id.view_download_text ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IRedownloadButton, ISongName, IArtistName {

        String labelCover ;
        String labelSongName ;
        String labelArtistName ;
        String labelRedownloadButton ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherSongName ;
        private LazyMatcher matcherArtistName ;
        private LazyMatcher matcherRedownloadButton ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
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

        public void redownloadButton(String label, LazyMatcher matcher) {
            this.labelRedownloadButton = label;
            this.matcherRedownloadButton = matcher;
        }

        public BasicButton redownloadButton() {
            return new BasicButton( this.labelRedownloadButton, this.matcherRedownloadButton );
        }
    }
}
