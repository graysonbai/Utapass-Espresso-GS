package com.kddi.android.UtaPass.sqatest.pages ;

import com.kddi.android.UtaPass.sqatest.common.category.AlbumsCategory;
import com.kddi.android.UtaPass.sqatest.common.category.ArtistsCategory;
import com.kddi.android.UtaPass.sqatest.common.category.FavoriteCategory;
import com.kddi.android.UtaPass.sqatest.common.category.MyPlaylistsCategory;
import com.kddi.android.UtaPass.sqatest.common.category.MyUtaCategory;
import com.kddi.android.UtaPass.sqatest.common.category.PurchasedMusicCategory;
import com.kddi.android.UtaPass.sqatest.common.category.SongsCategory;
import com.kddi.android.UtaPass.sqatest.common.category.VideosCategory;

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
