package com.kddi.android.UtaPass.sqa_espresso.pages.stream.page;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.topchart.TopChannelPanel;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.topchart.TopGrossingPanel;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class TopChartPage extends BasicPage {
    public TopChartPage (){
        this.label( "TopChartPage" );
    }

    public void _ready(){
        this.topChannelButton().assertVisible();
    }

    public BasicButton topChannelButton(){
        return new BasicButton(
                this.label() + " > TopChannelButton",
                () -> UtaPassUtil.withIndex(
                        allOf(
                                withClassName( endsWith( "TextView" ) ),
                                isDescendantOfA( withId( R.id.basetab_tabs ) ) ), 0 ) );
    }

    public BasicButton topGrossingButton(){
        return new BasicButton(
                this.label() + " > TopGrossingButton",
                () -> UtaPassUtil.withIndex(
                        allOf(
                                withClassName( endsWith( "TextView" ) ),
                                isDescendantOfA( withId( R.id.basetab_tabs ) ) ), 1 ) );
    }

    public TopChannelPanel topChannelPanel(){
        return new TopChannelPanel() ;
    }

    public TopGrossingPanel topGrossingPanel(){
        return new TopGrossingPanel() ;
    }
}