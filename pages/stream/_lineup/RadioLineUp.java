package com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup ;

import android.view.View ;
import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream._lineup._card.RadioCard;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.core.AllOf.allOf;

public class RadioLineUp extends LineUpObject {

    public static String titleInEnglish = "Original radio program" ;
    public static String titleInJapanese = "オリジナルラジオ番組" ;

    protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
        return withId( R.id.item_radio_root_layout ) ;
    }

    protected String getTitleOfLineUpInEnglish() {
        return RadioLineUp.titleInEnglish ;
    }

    protected String getTitleOfLineUpInJapanese() {
        return RadioLineUp.titleInJapanese ;
    }

    public RadioCard card(int index ) {
        int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

        RadioCard card = new RadioCard() ;

        card.name( () -> allOf(
                withId( R.id.item_radio_name ),
                isDescendantOfA(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                               indexInWindow ) ) ) ) ;

        card.playButton( () -> allOf(
                withId( R.id.item_radio_play ),
                isDescendantOfA(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(),
                                               indexInWindow ) ) ) ) ;

        return card ;
    }
}


