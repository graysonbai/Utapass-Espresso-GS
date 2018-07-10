package com.kddi.android.UtaPass.sqatest.common.category ;

import com.kddi.android.UtaPass.R ;
import android.view.View;
import org.hamcrest.Matcher;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class SongsCategory extends BasicCategory {

    @Override
    protected Matcher<View> getMatcherForItem() {
        return withId( R.id.library_section_tracks ) ;
    }
}
