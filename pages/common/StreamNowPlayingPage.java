package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class StreamNowPlayingPage extends NowPlayingPage {
    public StreamNowPlayingPage(){
        this.label( "StreamNowPlayingPage" );
    }

    public void _ready(){
        this.playListDetailButton().assertVisible();
        this.songTitle().assertVisible();
        this.myUtaButton().assertVisible();
        this.castButton().assertVisible();
    }

    public Matcher<View> matcher() {
        return UtaPassUtil.withIndex(
                allOf( withId( R.id.media_control_bar_normal ),
                        isCompletelyDisplayed() ), 0 );
    }

    public BasicButton playListDetailButton() {
        return new BasicButton(
                this.label() + " > PlayListDetailButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.indicator_expand_detail_layout ), 0 ),
                        isDescendantOfA( withId( R.id.indicator_expand_action_layout ) ) ) );
    }

    public BasicButton myUtaButton(){
        return new BasicButton(
                this.label() + " > MyUtaButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.media_action_bar_my_uta_layout ), 0  ),
                        isDescendantOfA( withId( R.id.nowplaying_media_action_bar ) ) ) );
    }

    public BasicButton playModeButton(){
        return new BasicButton(
                this.label() + " > PlayModeButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.media_action_bar_repeat_mode_layout ), 0  ),
                        isDescendantOfA( withId( R.id.nowplaying_media_action_bar ) ) ) ){
            public LazyString text() {
                if( this.isVisible( UtaPassUtil.withIndex( withId(R.id.media_action_bar_repeat_mode_text ) , 1 ) ) ){
                    return new LazyString(
                            this.label(),
                            () -> UtaPassUtil.withIndex( withId(R.id.media_action_bar_repeat_mode_text ) , 1 ) ) ;
                } else {
                    return new LazyString(
                            this.label(),
                            () -> UtaPassUtil.withIndex( withId(R.id.media_action_bar_repeat_mode_text ) , 0 ) ) ;
                }
            }
        };
    }

    public BasicButton castButton(){
        return new BasicButton(
                this.label() + " > CastButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.media_action_bar_cast_layout ), 0  ),
                        isDescendantOfA( withId( R.id.nowplaying_media_action_bar ) ) ) );
    }
}