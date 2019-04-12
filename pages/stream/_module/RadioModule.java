package com.kddi.android.UtaPass.sqa_espresso.pages.stream._module ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IDjName;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IPlayButton;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IProgramName;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;


public class RadioModule extends ViewObject {

    public static String titleInEnglish = "Featured Stations" ;
    public static String titleInJapanese = "Pick Up ラジオ" ;
    private InternalLineUp lineup ;

    public RadioModule( String label ) {
        this.label( label + " > RadioModule" ) ;
    }

    public Matcher<View> matcher() {
         return allOf( withId( R.id.item_list_title_layout ),
                       hasDescendant( anyOf(
                               withText( RadioModule.titleInEnglish ),
                               withText( RadioModule.titleInJapanese ) ) ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > Title",
                () -> allOf(
                        withId( R.id.item_list_title ),
                        isDescendantOfA( this.matcher() ) ) ) ;
    }

    public InternalLineUp lineUp() {
        if( this.lineup == null ) {
            this.lineup = new InternalLineUp( this.label() ) ;
        }
        return this.lineup ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
        }

        protected String getTitleOfLineUpInEnglish() {
            return RadioModule.titleInEnglish ;
        }

        protected String getTitleOfLineUpInJapanese() {
            return RadioModule.titleInJapanese ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf(
                    withId( R.id.item_radio_root_layout ),
                    isCompletelyDisplayed() ) ;
        }

        public InternalCard lastCard() {
            InternalCard firstCard = this.card( 0 ) ;
            String programName = firstCard.programName().string() ;
            String djName = firstCard.djName().string() ;

            for( int i = this.maxIndexOfLineUpObject; i >= 0 ; i-- ) {

                // the structure is quite weired,
                // I need to get the card twice to get the right one
                this.card( i ) ;
                InternalCard candidateCard = this.card( i ) ;

                if( ! candidateCard.programName().isEquals( programName ) ) {
                    return candidateCard ;
                }

                if( ! candidateCard.djName().isEquals( djName ) ) {
                    return candidateCard ;
                }
            }

            return firstCard ;
        }


        public InternalCard card( int index ) {
            this.swipeToCardViewAndGetIndexOfWindow( index ) ;
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_radio_avatar ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.playButton(label + " > PlayButton",
                    () -> allOf(
                            withId( R.id.item_radio_play ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.programName( label + " > ProgramName",
                    () -> allOf(
                            withId( R.id.item_radio_program_name ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.djName( label + " > DjName",
                    () -> allOf(
                            withId( R.id.item_radio_dj_name ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, IPlayButton, IProgramName, IDjName {

        String labelCover ;
        String labelProgramName ;
        String labelDjName ;
        String labelPlayButton ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherProgramName ;
        private LazyMatcher matcherDjName ;
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

        public void programName( String label, LazyMatcher matcher ) {
            this.labelProgramName = label ;
            this.matcherProgramName = matcher ;
        }

        public LazyString programName() {
            return new LazyString( this.labelProgramName, this.matcherProgramName ) ;
        }

        public void djName( String label, LazyMatcher matcher ) {
            this.labelDjName = label ;
            this.matcherDjName = matcher ;
        }

        public LazyString djName() {
            return new LazyString( this.labelDjName, this.matcherDjName ) ;
        }
    }
}




