package com.kddi.android.UtaPass.sqa_espresso.pages.library.artists;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class AlbumDetailMorePanel extends BasicPage {
    public AlbumDetailMorePanel(){
        this.label( "AlbumDetailMorePanel" );
    }

    public BasicButton songInfoButton(){
        return new BasicButton( this.label() + " > songInfoButton",
                () -> allOf(
                        UtaPassUtil.withIndex(withId( R.id.context_menu_layout), 0 ),
                        isDescendantOfA( withId( R.id.design_bottom_sheet ) ) ) );
    }

    public BasicButton songDetailButton(){
        return new BasicButton( this.label() + " > songDetailButton",
                () -> allOf(
                        UtaPassUtil.withIndex(withId( R.id.context_menu_layout), 1 ),
                        isDescendantOfA( withId( R.id.design_bottom_sheet ) ) ) );
    }

    public BasicButton addtoPlaylistButton(){
        return new BasicButton( this.label() + " > addtoPlaylistButton",
                () -> allOf(
                        UtaPassUtil.withIndex(withId( R.id.context_menu_layout), 2 ),
                        isDescendantOfA( withId( R.id.design_bottom_sheet ) ) ) );
    }

    public BasicButton deleteSongButton(){
        return new BasicButton( this.label() + " > deleteSongButton",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.context_menu_layout), 3 ),
                        isDescendantOfA( withId( R.id.design_bottom_sheet ) ) ) );
    }
}
