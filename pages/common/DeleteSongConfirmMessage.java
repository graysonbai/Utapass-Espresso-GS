package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class DeleteSongConfirmMessage extends ViewObject {
    public DeleteSongConfirmMessage(){
        this.label( "DeleteSongConfirmMessage" );
    }

    public LazyString titleDescript(){
        return new LazyString( this.label() + " > songInfoButton",
                () -> allOf(
                        withId( R.id.alertTitle),
                        withText( "My Uta song will be deleted." ),
                        isDescendantOfA( withId( R.id.parentPanel ) ) ) );
    }

    public LazyString contentDescript(){
        return new LazyString( this.label() + " > songInfoButton",
                () -> allOf(
                        withId( android.R.id.message),
                        withText( "Would you like to delete this song? Please note that deleting the song will not return My Uta quota. You can re-download it from Library > My Uta > My Uta History anytime." ),
                        isDescendantOfA( withId( R.id.parentPanel ) ) ) );
    }

    public BasicButton cancelButton(){
        return new BasicButton( this.label() + " > songInfoButton",
                () -> allOf(
                        withId( android.R.id.button2),
                        isDescendantOfA( withId( R.id.parentPanel ) ) ) );
    }

    public BasicButton deleteButton(){
        return new BasicButton( this.label() + " > songInfoButton",
                () -> allOf(
                        withId( android.R.id.button1),
                        isDescendantOfA( withId( R.id.parentPanel ) ) ) );
    }
}
