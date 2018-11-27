package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class LiveConcertPage extends ViewObject {

    public LiveConcertPage() {
        this.label( "LiveConcertPage" ) ;
    }

    public void _ready() {
        this.video().assertVisible() ;
        this.loadingIcon().assertInvisible() ;
    }

    public BasicImage icon() {
        return new BasicImage( this.label() + " > icon",
                () -> withId( R.id.live_info_bar_icon ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > title",
                () -> withId( R.id.live_info_bar_title ) ) ;
    }

    public BasicImage video() {
        return new BasicImage( this.label() + " > liveVideo",
                () -> withId( R.id.live_nowplaying_video_layout ) ) ;
    }

    public BasicButton arrowButton() {
        return new BasicButton( this.label() + " > arrowButton",
                () -> withId( R.id.view_live_video_control_arrow ) ) ;
    }

    public BasicImage loadingIcon() {
        return new BasicImage( this.label() + " > loadingIcon",
                () -> withId( R.id.live_nowplaying_progress_bar ) ) ;
    }
}
