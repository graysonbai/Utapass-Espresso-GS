package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.pages.LibraryPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.SearchPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.StreamPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.NowPlayingBar;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.AlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.ArtistsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.MyUtaPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.SongsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumInfoPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.LiveConcertPage;


public class Navigator {

    private StreamPage streamPage ;
    private LibraryPage libraryPage ;
    private SearchPage searchPage ;

    private LiveConcertPage liveConcertPage ;

    private SongsPage songsPage ;
    private AlbumsPage albumsPage ;
    private AlbumInfoPage albumInfoPage ;
    private ArtistsPage artistsPage ;

    private MyUtaPage myUtaPage ;

    private NowPlayingBar nowPlayingBar ;

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

    public LiveConcertPage liveConcertPage() {
        if( this.liveConcertPage == null ) {
            this.liveConcertPage = new LiveConcertPage() ;
        }
        return this.liveConcertPage.ready() ;
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

    public MyUtaPage myUtaPage() {
        if( this.myUtaPage == null ) {
            this.myUtaPage = new MyUtaPage() ;
        }
        return this.myUtaPage.ready() ;
    }

    public NowPlayingBar nowPlayingBar() {
        if (this.nowPlayingBar == null) {
            this.nowPlayingBar = new NowPlayingBar();
        }
        return this.nowPlayingBar.ready();
    }
}
