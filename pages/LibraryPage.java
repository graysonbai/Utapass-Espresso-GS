package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.library.DailyRankingModule;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class LibraryPage extends BasicPage{

    public LibraryPage() {
        this.label( "LibraryPage" ) ;
        this.retryWhenNotReady( false ) ;
    }

    public BasicButton songsCategory() {
        return new BasicButton(
                this.label() + " > SongsCategory",
                () -> withId( R.id.library_section_tracks ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton albumsCategory() {
        return new BasicButton(
                this.label() + " > AlbumsCategory",
                () -> withId( R.id.library_section_albums ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton artistsCategory() {
        return new BasicButton(
                this.label() + " > ArtistsCategory",
                () -> withId( R.id.library_section_artists ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton videosCategory() {
        return new BasicButton(
                this.label() + " > VideosCategory",
                () -> withId( R.id.library_section_videos ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton favoriteCategory() {
        return new BasicButton(
                this.label() + " > FavoriteCategory",
                () -> withId( R.id.library_section_liked ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton myPlaylistsCategory() {
        return new BasicButton(
                this.label() + " > MyPlaylistsCategory",
                () -> withId( R.id.library_section_playlists ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton myUtaCategory() {
        return new BasicButton(
                this.label() + " > MyUtaCategory",
                () -> withId( R.id.library_section_myuta ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton purchasedMusicCategory() {
        return new BasicButton(
                this.label() + " > PurchasedMusicCategory",
                () -> withId( R.id.library_section_purchased ) ) {

            public LazyString text() {
                return new LazyString( this.label(), () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        isDescendantOfA( super.matcher().execute() ) ) ) ;
            }
        } ;
    }

    public BasicButton playHistorySeeAllButton() {
        return new BasicButton(
                this.label() + " > PlayHistorySeeAllButton",
                () -> withId( R.id.library_section_history_see_all ) );
    }

    public DailyRankingModule dailyRankingModule(){
        return new DailyRankingModule( this.label() );
    }
}
