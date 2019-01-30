package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicString;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.endsWith;

public class MyUtaPlayHistoryPopupMessage extends ViewObject {

    public MyUtaPlayHistoryPopupMessage(){
        this.label( "MyUtaPlayHistoryPopupMessage" );
    }

    public void _ready(){
        UtaPassUtil.sleep( 5, "for stability");
    }

    public LazyString title(){
        return new LazyString(this.label(), () ->  UtaPassUtil.withIndex( withClassName( endsWith( "TextView" ) ), 0 ));
    }

    public LazyString message(){
        return new LazyString(this.label(), () ->  UtaPassUtil.withIndex( withClassName( endsWith( "TextView" ) ), 1 ));
    }

    public BasicButton closeButton(){
        return new BasicButton( this.label() + "CloseButton",
                () -> withId( R.id.myuta_max_quota_confirm) );
    }

    public BasicButton checkbox(){
        return new BasicButton( this.label() + "CheckBox",
                () -> withId( R.id.checkbox_never_show_again ));
    }
}
