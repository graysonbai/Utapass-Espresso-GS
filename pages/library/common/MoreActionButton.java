package com.kddi.android.UtaPass.sqa_espresso.pages.library.common ;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton ;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;

public class MoreActionButton extends BasicButton {

    public MoreActionButton( final ViewInteraction view ) {
        super( view ) ;
    }

    public MoreActionButton( final Matcher<View> matcher ) {
        super( matcher ) ;
    }

    public void _ready() {
        if( ! this.isVisible() ) {
            String msg = "NotReady: MyUta > DownloadedSongs > Song > MoreActionButton" ;
            throw new RuntimeException( msg ) ;
        }
    }
}




