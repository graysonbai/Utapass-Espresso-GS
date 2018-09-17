package com.kddi.android.UtaPass.sqa_espresso.pages.stream ;

import android.support.test.espresso.ViewInteraction;
import android.view.MenuItem;
import android.view.View;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.LoginButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.stream.common.ReadMoreButton;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SideBarMenu extends ViewObject {

    private MenuLineUp menuLineUp ;
    private QuotaInfo quotaInfo ;

    public SideBarMenu() {
        this.item = onView( withId( R.id.main_navigation_view ) ) ;
    }

    public void _ready() {
        if( ! this.isVisible( this.item ) ) {
            new RuntimeException( "Sidebar Menu is not ready" ) ;
        }
    }

    public MenuLineUp lineUp() {
        if( this.menuLineUp == null ) {
            this.menuLineUp = new MenuLineUp() ;
        }
        return new MenuLineUp() ;
    }

    public QuotaInfo quotaInfo() {
        if( this.quotaInfo == null ) {
            this.quotaInfo = new QuotaInfo() ;
        }
        return this.quotaInfo ;
    }

    public class QuotaInfo extends ViewObject {

        private LoginButton loginButton ;
        private String promoteMessage ;
        private ReadMoreButton readMoreButton ;

//        private NicknameField nicknameField ;
//        private String userStatus ;
//        private String savedSongs ;
//        private String RemainingQuotas ;
//        private WhatIsMyUtaPlusButton whatIsMyUtaPlusButton ;

        public LoginButton loginButton() {
            if( this.loginButton == null ) {
                this.loginButton = new LoginButton() ;
            }
            return this.loginButton ;
        }

        public ReadMoreButton readMoreButton() {
            if( this.readMoreButton == null ) {
                this.readMoreButton = new ReadMoreButton() ;
            }
            return this.readMoreButton ;
        }

        public String savedSongs() {
            return this.getText( withId( R.id.synapse_myuta_info_used_count ) ) ;
        }

        public String remainingQuotas() {
            return this.getText( withId( R.id.synapse_myuta_info_remaining_count ) ) ;
        }
    }

    public SideBarMenuItem settingMenuItem() {
        this.lineUp().swipeToPosition( 0 ) ;
        return this.lineUp().menuItem( 0 ) ;
    }

    public class MenuLineUp extends LineUpObject {
        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.synapse_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return anyOf( withId( R.id.item_drawer_default_layout ),
                          withId( R.id.item_drawer_store_layout ) ) ;
        }

        public SideBarMenuItem menuItem( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;
            SideBarMenuItem item = new SideBarMenuItem() ;
            item.icon( this.matcherForIcon( indexInWindow ) ) ;
            item.title( this.getText( this.matcherForTitle( indexInWindow ) ) ) ;
            item.subtitle( this.getText( this.matcherForSubtitle( indexInWindow ) ) ) ;
            return item ;
        }

        private Matcher<View> matcherForIcon( int indexInWindow ) {
            return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_drawer_default_icon ),
                            isCompletelyDisplayed(),
                            isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
        }

        private Matcher<View> matcherForTitle( int indexInWindow ) {
            return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_drawer_default_section_title ),
                            isCompletelyDisplayed(),
                            isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
        }

        private Matcher<View> matcherForSubtitle( int indexInWindow ) {
            return UtaPassUtil.withIndex(
                    allOf( withId( R.id.item_drawer_default_section_subtitle ),
                            isCompletelyDisplayed(),
                            isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                    indexInWindow ) ;
        }
    }

    public class SideBarMenuItem extends ViewObject {
        private ViewInteraction icon ;
        private String title ;
        private String subtitle ;

        public void icon( Matcher<View> matcher ) {
            this.icon = onView( matcher ) ;
        }

        public void title( String title ) {
            this.title = title ;
        }

        public String title() {
            return this.title ;
        }

        public void subtitle( String subtitle ) {
            this.subtitle = subtitle ;
        }

        public String subtitle() {
            return this.subtitle ;
        }

        public void tap() {
            this.icon.perform( click() ) ;
        }
    }


}




