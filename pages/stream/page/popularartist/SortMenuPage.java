package com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.popularartist;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SortMenuPage extends ViewObject {
    public SortMenuPage( String label ){
        this.label( label + " > SortMenuPage" );
    }

    public void _ready(){
        this.latestButton().assertVisible();
    }

    public BasicButton latestButton(){
        return new BasicButton(
                this.label() + " > Latest Button",
                () -> UtaPassUtil.withIndex(
                        withId( R.id.menu_item_text ) , 0 ) );
    }

    public BasicButton popularButton(){
        return new BasicButton(
                this.label() + " > Popular Button",
                () -> UtaPassUtil.withIndex(
                        withId( R.id.menu_item_text ) , 1 ) );
    }
}
