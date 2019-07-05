package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public class ShufflePlayOnlyMessage extends ViewObject {
    public ShufflePlayOnlyMessage(){
        this.label( "ShufflePlayOnlyMessage" );
    }

    public LazyString title(){
        return new LazyString(this.label() + "> title",
                () -> allOf(
                        withId( R.id.alertTitle ),
                        withText("Shuffle play only") ) );
    }

    public LazyString description(){
        return new LazyString( this.label() + "> description",
                () -> allOf( withId( android.R.id.message ),
                        withText("Stream playlist can only be played in Shuffle mode. Please try our My Uta Plus Plan to play music by order.") ) );
    }

    public BasicButton closeButton(){
        return new BasicButton( this.label() + "> closeButton",
                () -> withId( android.R.id.button1 ) );
    }
}
