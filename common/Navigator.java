package com.kddi.android.UtaPass.sqa_espresso.common ;
import com.kddi.android.UtaPass.sqa_espresso.pages.* ;


public class Navigator {

    private AllTracksPage allTracksPage ;
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

    public AllTracksPage allTracksPage() {
        if( this.allTracksPage == null ) {
            this.allTracksPage = new AllTracksPage().ready() ;
        }
        return this.allTracksPage ;
    }

    public MyUtaPage myUtaPage() {
        if( this.myUtaPage == null ) {
            this.myUtaPage = new MyUtaPage() ;
        }
        return this.myUtaPage ;
    }
}
