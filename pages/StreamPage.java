package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup.* ;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.Best50;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static org.hamcrest.Matchers.*;


public class StreamPage extends BasicPage {
    private final int MAX_LINEUP_OBJECT             = 14 ;
    private final int POSITION_SPOTLIGHT            = 0 ;
    private final int POSITION_RADIO                = 1 ;
    private final int POSITION_LISTEN_WITH          = 2 ;
    private final int POSITION_LIVE                 = 3 ;
    private final int POSITION_ARTIST_NEW_RELEASE   = 4 ;
    private final int POSITION_DAILY_MIX            = 5 ;
    private final int POSITION_TOP_CHARTS           = 6 ;
    private final int POSITION_BEST50               = 7 ;
    private final int POSITION_POPULAR_ARTIST       = 8 ;
    private final int POSITION_WHATS_NEW            = 9 ;
    private final int POSITION_NEW_SONGS_HITS_SONGS = 10 ;
    private final int POSITION_YOU_MAY_ALSO_LIKE    = 11 ;
    private final int POSITION_MEMBER_PRIVILEGES    = 12 ;
    private final int POSITION_RUN_AWAY             = 13 ;
    private int[] lineupExistence ;

    private BasicButton sideBarButton ;

    public StreamPage() {
        this.lineupExistence = new int[ this.MAX_LINEUP_OBJECT ] ;
        for(int i = 0; i < this.MAX_LINEUP_OBJECT; i++ ) {
            this.lineupExistence[i] = 1;
        }

        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        this.streamTab().ready() ;
        this.libraryTab().ready() ;
        this.searchTab().ready() ;

        // According to spec, spotlight line-up must be at position 0
        // thus, it is a good checkpoint to see if stream page is ready
        this.spotlightLineUp().ready() ;

        // then, calculate position for all line-up objects
        this.refreshPositionOfLineUpObjects() ;
    }

    private void refreshPositionOfLineUpObjects() {

        // Close notice (not to handle it right now)
        this.closeAllNotice() ;

        // Close enjoy Uta Pass (not to handle it right now)
        this.closeEnjoyUtaPass() ;

        // Calculating position by lineup objects' existence.
        this.lineupExistence[ this.POSITION_RADIO       ] = this.hasRadioLineUp()      ? 1 : 0 ;
        this.lineupExistence[ this.POSITION_LISTEN_WITH ] = this.hasListenWithLineUp() ? 1 : 0 ;
        this.lineupExistence[ this.POSITION_LIVE        ] = this.hasLiveLineUp()       ? 1 : 0 ;

        this.swipeToSpotlightLineUp() ;
    }

    public void closeAllNotice() {
        this.swipeToLineUpObject( 1 ) ;
        while( this.isVisible( UtaPassUtil.withIndex( withId( R.id.notice_close_btn ), 0 ) ) ) {
            onView( UtaPassUtil.withIndex( withId( R.id.notice_close_btn ), 0 ) )
                    .perform( click() ) ;
        }
    }

    public void closeEnjoyUtaPass() {
        this.swipeToLineUpObject(2) ;
        while( this.isVisible( withId( R.id.rating_item_negative_button ) ) ) {
            onView( withId( R.id.rating_item_negative_button ) ).perform( click() ) ;
        }
    }

    public boolean hasRadioLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_RADIO ) ) ;
        return this.isVisibleByGetText(
                allOf( withId( R.id.item_list_title ),
                       anyOf( withText( RadioLineUp.titleInEnglish ),
                              withText( RadioLineUp.titleInJapanese) ) ) ) ;
    }

    public boolean hasListenWithLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_LISTEN_WITH ) ) ;
        return this.isVisibleByGetText(
                allOf( withId( R.id.item_list_title ),
                        anyOf( withText( ListenWithLineUp.titleInJapanese ),
                               withText( ListenWithLineUp.titleInEnglish ) ) ) ) ;
    }

    public boolean hasLiveLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_LIVE ) ) ;
        return this.isVisibleByGetText(
                allOf( withId( R.id.item_list_title ),
                       anyOf( withText( LiveLineUp.titleInEnglish ),
                              withText( LiveLineUp.titleInJapanese) ) ) ) ;
    }

    public void swipeToLineUpObject( int position ) {
        onView( withId( R.id.stream_recycler_view ) ).perform( scrollToPosition( position ) ) ;
    }

    private int getPosition( int lineupId ) {
        int positionInStreamPage = -1 ;
        for( int i = 0; i <= lineupId; i++ ) {
            positionInStreamPage += this.lineupExistence[ i ] ;
        }

        if( positionInStreamPage == -1 ) {
            String msg = String.format(
                    "Fail to get positionInStreamPage: '%s'",
                    positionInStreamPage ) ;
            throw new RuntimeException( msg ) ;
        }

        return positionInStreamPage ;
    }

    public void swipeToSpotlightLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_SPOTLIGHT ) ) ;
    }

    public void swipeToRadioLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_LIVE ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_RADIO ) ) ;
    }

    public void swipeToLiveLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_ARTIST_NEW_RELEASE ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_LIVE ) ) ;
    }

    public void swipeToArtistNewReleaseLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_DAILY_MIX ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_ARTIST_NEW_RELEASE ) ) ;
    }

    public void swipeToDailyMixLineUp(){
        this.swipeToLineUpObject( this.getPosition( this.POSITION_TOP_CHARTS ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_DAILY_MIX ) ) ;
    }

    public void swipeToTopChartsLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_BEST50 ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_TOP_CHARTS ) ) ;
    }

    public void swipeToBest50LineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_POPULAR_ARTIST ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_BEST50 ) ) ;
    }

    public void swipeToPopularArtistLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_WHATS_NEW ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_POPULAR_ARTIST ) ) ;
    }

    public void swipeToWhatsNewLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_NEW_SONGS_HITS_SONGS ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_WHATS_NEW ) ) ;
    }

    public void swipeToNewSongsHitSongsLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_YOU_MAY_ALSO_LIKE ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_NEW_SONGS_HITS_SONGS ) ) ;
    }

    public void swipeToYouMayAlsoLikeLineUp() {
        this.swipeToLineUpObject( this.getPosition( this.POSITION_MEMBER_PRIVILEGES ) ) ;
        this.swipeToLineUpObject( this.getPosition( this.POSITION_YOU_MAY_ALSO_LIKE ) ) ;
     }

    public BasicButton sideBarButton() {
        if( this.sideBarButton == null ) {
            this.sideBarButton = new BasicButton( () -> withId( R.id.main_drawer_icon ) ) ;
        }
        return sideBarButton ;
    }

    public SpotlightLineUp spotlightLineUp() {
        this.swipeToSpotlightLineUp() ;
        return new SpotlightLineUp() ;
    }

    public RadioLineUp radioLineUp() {
        this.swipeToRadioLineUp() ;
        return new RadioLineUp() ;
    }

    public LiveLineUp liveLineUp() {
        this.swipeToLiveLineUp() ;
        return new LiveLineUp() ;
    }

    public ArtistNewReleaseLineUp artistNewReleaseLineUp() {
        this.swipeToArtistNewReleaseLineUp() ;
        return new ArtistNewReleaseLineUp() ;
    }

    public DailyMixLineUp dailyMixLineUp() {
        this.swipeToDailyMixLineUp() ;
        return new DailyMixLineUp() ;
    }

    public TopChartsLineUp topChartsLineUp() {
        this.swipeToTopChartsLineUp() ;
        return new TopChartsLineUp() ;
    }

    public Best50 best50() {
        this.swipeToBest50LineUp() ;
        return new Best50() ;
    }

    public Best50LineUp best50LineUp() {
        this.swipeToBest50LineUp() ;
        return new Best50LineUp() ;
    }

    public PopularArtistLineUp popularArtistLineUp() {
        this.swipeToPopularArtistLineUp() ;
        return new PopularArtistLineUp() ;
    }

    public WhatsNewLineUp whatsNewLineUp() {
        this.swipeToWhatsNewLineUp() ;
        return new WhatsNewLineUp() ;
    }

    public NewSongsHitSongsLineUp newSongsHitSongsLineUp() {
        this.swipeToNewSongsHitSongsLineUp() ;
        return new NewSongsHitSongsLineUp() ;
    }

    public YouMayAlsoLikeLineUp youMayAlsoLikeLineUp() {
        this.swipeToYouMayAlsoLikeLineUp() ;
        return new YouMayAlsoLikeLineUp() ;
    }


}
