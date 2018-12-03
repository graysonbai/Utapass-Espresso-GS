package com.kddi.android.UtaPass.sqa_espresso.pages.stream.page;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.whatsnew.LastWeekPanel;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.whatsnew.ThisWeekPanel;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;

import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class WhatsNewPage extends BasicPage {

    public WhatsNewPage (){
        this.label( "WhatsNewPage" );
    }

    public void _ready(){
        this.thisWeekButton().assertVisible();
    }

    public BasicButton thisWeekButton(){
        return new BasicButton(
                this.label() + " > ThisWeekButton",
                () -> UtaPassUtil.withIndex(
                        allOf(
                                withClassName( endsWith( "TextView" ) ),
                                isDescendantOfA( withId( R.id.basetab_tabs ) ) ), 0 ) );
    }

    public BasicButton lastWeekButton(){
        return new BasicButton(
                this.label() + " > LastWeekButton",
                () -> UtaPassUtil.withIndex(
                        allOf(
                                withClassName( endsWith( "TextView" ) ),
                                isDescendantOfA( withId( R.id.basetab_tabs ) ) ), 1 ) );
    }

    public LastWeekPanel lastWeekPanel(){
        return new LastWeekPanel() ;
    }

    public ThisWeekPanel thisWeekPanel(){
        return new ThisWeekPanel() ;
    }
}
