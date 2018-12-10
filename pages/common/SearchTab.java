package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class SearchTab extends BasicButton {
    public SearchTab() {
        super( "SearchTab", () -> withId( R.id.navigation_search ) ) ;
    }
}
