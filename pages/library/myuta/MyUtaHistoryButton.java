package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton ;

import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class MyUtaHistoryButton extends BasicButton {

    public MyUtaHistoryButton() {
        super( () -> withId( R.id.myuta_to_management ) ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            throw new RuntimeException( "NotReady: MyUta > MyUtaHistoryButton" ) ;
        }
    }
}




