package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class LibraryTab extends BasicButton {
    public LibraryTab() {
        super( () -> withId( R.id.navigation_library ) ) ;
    }
}
