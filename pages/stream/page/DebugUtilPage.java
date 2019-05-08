package com.kddi.android.UtaPass.sqa_espresso.pages.stream.page;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class DebugUtilPage extends ViewObject {
    public DebugUtilPage(){
        this.label( "DebugUtilPage" );
    }

    public void _ready(){

    }

    public LazyString getMsno(){
        return new LazyString(
                this.label() + " > getMsno",
                () ->  UtaPassUtil.withIndex( withId( R.id.debug_user_info_msno ), 0 ) );
    }

    public BasicButton backButton(){
        return new BasicButton(
                this.label() + "backButton",
                () -> allOf(
                        withClassName( endsWith( "ImageButton" )),
                        isDescendantOfA( withId(R.id.debug_utils_toolbar ) ) ) );
    }
}
