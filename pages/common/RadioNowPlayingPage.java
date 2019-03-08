package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

public class RadioNowPlayingPage extends ViewObject {

    public RadioNowPlayingPage(){
        this.label( "RadioNowPlayingPage" );
    }

    public LazyString radioNowPlayingTitle(){
        return new LazyString(this.label() + " > Radio Now Playing Title",
                () -> allOf(
                        withId(R.id.nowplaying_track_title),
                        isDescendantOfA( withId(R.id.nowplaying_track_info_layout) ),
                        isCompletelyDisplayed() ) );
    }

    public LazyString radioNowPlayingSubTitle(){
        return new LazyString(this.label() + " > Radio Now Playing Sub-Title",
                () -> allOf(
                        withId(R.id.nowplaying_artist_title),
                        isDescendantOfA( withId(R.id.nowplaying_track_info_layout) ),
                        isCompletelyDisplayed() ) );
    }

    public BasicButton onAirSonglistButton(){
        return new BasicButton(this.label() + " > onAirSonglistButton",
                () -> allOf(
                        withId(R.id.nowplaying_radio_song_button_layout),
                        isDescendantOfA( withId(R.id.nowplaying_compound_lyric_radio_layout) ),
                        isCompletelyDisplayed() ) );
    }

    public BasicButton radioPlayButton(){
        return new BasicButton(this.label() + " > Radio Play Button",
                () -> allOf(
                        withId(R.id.media_control_play_pause),
                        isDescendantOfA( withId(R.id.media_control_bar_normal) ),
                        isCompletelyDisplayed() ) );
    }
}
