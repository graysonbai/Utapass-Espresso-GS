package com.kddi.android.UtaPass.sqatest.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqatest.pages.SearchPage ;

import android.support.test.espresso.ViewInteraction ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed ;

public class SearchTab extends ViewObject{

    private Navigator navigator ;
    private ViewInteraction item ;

    public SearchTab() {
        this.item = onView( withId( R.id.navigation_search ) ) ;

        if( this.navigator == null ) {
            this.navigator = new Navigator() ;
        }
    }

    public void _ready() {
        this.item.check(matches(isDisplayed())) ;
    }

    public SearchPage tap() {
        this.item.perform(click()) ;

        return navigator.searchPage() ;
    }
}
