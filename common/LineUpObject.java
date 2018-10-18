package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.ViewInteraction ;
import android.view.View ;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.exceptions.NotReadyException;

import org.hamcrest.Matcher ;

import static android.support.test.espresso.Espresso.onView ;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition ;
import static android.support.test.espresso.matcher.ViewMatchers.* ;
import static org.hamcrest.Matchers.* ;


public abstract class LineUpObject extends ViewObject {

    private int UN_INIT = -1 ;
    protected int maxIndexOfLineUpObject = 9 ;
    protected int maxIndexOfWindow = this.UN_INIT ;
    private String label = "LineUp" ;

    public void _ready() {
        this.assertVisible() ;
    }

    public void assertVisible() {
        if( ! this.isVisible( this.getMatcherToCountMaxIndexOfWindow() ) ) {
            throw new NotReadyException( this.label() ) ;
        }
    }

    protected void addLabel( String label ) {
        this.label = String.format( "%s > %s", label, this.label() ) ;
    }

    protected String label() {
        return this.label ;
    }

    public <T extends LineUpObject> T swipeToLeftmost() {
        this.handleNoMatchViewException( this.label() ,
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
        return ( index >= this.getMaxIndexOfWindow() ) ? this.getMaxIndexOfWindow() : index ;
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

    public void setMaxIndexOfLineUpObject( int maxIndex ) {
        this.maxIndexOfLineUpObject = maxIndex ;
    }

    public int getMaxIndexOfLineUpObject() {
        return this.maxIndexOfLineUpObject ;
    }

    protected int getMaxIndexOfWindow() {
        if( this.maxIndexOfWindow == this.UN_INIT ) {
            this.maxIndexOfWindow = this.calculateMaxIndexOfWindow() ;
        }

        return this.maxIndexOfWindow ;
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

    public void resetMaxIndexOfWindow() {
        this.maxIndexOfWindow = this.UN_INIT ;
    }

    protected ViewInteraction getRecycleView() {
        return onView( this.getMatcherToFindRecycleView() ) ;
    }

    protected Matcher<View> getMatcherToFindRecycleView() {
        return allOf( withId( R.id.item_stream_list ),
                hasSibling( allOf(
                        withId( R.id.item_list_title_layout ),
                        withChild( anyOf(
                                withText( this.getTitleOfLineUpInEnglish() ),
                                withText( this.getTitleOfLineUpInJapanese() ) ) ) ) ) ) ;
    }

    protected abstract Matcher<View> getMatcherToCountMaxIndexOfWindow() ;
    protected String getTitleOfLineUpInEnglish() { return "" ; } ;
    protected String getTitleOfLineUpInJapanese() { return "" ; } ;
}


