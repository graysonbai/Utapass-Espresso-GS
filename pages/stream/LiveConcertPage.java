package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.StringObject;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.action.ViewActions.*;


public class LiveConcertPage extends ViewObject {

    private LiveVideo liveVideo ;
    private LiveTitleBar liveTitleBar ;

    public LiveConcertPage() {
        this.liveVideo = new LiveVideo() ;
        this.liveTitleBar = new LiveTitleBar() ;
//        this.liveChatroom = new LiveChatroom() ;
//        this.liveChatBar = new LiveChatBar() ;

        this.retryWhenNotReady( false ) ;
    }

    public void _ready() {
        this.liveVideo.ready() ;
//        this.liveTitleBar.ready() ;
//        this.liveChatroom.ready() ;
//        this.liveChatBar.ready() ;
    }

    public LiveVideo liveVideo() {
        return this.liveVideo ;
    }

    public LiveTitleBar liveTitleBar() {
        return this.liveTitleBar ;
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

    public class LiveTitleBar extends ViewObject {

        private LiveTitleBarIcon icon ;
        private LiveTitleBarTitle title ;

        public LiveTitleBar() {
            this.icon = new LiveTitleBarIcon() ;
            this.title = new LiveTitleBarTitle() ;

            this.retryWhenNotReady( false ) ;
        }

        public void _ready() {
            this.icon.ready() ;
            this.title.ready() ;
        }

        public LiveTitleBarIcon icon() {
            return this.icon ;
        }

        public StringObject title() {
            return this.title.text() ;
        }


        private class LiveTitleBarIcon extends ViewObject {

            public LiveTitleBarIcon() {
                this.item = onView( withId( R.id.live_info_bar_icon ) ) ;
            }

            public void _ready() {
                if( !this.isVisible( this.item ) ) {
                    throw new RuntimeException( "LiveTitleBarIcon is not visible" ) ;
                }
            }

            public void tap() {
                this.item.perform( click() ) ;
            }
        }

        private class LiveTitleBarTitle extends ViewObject {

            public LiveTitleBarTitle() {
                this.item = onView( withId( R.id.live_info_bar_title ) ) ;
            }

            public void _ready() {
                if( !this.isVisible( this.item ) ) {
                    throw new RuntimeException( "LiveTitleBarTitle is not visible" ) ;
                }
            }

            public StringObject text() {
                StringObject strObj = new StringObject( this.getText( this.item ) ) ;
                strObj.label( "Live > TitleBar" ) ;
                return strObj ;
            }
        }
    }
}
