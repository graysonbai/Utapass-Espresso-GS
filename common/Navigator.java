package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.pages.LibraryPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.SearchPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.SettingsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.StreamPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.LibraryTab;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.NowPlayingBar;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.SearchTab;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.StreamTab;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.AlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.ArtistsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.MyUtaPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.SongsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumInfoPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.artists.ArtistAlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.SongMoreActionMenu;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.Best50Page;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.LiveConcertPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.SideBarMenu;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.SpotlightPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.DeleteMyUtaConfirmPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SaveMyUtaConfirmPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SaveMyUtaPopupMessage;


public class Navigator {

    private StreamPage streamPage ;
    private LibraryPage libraryPage ;
    private SearchPage searchPage ;

    private SpotlightPage spotlightPage ;
    private LiveConcertPage liveConcertPage ;
    private Best50Page best50Page ;

    private SongsPage songsPage ;
    private AlbumsPage albumsPage ;
    private AlbumInfoPage albumInfoPage ;
    private ArtistsPage artistsPage ;
    private ArtistAlbumsPage artistAlbumsPage ;

    private MyUtaPage myUtaPage ;
    private SongMoreActionMenu songMoreActionMenu ;

    private NowPlayingBar nowPlayingBar ;
    private StreamTab streamTab ;
    private LibraryTab libraryTab ;
    private SearchTab searchTab ;

    private SaveMyUtaPopupMessage saveMyUtaPopupMessage ;
    private SaveMyUtaConfirmPopupMessage saveMyUtaConfirmPopupMessage ;
    private DeleteMyUtaConfirmPopupMessage deleteMyUtaConfirmPopupMessage ;

    private SideBarMenu sideBarMenu ;
    private SettingsPage settingsPage ;

    public StreamPage streamPage() {
        if( this.streamPage == null ) {
            this.streamPage = new StreamPage() ;
        }
        return this.streamPage.ready() ;
    }

    public LibraryPage libraryPage() {
        if( this.libraryPage == null ) {
            this.libraryPage = new LibraryPage() ;
        }
        return this.libraryPage ;
    }

    public SearchPage searchPage() {
        if( this.searchPage == null ) {
            this.searchPage = new SearchPage() ;
        }
        return this.searchPage ;
    }

    public SpotlightPage spotlightPage() {
        if( this.spotlightPage == null ) {
            this.spotlightPage = new SpotlightPage() ;
        }
        return this.spotlightPage ;
    }

    public LiveConcertPage liveConcertPage() {
        if( this.liveConcertPage == null ) {
            this.liveConcertPage = new LiveConcertPage() ;
        }
        return this.liveConcertPage ;
    }

    public Best50Page best50Page() {
        if( this.best50Page == null ) {
            this.best50Page = new Best50Page() ;
        }
        return this.best50Page ;
    }

    public SongsPage songsPage() {
        if( this.songsPage == null ) {
            this.songsPage = new SongsPage() ;
        }
        return this.songsPage ;
    }

    public AlbumsPage albumsPage() {
        if( this.albumsPage == null ) {
            this.albumsPage = new AlbumsPage() ;
        }
        return this.albumsPage ;
    }

    public AlbumInfoPage albumInfoPage() {
        if( this.albumInfoPage == null ) {
            this.albumInfoPage = new AlbumInfoPage() ;
        }
        return this.albumInfoPage ;
    }

    public ArtistsPage artistsPage() {
        if( this.artistsPage == null ) {
            this.artistsPage = new ArtistsPage() ;
        }
        return this.artistsPage ;
    }

    public ArtistAlbumsPage artistAlbumsPage() {
        if( this.artistAlbumsPage == null ) {
            this.artistAlbumsPage = new ArtistAlbumsPage() ;
        }
        return this.artistAlbumsPage ;
    }

    public MyUtaPage myUtaPage() {
        if( this.myUtaPage == null ) {
            this.myUtaPage = new MyUtaPage() ;
        }
        return this.myUtaPage ;
    }

    public SongMoreActionMenu songMoreActionMenu() {
        if( this.songMoreActionMenu == null ) {
            this.songMoreActionMenu = new SongMoreActionMenu() ;
        }
        return this.songMoreActionMenu ;
    }

    public NowPlayingBar nowPlayingBar() {
        if( this.nowPlayingBar == null ) {
            this.nowPlayingBar = new NowPlayingBar() ;
        }
        return this.nowPlayingBar ;
    }

    public StreamTab streamTab() {
        if( this.streamTab == null ) {
            this.streamTab = new StreamTab() ;
        }
        return this.streamTab ;
    }

    public LibraryTab libraryTab() {
        if( this.libraryTab == null ) {
            this.libraryTab = new LibraryTab() ;
        }
        return this.libraryTab ;
    }

    public SearchTab searchTab() {
        if( this.searchTab == null ) {
            this.searchTab = new SearchTab() ;
        }
        return this.searchTab ;
    }

    public SaveMyUtaPopupMessage saveMyUtaPopupMessage() {
        if( this.saveMyUtaPopupMessage == null ) {
            this.saveMyUtaPopupMessage = new SaveMyUtaPopupMessage() ;
        }
        return this.saveMyUtaPopupMessage ;
    }

    public SaveMyUtaConfirmPopupMessage saveMyUtaConfirmPopupMessage() {
        if( this.saveMyUtaConfirmPopupMessage == null ) {
            this.saveMyUtaConfirmPopupMessage = new SaveMyUtaConfirmPopupMessage() ;
        }
        return this.saveMyUtaConfirmPopupMessage ;
    }

    public DeleteMyUtaConfirmPopupMessage deleteMyUtaConfirmPopupMessage() {
        if( this.deleteMyUtaConfirmPopupMessage == null ) {
            this.deleteMyUtaConfirmPopupMessage = new DeleteMyUtaConfirmPopupMessage() ;
        }
        return this.deleteMyUtaConfirmPopupMessage ;
    }

    public SideBarMenu sideBarMenu() {
        if( this.sideBarMenu == null ) {
            this.sideBarMenu = new SideBarMenu() ;
        }
        return this.sideBarMenu ;
    }

    public SettingsPage settingsPage() {
        if( this.settingsPage == null ) {
            this.settingsPage = new SettingsPage() ;
        }
        return this.settingsPage ;
    }
}
