package com.kddi.android.UtaPass.sqa_espresso.pages.library.myplaylist;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class CreatePlayListPage extends ViewObject {

    public CreatePlayListPage() {
        this.label( "CreatePlayListPage" );
    }

    public void _ready(){
       this.addMusicButton().assertVisible();
    }

    public BasicButton doneButton(){
        return new BasicButton(this.label() + " > DoneButton" ,
                () -> allOf( withId( R.id.done ),
                        isDescendantOfA( withId( R.id.create_playlist_toolbar ) ) ) );
    }

    public BasicButton addMusicButton(){
        return new BasicButton( this.label() + " > AddMusicButton",
                () -> withId( R.id.create_playlist_add_music_layout ) );
    }
}
