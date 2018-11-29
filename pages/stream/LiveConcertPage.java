package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicTextField;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IContent;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IName;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class LiveConcertPage extends ViewObject {

    public LiveConcertPage() {
        this.label( "LiveConcertPage" ) ;
    }

    private InternalLineUp lineUp ;

    public void _ready() {
        this.video().assertVisible() ;
        this.loadingIcon().assertInvisible() ;
    }

    public BasicImage icon() {
        return new BasicImage( this.label() + " > icon",
                () -> withId( R.id.live_info_bar_icon ) ) ;
    }

    public LazyString title() {
        return new LazyString( this.label() + " > title",
                () -> withId( R.id.live_info_bar_title ) ) ;
    }

    public BasicImage video() {
        return new BasicImage( this.label() + " > liveVideo",
                () -> withId( R.id.live_nowplaying_video_layout ) ) ;
    }

    public BasicButton arrowButton() {
        return new BasicButton( this.label() + " > arrowButton",
                () -> withId( R.id.view_live_video_control_arrow ) ) ;
    }

    public BasicTextField messageTextField() {
        return new BasicTextField( this.label() + " > messageTextField",
                () -> withId( R.id.live_nowplaying_chat_edit ) ) ;
    }

    public BasicButton sendButton() {
        return new BasicButton( this.label() + " > sendButton",
                () -> withId( R.id.live_nowplaying_chat_send ) ) ;
    }

    public BasicImage loadingIcon() {
        return new BasicImage( this.label() + " > loadingIcon",
                () -> withId( R.id.live_nowplaying_progress_bar ) ) ;
    }

    public InternalLineUp chatroom() {
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ) {
            this.label( label + " > Chatroom" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.live_nowplaying_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( anyOf( withId( R.id.live_chat_other_layout ),
                                 withId( R.id.live_chat_self_layout ) ),
                          isCompletelyDisplayed() ) ;
        }

        public InternalCard lastMessage() {
            return this.card( this.calculateMaxIndexOfWindow() ) ;
        }

        private InternalCard card( int index ) {
            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > Message(%s)",
                    this.label(),
                    index ) ;

            card.name( label + " > name",
                    () -> allOf(
                            anyOf( withId( R.id.live_chat_other_name ),
                                   withId( R.id.live_chat_self_name ) ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    index ) ) ) ) ;

            card.content( label + " > content",
                    () -> allOf(
                            anyOf( withId( R.id.live_chat_other_content ),
                                   withId( R.id.live_chat_self_content ) ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    index ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements IName, IContent {
        String labelName ;
        String labelContent ;

        private LazyMatcher matcherName ;
        private LazyMatcher matcherContent ;

        public void name( String label, LazyMatcher matcher ) {
            this.labelName = label ;
            this.matcherName = matcher ;
        }

        public LazyString name() {
            return new LazyString( this.labelName, this.matcherName ) ;
        }

        public void content( String label, LazyMatcher matcher ) {
            this.labelContent = label ;
            this.matcherContent = matcher ;
        }

        public LazyString content() {
            return new LazyString( this.labelContent, this.matcherContent ) ;
        }
    }
}
