package com.kddi.android.UtaPass.sqa_espresso.pages.library;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.playhistory.PlaylistsPane;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.playhistory.SongsPanel;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class PlayHistoryPage extends BasicPage {
    public PlayHistoryPage(){
        this.label( "PlayHistoryPage" );
    }

    public BasicButton playlistsPanelButton (){
        return new BasicButton(
                this.label() + " > playlistsPanel",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "Playlists" ),
                        isDescendantOfA( withId( R.id.basetab_tabs ) ) ) );
    }

    public BasicButton songsPanelButton (){
        return new BasicButton(
                this.label() + " > songsPanel",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "Songs" ),
                        isDescendantOfA( withId( R.id.basetab_tabs ) ) ) );
    }

    public PlaylistsPane playlistsPane (){
        return new PlaylistsPane();
    }

    public SongsPanel SongsPanel (){
        return new SongsPanel();
    }
}
