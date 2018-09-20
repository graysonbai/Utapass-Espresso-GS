package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.AllOf.allOf;


public class MyUtaButton extends BasicButton {

    private LazyMatcher matcher ;

    public MyUtaButton( LazyMatcher matcher ) {
        super( matcher ) ;

        this.matcher = matcher ;
    }

    public String text() {
        return this.getText( allOf(
                withClassName( endsWith( "TextView" ) ),
                isDescendantOfA( this.matcher.execute() ) ) ) ;
    }
}




