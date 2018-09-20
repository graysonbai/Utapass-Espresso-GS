package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.view.View;
import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup.Best50LineUp;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SeeAllButton;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;


public class Best50 extends ViewObject {

    private Matcher<View> matcher() {
        return withId( R.id.promotion_song_list_root_layout ) ;
    }

    public LazyString title() {
        return new LazyString( () -> withId( R.id.promotion_song_list_title ) ) ;
    }

    public SeeAllButton seeAll() {
        return new SeeAllButton( this.matcher() ) ;
    }

    public LazyString subtitle() {
        return new LazyString( () -> withId( R.id.promotion_song_list_subtitle ) ) ;
    }

    public Best50LineUp lineUp() {
        return new Best50LineUp() ;
    }
}




