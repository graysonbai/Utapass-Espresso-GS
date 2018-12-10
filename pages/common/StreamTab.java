package com.kddi.android.UtaPass.sqa_espresso.pages.common ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class StreamTab extends BasicButton {
    public StreamTab() {
        super( "StreamTab", () -> withId( R.id.navigation_stream ) ) ;
    }
}
