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
import com.kddi.android.UtaPass.sqa_espresso.pages.library.VideosPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.FavoritePage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumInfoPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.artists.ArtistAlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.favorite.PlaylistsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta.SongMoreActionMenu;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.songs.PermissionPopupMessage;
import com.kddi.android.UtaPass.sqa_espresso.pages.settings.IdSettingsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.Best50Page;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.LiveConcertPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.NewSongsHitSongsPage;
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
    private VideosPage videosPage ;
    private FavoritePage favoritePage ;
    private PlaylistsPage playlistsPage ;

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
    private IdSettingsPage idSettingsPage ;

    private PermissionPopupMessage permissionPopupMessage ;

    private NewSongsHitSongsPage newSongsHitSongsPage ;

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
        return this.libraryPage.ready() ;
    }

    public SearchPage searchPage() {
        if( this.searchPage == null ) {
            this.searchPage = new SearchPage() ;
        }
        return this.searchPage.ready() ;
    }

    public SpotlightPage spotlightPage() {
        if( this.spotlightPage == null ) {
            this.spotlightPage = new SpotlightPage() ;
        }
        return this.spotlightPage.ready() ;
    }

    public LiveConcertPage liveConcertPage() {
        if( this.liveConcertPage == null ) {
            this.liveConcertPage = new LiveConcertPage() ;
        }
        return this.liveConcertPage.ready() ;
    }

    public Best50Page best50Page() {
        if( this.best50Page == null ) {
            this.best50Page = new Best50Page() ;
        }
        return this.best50Page.ready() ;
    }

    public SongsPage songsPage() {
        if( this.songsPage == null ) {
            this.songsPage = new SongsPage() ;
        }
        return this.songsPage.ready() ;
    }

    public AlbumsPage albumsPage() {
        if( this.albumsPage == null ) {
            this.albumsPage = new AlbumsPage() ;
        }
        return this.albumsPage.ready() ;
    }

    public AlbumInfoPage albumInfoPage() {
        if( this.albumInfoPage == null ) {
            this.albumInfoPage = new AlbumInfoPage() ;
        }
        return this.albumInfoPage.ready() ;
    }

    public ArtistsPage artistsPage() {
        if( this.artistsPage == null ) {
            this.artistsPage = new ArtistsPage() ;
        }
        return this.artistsPage.ready() ;
    }

    public ArtistAlbumsPage artistAlbumsPage() {
        if( this.artistAlbumsPage == null ) {
            this.artistAlbumsPage = new ArtistAlbumsPage() ;
        }
        return this.artistAlbumsPage.ready() ;
    }

    public MyUtaPage myUtaPage() {
        if( this.myUtaPage == null ) {
            this.myUtaPage = new MyUtaPage() ;
        }
        return this.myUtaPage.ready() ;
    }

    public SongMoreActionMenu songMoreActionMenu() {
        if( this.songMoreActionMenu == null ) {
            this.songMoreActionMenu = new SongMoreActionMenu() ;
        }
        return this.songMoreActionMenu.ready() ;
    }

    public NowPlayingBar nowPlayingBar() {
        if( this.nowPlayingBar == null ) {
            this.nowPlayingBar = new NowPlayingBar() ;
        }
        return this.nowPlayingBar.ready() ;
    }

    public StreamTab streamTab() {
        if( this.streamTab == null ) {
            this.streamTab = new StreamTab() ;
        }
        return this.streamTab.ready() ;
    }

    public LibraryTab libraryTab() {
        if( this.libraryTab == null ) {
            this.libraryTab = new LibraryTab() ;
        }
        return this.libraryTab.ready() ;
    }

    public SearchTab searchTab() {
        if( this.searchTab == null ) {
            this.searchTab = new SearchTab() ;
        }
        return this.searchTab.ready() ;
    }

    public SaveMyUtaPopupMessage saveMyUtaPopupMessage() {
        if( this.saveMyUtaPopupMessage == null ) {
            this.saveMyUtaPopupMessage = new SaveMyUtaPopupMessage() ;
        }
        return this.saveMyUtaPopupMessage.ready() ;
    }

    public SaveMyUtaConfirmPopupMessage saveMyUtaConfirmPopupMessage() {
        if( this.saveMyUtaConfirmPopupMessage == null ) {
            this.saveMyUtaConfirmPopupMessage = new SaveMyUtaConfirmPopupMessage() ;
        }

        // saveMyUtaConfirmPopupMessage only displays
        // when a user hits MyUta button on first time.
        // After that, it will not display any more.
        // Thus, it is not OK to call ready() before using it.
        return this.saveMyUtaConfirmPopupMessage ;
    }

    public DeleteMyUtaConfirmPopupMessage deleteMyUtaConfirmPopupMessage() {
        if( this.deleteMyUtaConfirmPopupMessage == null ) {
            this.deleteMyUtaConfirmPopupMessage = new DeleteMyUtaConfirmPopupMessage() ;
        }
        return this.deleteMyUtaConfirmPopupMessage.ready() ;
    }

    public SideBarMenu sideBarMenu() {
        if( this.sideBarMenu == null ) {
            this.sideBarMenu = new SideBarMenu() ;
        }
        return this.sideBarMenu.ready() ;
    }

    public SettingsPage settingsPage() {
        if( this.settingsPage == null ) {
            this.settingsPage = new SettingsPage() ;
        }
        return this.settingsPage.ready() ;
    }

    public IdSettingsPage idSettingsPage() {
        if( this.idSettingsPage == null ) {
            this.idSettingsPage = new IdSettingsPage() ;
        }
        return this.idSettingsPage ;
    }

    public PermissionPopupMessage permissionPopupMessage() {
        if( this.permissionPopupMessage == null ) {
            this.permissionPopupMessage = new PermissionPopupMessage() ;
        }
        return this.permissionPopupMessage ;
    }

    public NewSongsHitSongsPage newSongsHitSongsPage() {
        if( this.newSongsHitSongsPage == null ) {
            this.newSongsHitSongsPage = new NewSongsHitSongsPage() ;
        }
        return this.newSongsHitSongsPage.ready() ;
    }

    public VideosPage videosPage() {
        if( this.videosPage == null ) {
            this.videosPage = new VideosPage() ;
        }
        return this.videosPage.ready() ;
    }

    public FavoritePage favoritePage() {
        if( this.favoritePage == null ) {
            this.favoritePage = new FavoritePage() ;
        }
        return this.favoritePage.ready() ;
    }

    public PlaylistsPage playlistsPage() {
        if( this.playlistsPage == null ) {
            this.playlistsPage = new PlaylistsPage() ;
        }
        return this.playlistsPage.ready() ;
    }
}
