package com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class RadioDetailPage extends BasicPage {
    public RadioDetailPage(){
        this.label( "RadioDetailPage" );
    }

    public void _ready(){
        this.title().assertVisible();
        this.onAirSongListButton().assertVisible();
        this.playButton().assertVisible();
    }

    public LazyString title() {
        return new LazyString( this.label() + " > Title",
                () -> allOf(
                        withId( R.id.title_text ),
                        isDescendantOfA( withId( R.id.programDetailRecyclerView ) ) ) ) ;
    }

    public BasicButton onAirSongListButton(){
        return new BasicButton(
                this.label() + " > on-air songlist" ,
                () -> allOf(
                        withId( R.id.button_on_air_song_list ),
                        isDescendantOfA( withId(R.id.item_action ) ) ) );
    }

    public BasicButton playButton(){
        return new BasicButton(
                this.label() + " > PlayButton" ,
                () -> allOf(
                        withId( R.id.button_play_program ),
                        isDescendantOfA( withId(R.id.item_action ) ) ) ){
            public LazyString text(){
                return new LazyString(
                        this.label() ,
                        () -> allOf( withId( R.id.label_play ) ,
                                isDescendantOfA( withId( R.id.item_action ) ) ) );
            }
        };
    }

    public LazyString radioDjName() {
        return new LazyString( this.label() + " > DJ Name",
                () -> allOf(
                        withId( R.id.dj_name ),
                        isDescendantOfA( withId( R.id.item_dj_content ) ) ) ) ;
    }

    public LazyString radioStation() {
        return new LazyString( this.label() + " > Radio Station",
                () -> allOf(
                        withId( R.id.station_text ),
                        isDescendantOfA( withId( R.id.station_item ) ) ) ) ;
    }

    public LazyString radioTime() {
        return new LazyString( this.label() + " > Radio Time",
                () -> allOf(
                        withId( R.id.time_text ),
                        isDescendantOfA( withId( R.id.time_item ) ) ) ) ;
    }

    public LazyString radioDescription() {
        return new LazyString( this.label() + " > Radio Description",
                () -> allOf(
                        withId( R.id.description_text ),
                        isDescendantOfA( withId( R.id.description_item ) ) ) ) ;
    }
}