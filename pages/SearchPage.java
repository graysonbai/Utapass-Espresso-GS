package com.kddi.android.UtaPass.sqa_espresso.pages ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import android.support.test.espresso.ViewInteraction ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class SearchPage extends BasicPage {

    private ViewInteraction item ;

    public SearchPage() {
        this.item = onView( withId( R.id.navigation_stream ) ) ;
    }

    public void _ready() {
        this.streamTab().ready() ;
        this.libraryTab().ready() ;
//        this.searchTab().ready() ;


    }

//    public ArtistNewRelease artistNewRelease() {
//      id/item_stream_list
//    }
}