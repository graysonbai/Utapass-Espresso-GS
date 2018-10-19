package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class DailyMixModule extends ViewObject {

    public static String label = "Stream > DailyMixModule" ;
    private InternalLineUp lineup ;

    public DailyMixModule( String label ) {
        this.label( label + " > DailyMixModule" ) ;
    }

    public Matcher<View> matcher() {
         return withId( R.id.item_dailymix_root_layout ) ;
    }

    public InternalLineUp lineUp() {
        if( this.lineup == null ) {
            this.lineup = new InternalLineUp( this.label() ) ;
        }
        return this.lineup ;
    }

    // DailyMixModule has only 1 card and cannot be swiped
    // Thus, no need to extend from LineUpObject
    public class InternalLineUp {
        private String label ;

        public InternalLineUp( String label ) {
            this.label = label + " > LineUp" ;
        }

        public InternalCard card( int index ) {

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label,
                    index ) ;

            card.cover( label + " > Cover",
                    () -> withId( R.id.item_dailymix_cardview ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> withId( R.id.item_dailymix_play ) ) ;

            card.title( label + " > Title",
                    () -> withId( R.id.item_dailymix_title ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, ITitle, IPlayButton {

        String labelCover ;
        String labelTitle ;
        String labelPlayButton ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherTitle ;
        private LazyMatcher matcherPlayButton ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void playButton( String label, LazyMatcher matcher ) {
            this.labelPlayButton = label ;
            this.matcherPlayButton = matcher ;
        }

        public BasicButton playButton() {
            return new BasicButton( this.labelPlayButton, this.matcherPlayButton ) ;
        }

        public void title( String label, LazyMatcher matcher ) {
            this.labelTitle = label ;
            this.matcherTitle = matcher ;
        }

        public LazyString title() {
            return new LazyString( this.labelTitle, this.matcherTitle ) ;
        }
    }
}




