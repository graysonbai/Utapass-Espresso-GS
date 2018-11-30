package com.kddi.android.UtaPass.sqa_espresso.pages.stream.page.popularartist;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class FilterMenuPage extends ViewObject {
    public FilterMenuPage( String label ){
        this.label( label + " > FilterMenuPage" );
    }

    public void _ready(){
        this.allButton().assertVisible();
    }

    public BasicButton allButton(){
        return new BasicButton(
                this.label() + " > AllButton" ,
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.checked_title ), 0 ),
                        isDescendantOfA( withId( R.id.customPanel ) ) ) );
    }

    public BasicButton maleButton(){
        return new BasicButton(
                this.label() + " > MaleButton" ,
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.checked_title ), 1 ),
                        isDescendantOfA( withId( R.id.customPanel ) ) ) );
    }

    public BasicButton femaleButton(){
        return new BasicButton(
                this.label() + " > FemaleButton" ,
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.checked_title ), 2 ),
                        isDescendantOfA( withId( R.id.customPanel ) ) ) );
    }

    public BasicButton bandsButton(){
        return new BasicButton(
                this.label() + " > BandsButton" ,
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.checked_title ), 3 ),
                        isDescendantOfA( withId( R.id.customPanel ) ) ) );
    }

    public BasicButton groupsButton(){
        return new BasicButton(
                this.label() + " > GroupsButton" ,
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.checked_title ), 4 ),
                        isDescendantOfA( withId( R.id.customPanel ) ) ) );
    }

    public BasicButton okButton(){
        return new BasicButton(
                this.label() + " > Ok Button" ,
                () -> withText( "OK" ));
    }

    public BasicButton cancelButton(){
        return new BasicButton(
                this.label() + " > Cancel Button" ,
                () -> withText( "CANCEL" ));
    }
}
