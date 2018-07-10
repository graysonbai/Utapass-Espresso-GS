package com.kddi.android.UtaPass.sqatest.pages ;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqatest.common.CardObject;
import com.kddi.android.UtaPass.sqatest.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqatest.common.ViewObject;
import com.kddi.android.UtaPass.sqatest.pages.StreamPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA ;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.*;

public class LiveConcertPage extends ViewObject {

    private LiveVideo liveVideo ;
    private LiveTitleBar liveTitleBar ;

    public LiveConcertPage() {
        this.liveVideo = new LiveVideo() ;
        this.liveTitleBar = new LiveTitleBar() ;
//        this.liveChatroom = new LiveChatroom() ;
//        this.liveChatBar = new LiveChatBar() ;
    }

    public void _ready() {
        this.retryWhenNotReady = false ;

        this.liveVideo.ready() ;
        this.liveTitleBar.ready() ;
//        this.liveChatroom.ready() ;
//        this.liveChatBar.ready() ;
    }

    public LiveVideo getLiveVideo() {
        return this.liveVideo ;
    }

    public LiveTitleBar getLiveTitleBar() {
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
        }

        public void _ready() {
            this.retryWhenNotReady = false ;

            this.icon.ready() ;
            this.title.ready() ;
        }

        public LiveTitleBarIcon getIcon() {
            return this.icon ;
        }

        public String getTitle() {
            return this.title.getText() ;
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

            public String getText() {
                return this.getText( this.item ) ;
            }
        }
    }
}




