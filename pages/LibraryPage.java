package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.sqa_espresso.common.category.* ;

public class LibraryPage extends BasicPage{

    public SongsCategory songsCategory() {
        return new SongsCategory().ready() ;
    }

    public AlbumsCategory albumsCategory() {
        return new AlbumsCategory().ready() ;
    }

    public ArtistsCategory artistsCategory() {
        return new ArtistsCategory().ready() ;
    }

    public VideosCategory videosCategory() {
        return new VideosCategory().ready() ;
    }

    public FavoriteCategory favoriteCategory() {
        return new FavoriteCategory().ready() ;
    }

    public MyPlaylistsCategory myPlaylistsCategory() {
        return new MyPlaylistsCategory().ready() ;
    }

    public MyUtaCategory myUtaCategory() {
        return new MyUtaCategory().ready() ;
    }

    public PurchasedMusicCategory purchasedMusicCategory() {
        return new PurchasedMusicCategory().ready() ;
    }
}
