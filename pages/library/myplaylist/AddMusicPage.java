package com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AddMusicPage extends ViewObject {

    public AddMusicPage(){
        this.label( "AddMusicPage" );
    }

    public void _ready(){
        searchBar().assertVisible();
    }

    public BasicButton searchBar(){
        return new BasicButton( this.label() + " > Search" ,
                () ->  withId( R.id.find_local_music_search_toolbar ) );
    }

    public BasicButton songsType(){
        return new BasicButton( this.label() + " > Songs" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 0 ) );
    }

    public BasicButton myutaSongsType(){
        return new BasicButton( this.label() + " > Myutasongs" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 1 ) );
    }

    public BasicButton artistsType(){
        return new BasicButton( this.label() + " > Artists" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 2 ) );
    }

    public BasicButton albumsType(){
        return new BasicButton( this.label() + " > Albums" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 3 ) );
    }

    public BasicButton videosType(){
        return new BasicButton( this.label() + " > Videos" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 4 ) );
    }

    public BasicButton falcType(){
        return new BasicButton( this.label() + " > Falc" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 5 ) );
    }

    public BasicButton playlistsType(){
        return new BasicButton( this.label() + " > Playlists" ,
                ()-> UtaPassUtil.withIndex(
                        this.getMatcherToCountMaxIndexOfWindow() , 6 ) );
    }

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_add_music_section_layout ) ;
    }
}