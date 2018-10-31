package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.action.ViewActions.*;


public class LiveConcertPage extends ViewObject {

    private LiveVideo liveVideo ;

    public LiveConcertPage() {
        this.liveVideo = new LiveVideo() ;

        this.label( "LiveConcertPage" ) ;
        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        this.liveVideo.ready() ;
    }

    public BasicImage icon() {
        return new BasicImage( this.label() + " > icon",
                () -> withId( R.id.live_info_bar_icon ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > title",
                () -> withId( R.id.live_info_bar_title ) ) ;
    }

    public boolean isPlaying() {
        boolean isLoading = this.isVisible(
                onView( withId( R.id.live_nowplaying_progress_bar ) ) ) ;

        boolean isMessagePopOut = this.isVisible(
                onView( withId( R.id.parentPanel ) ) ) ;

        if( isLoading || isMessagePopOut ) {
            return false ;
        }

        return true ;
    }


    public LiveVideo liveVideo() {
        return this.liveVideo ;
    }

    public class LiveVideo extends ViewObject {

        public LiveVideo() {
            this.item = onView( withId( R.id.live_nowplaying_video_layout ) ) ;
        }

        public void _ready() {
            if( !this.isPlaying() ) {
                throw new RuntimeException( "LiveVideo is not playing" ) ;
            }
        }

        public LiveVideo tap() {
            this.item.perform( click() ) ;
            return this ;
        }

        public void close() {
            onView( withId( R.id.view_live_video_control_arrow ) ).perform( click() ) ;
        }

        public boolean isPlaying() {
            boolean isLoading = this.isVisible(
                    onView( withId( R.id.live_nowplaying_progress_bar ) ) ) ;

            boolean isMessagePopOut = this.isVisible(
                    onView( withId( R.id.parentPanel ) ) ) ;

            if( isLoading || isMessagePopOut ) {
                return false ;
            }

            return true ;
        }
    }
}
