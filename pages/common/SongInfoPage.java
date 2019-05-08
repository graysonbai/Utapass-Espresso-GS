package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class SongInfoPage extends ViewObject {
    public SongInfoPage(){
        this.label( " SongInfoPage " );
    }

    public void _ready(){
        this.titleName().assertVisible();
        this.myUtaButton().assertVisible();
    }

    public BasicButton songInfoPlayButton(){
        return new BasicButton( this.label() + " > songInFo Play Button ",
                () -> UtaPassUtil.withIndex( allOf(
                        withId( R.id.view_playlist_play_icon ),
                        isDescendantOfA( withId( R.id.song_info_cover_container ) ) ) , 0 ) );
    }

    public BasicButton songInfoPauseButton(){
        return new BasicButton( this.label() + " > songInFo Play Button ",
                () -> UtaPassUtil.withIndex( allOf(
                        withId( R.id.view_playlist_play_icon ),
                        UtaPassUtil.withDrawable( R.drawable.btn_pre_listen_stop ),
                        isDescendantOfA( withId( R.id.song_info_cover_container ) ) ) , 0 ) );
    }

    public LazyString titleName(){
        return new LazyString( this.label() + " > title Name ",
                () -> withId( R.id.song_info_song_name ) );
    }

    public LazyString contentDescription(){
        return new LazyString( this.label() + " > content Description ",
                () -> withId( R.id.song_info_artist_name_duration ) );
    }

    public BasicButton favoriteButton(){
        return new BasicButton( this.label() + " > Favorite Button ",
                () -> allOf(
                        withId( R.id.song_info_action_favorite ),
                        isDescendantOfA( withId( R.id.song_info_action_wrapper ) ) ) );
    }

    public BasicButton myUtaButton(){
        return new BasicButton( this.label() + " > MyUta Button ",
                () -> allOf(
                        withId( R.id.song_info_action_register ),
                        isDescendantOfA( withId( R.id.song_info_action_wrapper ) ) ) );
    }

    public BasicButton buyButton(){
        return new BasicButton( this.label() + " > buy Button ",
                () -> allOf(
                        withId( R.id.song_info_action_buy ),
                        isDescendantOfA( withId( R.id.song_info_action_wrapper ) ) ) );
    }
}
