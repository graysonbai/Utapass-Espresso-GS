package com.kddi.android.UtaPass.sqa_espresso.pages.search.searchArtist;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class SearchArtistPage extends BasicPage {
    public SearchArtistPage(){
        this.label( "SearchArtistPage" );
    }

    public BasicButton songPanelButton(){
        return new BasicButton( this.label() + " > songPanelButton",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "Song" ) ) );
    }

    public BasicButton playlistPanelButton(){
        return new BasicButton( this.label() + " > playlistPanelButton",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "Playlist" ) ) );
    }

    public SongPanel songPanel(){
        return new SongPanel( this.label() );
    }

    public PlaylistPanel playlistPanel(){
        return new PlaylistPanel( this.label() );
    }
}
