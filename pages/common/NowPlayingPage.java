package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class NowPlayingPage extends ViewObject {
    public NowPlayingPage(){
        this.label( "NowPlayingPage" );
    }

    public void _ready(){
        this.favoriteButton().assertVisible();
        this.playListDetailButton().assertVisible();
        this.myUtaButton().assertVisible();
    }

    public Matcher<View> matcher() {
        return UtaPassUtil.withIndex(
                allOf( withId( R.id.media_control_bar_normal ),
                        isCompletelyDisplayed() ), 0 );
    }

    public BasicButton arrowButton(){
        return new BasicButton(
                this.label() + "ArrowButton",
                () -> allOf(
                        withId( R.id.main_drawer_icon ),
                        isDescendantOfA( withId( R.id.main_toolbar ) ) ) ) ;
    }

    public BasicButton playListDetailButton() {
        return new BasicButton(
                this.label() + " > playListDetailButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.indicator_expand_detail_layout ), 0 ),
                        isDescendantOfA( withId( R.id.indicator_expand_action_layout ) ) ) );
    }

    public BasicButton lyricsButton() {
        return new BasicButton(
                this.label() + " > LyricsButton",
                () -> withId( R.id.nowplaying_lyrics_button_layout ) );
    }

    public BasicButton playButton() {
        return new BasicButton(
                this.label() + " > PlayButton",
                () -> allOf( withId( R.id.media_control_play_pause ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton pauseButton() {
        return new BasicButton(
                this.label() + " > PauseButton",
                () -> allOf( UtaPassUtil.withDrawable( R.drawable.btn_pause ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton nextButton() {
        return new BasicButton(
                this.label() + " > NextButton",
                () -> allOf(
                        withId( R.id.media_control_next ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton favoriteButton(){
        return new BasicButton(
                this.label() + " > FavoriteButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.media_action_bar_like_layout ), 0  ),
                        isDescendantOfA( withId( R.id.nowplaying_media_action_bar ) ) ) );
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
                return new LazyString( this.label(), () -> UtaPassUtil.withIndex( withId(R.id.media_action_bar_repeat_mode_text), 0 ) ) ;
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

    public void assertPlaying() {
        this.pauseButton().ready() ;
    }
}