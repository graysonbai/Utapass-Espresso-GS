package com.kddi.android.UtaPass.sqa_espresso.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.pages.StreamPage ;

import android.support.test.espresso.ViewInteraction ;
import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed ;

public class StreamTab extends ViewObject{

    private Navigator navigator ;
    private ViewInteraction item ;

    public StreamTab() {
        this.item = onView( withId( R.id.navigation_stream ) ) ;

        if( this.navigator == null ) {
            this.navigator = new Navigator() ;
        }
    }

    public void _ready() {
        this.item.check(matches(isDisplayed())) ;
    }

    public StreamPage tap() {
        this.item.perform(click()) ;

        return navigator.streamPage() ;
    }
}
