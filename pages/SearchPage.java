package com.kddi.android.UtaPass.sqa_espresso.pages ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicTextField;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IRecommendString;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;
import com.kddi.android.UtaPass.sqa_espresso.pages.search.SearchStreamPanel;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.allOf;


public class SearchPage extends BasicPage {
    private InternalLineUp lineUp ;

    public SearchPage() {
        this.label( "SearchPage" ) ;
    }

    public void _ready() {
        this.searchBar().assertVisible() ;
    }

    public SearchStreamPanel searchStreamPanel(){
        return new SearchStreamPanel( this.label() );
    }

    public BasicTextField searchBar(){
        return new BasicTextField( this.label() + " > SearchBar",
                () -> allOf(
                        withId( R.id.search_src_text ),
                        isDescendantOfA( withId( R.id.search_plate ) ) ) ) ;
    }

    public BasicButton Categories1(){
        return new BasicButton( this.label() + " > Categories1",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 0 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories2(){
        return new BasicButton( this.label() + " > Categories2",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 1 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories3(){
        return new BasicButton( this.label() + " > Categories3",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 2 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories4(){
        return new BasicButton( this.label() + " > Categories4",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 3 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories5(){
        return new BasicButton( this.label() + " > Categories5",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 4 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories6(){
        return new BasicButton( this.label() + " > Categories6",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 5 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories7(){
        return new BasicButton( this.label() + " > Categories7",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 6 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories8(){
        return new BasicButton( this.label() + " > Categories8",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 7 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories9(){
        return new BasicButton( this.label() + " > Categories9",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 8 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories10(){
        return new BasicButton( this.label() + " > Categories10",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 9 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories11(){
        return new BasicButton( this.label() + " > Categories11",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 10 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public BasicButton Categories12(){
        return new BasicButton( this.label() + " > Categories12",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 11 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) ) ;
    }

    public InternalLineUp lineUp() {
        if( this.lineUp == null ) {
            this.lineUp = new InternalLineUp( this.label() ) ;
        }
        return this.lineUp ;
    }


    public class InternalLineUp extends LineUpObject {

        public InternalLineUp(  String label ) {
            this.setMaxIndexOfLineUpObject( 12 ) ;
            this.label( label + " > LineUp" ) ;
        }

        protected Matcher<View> getMatcherToFindRecycleView() {
            return withId( R.id.search_recycler_view ) ;
        }

        protected Matcher<View> getMatcherToCountMaxIndexOfWindow() {
            return allOf( withId( R.id.search_autocomplete_root_layout ),
                    isCompletelyDisplayed(),
                    isDescendantOfA( this.getMatcherToFindRecycleView() ) ) ;
        }

        protected int calculateMaxIndexOfWindow() {
            int count = -1 ;
            for( int i = 0 ; i <= this.getMaxIndexOfLineUpObject() ; i++ ) {
                if( ! this.isDisplayedCompletely(
                        UtaPassUtil.withIndex( this.getMatcherToCountMaxIndexOfWindow(), i ) ) ) {
                    return count ;
                }

                count++ ;
            }

            return count ;
        }

        protected int swipeToCardViewAndGetIndexOfWindow( int index ) {
            this.swipeToPosition( 1 ) ;

            if( index <= this.maxIndexFirstWindow() ) {
                return index ;
            }

            this.swipeToPosition( index + 2 ) ;
            return this.maxIndexOtherWindow() ;
        }

        public Internallist searchResult( int index ) {
            int indexInWindow = this.swipeToCardViewAndGetIndexOfWindow( index ) ;

            Internallist searResult = new Internallist() ;

            String label = String.format( "%s > Card(%s)",
                    this.label(),
                    index ) ;

            searResult.recommendString(label + " > SongName",
                    () -> allOf(
                            withId( R.id.search_autocomplete_text ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return searResult ;
        }
    }

    public class Internallist implements IRecommendString {

        String labelSongName ;

        private LazyMatcher matcherSongName ;

        public void recommendString( String label, LazyMatcher matcher ) {
            this.labelSongName = label;
            this.matcherSongName = matcher;
        }

        public LazyString recommendString() {
            return new LazyString( this.labelSongName, this.matcherSongName ) ;
        }
    }
}
