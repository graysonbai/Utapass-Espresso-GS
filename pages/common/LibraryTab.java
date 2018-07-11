package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.Navigator;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.LibraryPage ;

import android.support.test.espresso.ViewInteraction ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed ;

public class LibraryTab extends ViewObject {

    private Navigator navigator ;
    private ViewInteraction item ;

    public LibraryTab() {
        this.item = onView( withId( R.id.navigation_library ) ) ;

        if( this.navigator == null ) {
            this.navigator = new Navigator() ;
        }
    }

    public void _ready() {
        this.item.check(matches(isDisplayed())) ;
    }

    public LibraryPage tap() {
        this.item.perform(click()) ;

        return this.navigator.libraryPage() ;
    }
}
