package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.InvisibleException;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;


public abstract class LineUpObject extends ViewObject {
    private final int UN_INIT = -1 ;

    protected int maxIndexOfLineUpObject = 9 ;
    protected int maxIndexFirstWindow = this.UN_INIT ;
    protected int maxIndexOtherWindow = this.UN_INIT ;

    public LineUpObject() {
        this.label( "LineUp" ) ;
    }

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible( this.getMatcherToFindRecycleView() ) ) {
            throw new InvisibleException( this.label() ) ;
        }
    }

    public <T extends LineUpObject> T swipeToLeftmost() {
        this.handleException(
                () -> this.getRecycleView().perform( scrollToPosition( 0 ) ) ) ;

        return (T) this ;
    }

    public <T extends LineUpObject> T swipeToPosition( int position ) {
        this.getRecycleView().perform( scrollToPosition( position ) ) ;
        return (T) this ;
    }

    protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
        this.swipeToLeftmost() ;
        this.checkIndexValid( index ) ;
        this.swipeToPosition( index ) ;
        return ( index <= this.maxIndexFirstWindow() ) ? index : this.maxIndexOtherWindow() ;
    }

    protected void checkIndexValid( int index ) {
        if( index > this.getMaxIndexOfLineUpObject() ) {
            String msg = String.format(
                    "IndexExceeding: index = '%s', MAX = '%s'",
                    index,
                    this.getMaxIndexOfLineUpObject() ) ;

            throw new RuntimeException( msg ) ;
        }
    }

    public void resetMaxIndexOfWindow() {
        this.maxIndexFirstWindow = this.UN_INIT ;
        this.maxIndexOtherWindow = this.UN_INIT ;
    }

    public int maxIndexFirstWindow() {
        if( this.maxIndexFirstWindow == this.UN_INIT ) {
            this.maxIndexFirstWindow = this.calculateMaxIndexOfWindow() ;
        }
        return this.maxIndexFirstWindow ;
    }

    public int maxIndexOtherWindow() {
        if( this.maxIndexOtherWindow == this.UN_INIT ) {
            this.swipeToPosition( this.maxIndexFirstWindow() + 2 ) ;
            this.maxIndexOtherWindow = this.calculateMaxIndexOfWindow() ;
        }
        return this.maxIndexOtherWindow ;
    }

    public void setMaxIndexOfLineUpObject( int maxIndex ) {
        this.maxIndexOfLineUpObject = maxIndex ;
    }

    public int getMaxIndexOfLineUpObject() {
        return this.maxIndexOfLineUpObject ;
    }

    protected int calculateMaxIndexOfWindow() {
        boolean isVisible ;
        for( int i = this.getMaxIndexOfLineUpObject(); i >= 0; i-- ) {
            isVisible = this.isVisible(
                    UtaPassUtil.withIndex(
                        allOf( this.getMatcherToCountMaxIndexOfWindow(),
                               isDescendantOfA( this.getMatcherToFindRecycleView() ) ),
                        i ) ) ;

            if( isVisible ) {
                return i ;
            }
        }

        return this.getMaxIndexOfLineUpObject() ;
    }

    protected ViewInteraction getRecycleView() {
        return this.handleExceptionWhenMatching(
                () -> onView( this.getMatcherToFindRecycleView() ) ) ;
    }

    protected Matcher<View> getMatcherToFindRecycleView() {
        return allOf(
                withId( R.id.item_stream_list ),
                hasSibling( allOf(
                        withId( R.id.item_list_title_layout ),
                        hasDescendant( anyOf(
                                withText( this.getTitleOfLineUpInEnglish() ),
                                withText( this.getTitleOfLineUpInJapanese() ) ) ) ) ) ) ;
    }

    protected abstract Matcher<View> getMatcherToCountMaxIndexOfWindow() ;
    protected String getTitleOfLineUpInEnglish() { return "" ; }
    protected String getTitleOfLineUpInJapanese() { return "" ; }
}


