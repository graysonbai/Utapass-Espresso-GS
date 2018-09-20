package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.AllOf.allOf;

public class ReadMoreButton extends BasicButton {


    public ReadMoreButton() {
        super( () -> withId( R.id.synapse_myuta_intro_more ) ) ;
    }

    public String text() {
        return this.getText( UtaPassUtil.withIndex(
                allOf( withClassName( endsWith( "TextView" ) ),
                       isDescendantOfA( withId( R.id.synapse_myuta_intro_more ) ) ),
               0 ) ) ;
    }
}




