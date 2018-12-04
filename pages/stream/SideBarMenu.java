package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ICover;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISubtitle;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ITitle;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.endsWith;

public class SideBarMenu extends ViewObject {
    private Matcher<View> matcher ;
    private InternalLineUp lineUp;

    public SideBarMenu() {
        this.matcher = withId( R.id.main_navigation_view ) ;
        this.label( "SideBarMenu" ) ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible() ) {
            throw new InvisibleException( this.label() ) ;
        }
    }

    public boolean isVisible() {
        return this.isVisible( this.matcher ) ;
    }

    public BasicButton loginButton() {
        return new BasicButton(
                this.label() + " > loginButton",
                () -> withId( R.id.synapse_account_login_button )  ) ;
    }

    public BasicButton readMoreButton() {
        return new BasicButton(
                this.label() + " > readMoreButton",
                () -> withId( R.id.synapse_myuta_intro_more )  ) {

            public LazyString text() {
                return new LazyString( this.label(), () ->
                        UtaPassUtil.withIndex( allOf( withClassName( endsWith( "TextView" ) ),
                                                      isDescendantOfA( this.matcher().execute() ) ),
                                         0 ) ) ;
            }
        } ;
    }

    public LazyString savedSongs() {
        return new LazyString(
                this.label() + " > SavedSongs",
                () -> withId( R.id.synapse_myuta_info_used_count ) ) ;
    }

    public LazyString remainingQuotas() {
        return new LazyString(
                this.label() + " > RemainingQuotas",
                () -> withId( R.id.synapse_myuta_info_remaining_count ) ) ;
    }

    public InternalLineUp lineUp() {
        if (this.lineUp == null) {
            this.lineUp = new InternalLineUp( this.label() );
        }
        return this.lineUp;
    }

    public class InternalLineUp extends LineUpObject {

        public InternalLineUp( String label ) {
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.synapse_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( anyOf( withId( R.id.item_drawer_default_layout ),
                                 withId( R.id.item_drawer_store_layout ) ),
                          isCompletelyDisplayed() ) ;
        }

        public InternalCard card( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
            InternalCard card = new InternalCard() ;

            String label = String.format( "%s > MenuItem(%s)",
                    this.label(),
                    index ) ;

            card.cover( label + " > Cover",
                    () -> allOf(
                            withId( R.id.item_drawer_default_icon ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.title(  label + " > Title",
                    () -> allOf(
                            withId( R.id.item_drawer_default_section_title ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            card.subtitle( label + " > Subtitle",
                    () -> allOf(
                            withId( R.id.item_drawer_default_section_subtitle ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return card ;
        }
    }

    public class InternalCard implements ICover, ITitle, ISubtitle {

        String labelCover ;
        String labelTitle ;
        String labelSubtitle ;

        private LazyMatcher matcherCover ;
        private LazyMatcher matcherTitle ;
        private LazyMatcher matcherSubtitle ;

        public void cover( String label, LazyMatcher matcher ) {
            this.labelCover = label ;
            this.matcherCover = matcher ;
        }

        public BasicImage cover() {
            return new BasicImage( this.labelCover, this.matcherCover ) ;
        }

        public void title( String label, LazyMatcher matcher ) {
            this.labelTitle = label ;
            this.matcherTitle = matcher ;
        }

        public LazyString title() {
            return new LazyString( this.labelTitle, this.matcherTitle ) ;
        }

        public void subtitle( String label, LazyMatcher matcher ) {
            this.labelSubtitle = label ;
            this.matcherSubtitle = matcher ;
        }

        public LazyString subtitle() {
            return new LazyString( this.labelSubtitle, this.matcherSubtitle ) ;
        }
    }
}




