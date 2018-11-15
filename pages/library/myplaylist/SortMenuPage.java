package com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SortMenuPage extends ViewObject {

    private BasicButton recrnntlyUpdatedButton;
    private BasicButton mostPlayedButton;

    public SortMenuPage( String label){
        this.label( label + " > SortMenuPage" );
    }

    public BasicButton recrntlyUpdatedButton() {
        return new BasicButton( this.label() + " > recrntlyUpdatedButton" ,
                () -> UtaPassUtil.withIndex( withId( R.id.menu_item_text ), 0 ) );
    }

    public BasicButton mostPlayedButton(){
        return new BasicButton( this.label() + " > mostPlayedButton" ,
                ()->  UtaPassUtil.withIndex( withId( R.id.menu_item_text ), 1 ) );
    }
}
