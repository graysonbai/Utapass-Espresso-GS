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


public class LocalNowPlayingPage extends NowPlayingPage {
    public LocalNowPlayingPage(){
        this.label( "LocalNowPlayingPage" );
    }

    public void _ready(){
        this.songTitle().assertVisible();
        this.prevButton().assertVisible();
        this.favoriteButton().assertVisible();
        this.addMyplaylistButton().assertVisible();
    }

    public Matcher<View> matcher() {
        return UtaPassUtil.withIndex(
                allOf( withId( R.id.media_control_bar_normal ),
                        isCompletelyDisplayed() ), 0 );
    }

    public BasicButton prevButton() {
        return new BasicButton(
                this.label() + " > PrevButton",
                () -> allOf(
                        UtaPassUtil.withDrawable( R.drawable.btn_prev ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public BasicButton addMyplaylistButton(){
        return new BasicButton(
                this.label() + " > PlayModeButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.media_action_bar_add_list_layout ), 0  ),
                        isDescendantOfA( withId( R.id.nowplaying_media_action_bar ) ) ) );
    }
}
