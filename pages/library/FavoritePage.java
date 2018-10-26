package com.kddi.android.UtaPass.sqa_espresso.pages.library ;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static android.support.test.espresso.matcher.ViewMatchers.withText ;
import static org.hamcrest.Matchers.* ;


public class FavoritePage extends BasicPage {

    public FavoritePage() {
        this.label( "FavoritePage" ) ;
    }

    public BasicButton playlists() {
        return new BasicButton( this.label() + " > Playlists",
                () -> allOf( anyOf( withText( "Playlists" ),
                                    withText( "プレイリスト" ) ),
                             isCompletelyDisplayed() ) ) ;
    }

    public BasicButton streamMusic() {
        return new BasicButton( this.label() + " > StreamMusic",
                () -> allOf( anyOf( withText( "Stream Music" ),
                                    withText( "聴き放題の楽曲" ) ),
                             isCompletelyDisplayed() ) ) ;
    }

    public BasicButton localMusic() {
        return new BasicButton( this.label() + " > LocalMusic",
                () -> allOf( anyOf( withText( "Local Music" ),
                                    withText( "ローカル楽曲" ) ),
                             isCompletelyDisplayed() ) ) ;
    }
}
