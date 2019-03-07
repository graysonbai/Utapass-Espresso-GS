package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.ArtistNewReleaseModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.Best50Module;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.DailyMixModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.ListenWithModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.LiveModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.NewSongsHitSongsModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.PopularArtistModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.RadioModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.SpotlightModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.TopChartsModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.WhatsNewModule;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._module.YouMayAlsoLikeModule;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static org.hamcrest.Matchers.*;


public class StreamPage extends BasicPage {
    private final int MAX_MODULE_OBJECT                = 15 ;
    private final int POSITION_SPOTLIGHT               = 0 ;
    private final int POSITION_RADIO                   = 1 ;
    private final int POSITION_LISTEN_WITH             = 2 ;
    private final int POSITION_LIVE                    = 3 ;
    private final int POSITION_MNET_ASIAN_MUSIC_AWARDS = 4 ;
    private final int POSITION_ARTIST_NEW_RELEASE      = 5 ;
    private final int POSITION_DAILY_MIX               = 6 ;
    private final int POSITION_TOP_CHARTS              = 7 ;
    private final int POSITION_BEST50                  = 8 ;
    private final int POSITION_POPULAR_ARTIST          = 9 ;
    private final int POSITION_WHATS_NEW               = 10 ;
    private final int POSITION_NEW_SONGS_HITS_SONGS    = 11 ;
    private final int POSITION_YOU_MAY_ALSO_LIKE       = 12 ;
    private final int POSITION_MEMBER_PRIVILEGES       = 13 ;
    private final int POSITION_RUN_AWAY                = 14 ;
    private int[] moduleExistence ;

    private BasicButton sideBarButton ;

    public StreamPage() {
        this.moduleExistence = new int[ this.MAX_MODULE_OBJECT ] ;
        for(int i = 0; i < this.MAX_MODULE_OBJECT; i++ ) {
            this.moduleExistence[i] = 1;
        }

        this.retryWhenNotReady( false ) ;
        this.label( "StreamPage" ) ;
    }

    public void _ready() {
        this.streamTab().ready() ;
        this.libraryTab().ready() ;
        this.searchTab().ready() ;

        // According to spec, spotlight line-up must be at position 0
        // thus, it is a good checkpoint to see if stream page is ready
        this.spotlightModule().ready() ;

        // then, calculate position for all line-up objects
        this.refreshPositionOfModuleObjects() ;
    }

    private void refreshPositionOfModuleObjects() {

        // Close notice (not to handle it right now)
        this.closeAllNotice() ;

        // Close enjoy Uta Pass (not to handle it right now)
        this.closeEnjoyUtaPass() ;

        // Calculating position by module objects' existence.
        this.moduleExistence[ this.POSITION_RADIO       ] = this.hasRadioModule()      ? 1 : 0 ;
        this.moduleExistence[ this.POSITION_LISTEN_WITH ] = this.hasListenWithModule() ? 1 : 0 ;
        this.moduleExistence[ this.POSITION_LIVE        ] = this.hasLiveModule()       ? 1 : 0 ;

        this.moduleExistence[ this.POSITION_MNET_ASIAN_MUSIC_AWARDS ] =
                this.hasMamaModule() ? 1 : 0 ;

        this.swipeToSpotlightModule() ;
    }

    public void closeAllNotice() {
        this.swipeToModuleObject( 1 ) ;
        while( this.isVisible( UtaPassUtil.withIndex( withId( R.id.notice_close_btn ), 0 ) ) ) {
            onView( UtaPassUtil.withIndex( withId( R.id.notice_close_btn ), 0 ) )
                    .perform( click() ) ;
        }
    }

    public void closeEnjoyUtaPass() {
        this.swipeToModuleObject(2 ) ;
        while( this.isVisible( withId( R.id.rating_item_negative_button ) ) ) {
            onView( withId( R.id.rating_item_negative_button ) ).perform( click() ) ;
        }
    }

    public boolean hasRadioModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_RADIO ) ) ;
        return this.isVisible(
                allOf( withId( R.id.item_list_title ),
                       anyOf( withText( RadioModule.titleInEnglish ),
                              withText( RadioModule.titleInJapanese) ) ) ) ;
    }

    public boolean hasListenWithModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_LISTEN_WITH ) ) ;
        return this.isVisible(
                allOf( withId( R.id.item_list_title ),
                        anyOf( withText( ListenWithModule.titleInJapanese ),
                               withText( ListenWithModule.titleInEnglish ) ) ) ) ;
    }

    public boolean hasLiveModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_LIVE ) ) ;
        return this.isVisible(
                allOf( withId( R.id.item_list_title ),
                       anyOf( withText( LiveModule.titleInEnglish ),
                              withText( LiveModule.titleInJapanese) ) ) ) ;
    }

    public boolean hasMamaModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_MNET_ASIAN_MUSIC_AWARDS ) ) ;
        return this.isVisible( withContentDescription( "12" ) );
    }

    public void swipeToModuleObject( int position ) {
        onView( withId( R.id.stream_recycler_view ) ).perform( scrollToPosition( position ) ) ;
    }

    private int getPosition( int moduleId ) {
        int positionInStreamPage = -1 ;
        for( int i = 0; i <= moduleId; i++ ) {
            positionInStreamPage += this.moduleExistence[ i ] ;
        }

        if( positionInStreamPage == -1 ) {
            String msg = String.format(
                    "Fail to get positionInStreamPage: '%s'",
                    positionInStreamPage ) ;
            throw new RuntimeException( msg ) ;
        }

        return positionInStreamPage ;
    }

    public void swipeToSpotlightModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_SPOTLIGHT ) ) ;
    }

    public void swipeToRadioModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_LISTEN_WITH ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_RADIO ) ) ;
    }

    public void swipeToListenWithModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_LIVE ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_LISTEN_WITH ) ) ;
    }

    public void swipeToLiveModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_ARTIST_NEW_RELEASE ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_LIVE ) ) ;
    }

    public void swipeToArtistNewReleaseModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_DAILY_MIX ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_ARTIST_NEW_RELEASE ) ) ;
    }

    public void swipeToDailyMixModule(){
        this.swipeToModuleObject( this.getPosition( this.POSITION_TOP_CHARTS ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_DAILY_MIX ) ) ;
    }

    public void swipeToTopChartsModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_BEST50 ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_TOP_CHARTS ) ) ;
    }

    public void swipeToBest50Module() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_POPULAR_ARTIST ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_BEST50 ) ) ;
    }

    public void swipeToPopularArtistModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_WHATS_NEW ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_POPULAR_ARTIST ) ) ;
    }

    public void swipeToWhatsNewModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_NEW_SONGS_HITS_SONGS ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_WHATS_NEW ) ) ;
    }

    public void swipeToNewSongsHitSongsModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_YOU_MAY_ALSO_LIKE ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_NEW_SONGS_HITS_SONGS ) ) ;
    }

    public void swipeToYouMayAlsoLikeModule() {
        this.swipeToModuleObject( this.getPosition( this.POSITION_MEMBER_PRIVILEGES ) ) ;
        this.swipeToModuleObject( this.getPosition( this.POSITION_YOU_MAY_ALSO_LIKE ) ) ;
     }

    public BasicButton sideBarButton() {
        if( this.sideBarButton == null ) {
            this.sideBarButton = new BasicButton( this.label() + " > SideBarButton" , () -> withId( R.id.main_drawer_icon ) ) ;
        }
        return sideBarButton ;
    }

    public SpotlightModule spotlightModule() {
        this.swipeToSpotlightModule() ;
        return new SpotlightModule( this.label() ) ;
    }

    public RadioModule radioModule() {
        this.swipeToRadioModule() ;
        return new RadioModule( this.label() ) ;
    }

    public ListenWithModule listenWithModule() {
        this.swipeToListenWithModule() ;
        return new ListenWithModule( this.label() ) ;
    }

    public LiveModule liveModule() {
        this.swipeToLiveModule() ;
        return new LiveModule( this.label() ) ;
    }

    public ArtistNewReleaseModule artistNewReleaseModule() {
        this.swipeToArtistNewReleaseModule() ;
        return new ArtistNewReleaseModule( this.label() ) ;
    }

    public DailyMixModule dailyMixModule() {
        this.swipeToDailyMixModule() ;
        return new DailyMixModule( this.label() ) ;
    }

    public TopChartsModule topChartsModule() {
        this.swipeToTopChartsModule() ;
        return new TopChartsModule( this.label() ) ;
    }

    public Best50Module best50Module() {
        this.swipeToBest50Module() ;
        return new Best50Module( this.label() ) ;
    }

    public PopularArtistModule popularArtistModule() {
        this.swipeToPopularArtistModule() ;
        return new PopularArtistModule( this.label() ) ;
    }

    public WhatsNewModule whatsNewModule() {
        this.swipeToWhatsNewModule() ;
        return new WhatsNewModule( this.label() ) ;
    }

    public NewSongsHitSongsModule newSongsHitSongsModule() {
        this.swipeToNewSongsHitSongsModule() ;
        return new NewSongsHitSongsModule( this.label() ) ;
    }

    public YouMayAlsoLikeModule youMayAlsoLikeModule() {
        this.swipeToYouMayAlsoLikeModule() ;
        return new YouMayAlsoLikeModule( this.label() ) ;
    }
}
