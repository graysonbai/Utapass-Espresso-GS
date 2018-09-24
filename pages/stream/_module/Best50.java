package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup.Best50LineUp;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;


public class Best50 extends ViewObject {

    public LazyString title() {
        return new LazyString( () -> withId( R.id.promotion_song_list_title ) ) ;
    }

    public BasicButton seeAll() {
        return new BasicButton( () -> allOf(
                anyOf( withText( "See All" ),
                       withText( "すべて見る" ) ),
                isDescendantOfA( withId( R.id.promotion_song_list_root_layout ) ) ) ) ;
    }

    public LazyString subtitle() {
        return new LazyString( () -> withId( R.id.promotion_song_list_subtitle ) ) ;
    }

    public Best50LineUp lineUp() {
        return new Best50LineUp() ;
    }
}




