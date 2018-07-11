package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.sqa_espresso.pages.LibraryPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.SearchPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.StreamPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.AlbumsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.ArtistsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.MyUtaPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.SongsPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.albums.AlbumInfoPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.LiveConcertPage;


public class Navigator {

    private SongsPage songsPage ;
    private AlbumsPage albumsPage ;
    private AlbumInfoPage albumInfoPage ;
    private ArtistsPage artistsPage ;

    private MyUtaPage myUtaPage ;

    public StreamPage streamPage() {
        return new StreamPage().ready() ;
    }

    public LibraryPage libraryPage() {
        return new LibraryPage().ready() ;
    }

    public SearchPage searchPage() {
        return new SearchPage().ready() ;
    }

    public LiveConcertPage liveConcertPage() {
        return new LiveConcertPage().ready() ;
    }

    public SongsPage songsPage() {
        if( this.songsPage == null ) {
            this.songsPage = new SongsPage().ready() ;
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

    public MyUtaPage myUtaPage() {
        if( this.myUtaPage == null ) {
            this.myUtaPage = new MyUtaPage() ;
        }
        return this.myUtaPage ;
    }


}
