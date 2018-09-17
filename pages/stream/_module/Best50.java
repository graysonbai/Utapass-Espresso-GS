package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup.Best50LineUp;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.SeeAllButton;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.anyOf ;
import static org.hamcrest.Matchers.allOf ;


import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.withText ;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA ;

import static android.support.test.espresso.action.ViewActions.*;


public class Best50 extends ViewObject {

    private Matcher<View> matcher() {
        return withId( R.id.promotion_song_list_root_layout ) ;
    }

    public String title() {
        return this.getText( withId( R.id.promotion_song_list_title ) ) ;
    }

    public SeeAllButton seeAll() {
        return new SeeAllButton( this.matcher() ) ;
    }

    public String subtitle() {
        return this.getText( withId( R.id.promotion_song_list_subtitle ) ) ;
    }

    public Best50LineUp lineUp() {
        return new Best50LineUp() ;
    }
}




