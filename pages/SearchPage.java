package com.kddi.android.UtaPass.sqa_espresso.pages ;

import android.view.View;

import com.kddi.android.UtaPass.R ;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicTextField;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.LineUpObject;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.IContent;
import com.kddi.android.UtaPass.sqa_espresso.common.card_behavior.ISongName;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId ;
import static org.hamcrest.Matchers.allOf;


public class SearchPage extends BasicPage {
    private InternalLineUp lineUp ;

    public SearchPage() {
        this.label( "SearchPage" );
    }

    public void _ready() {

    }

    public BasicTextField searchBar(){
        return new BasicTextField( this.label() + " > SearchButton",
                () -> allOf(
                        withId( R.id.search_src_text ),
                        isDescendantOfA( withId( R.id.search_plate ) ) ) );
    }

    public BasicButton a1(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 0 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a2(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 1 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a3(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 2 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a4(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 3 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a5(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 4 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a6(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 5 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a7(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 6 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a8(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 7 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a9(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 8 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a10(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 9 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a11(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 10 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
    }

    public BasicButton a12(){
        return new BasicButton( this.label() + " > ",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.item_category_layout), 11 ),
                        isDescendantOfA( withId(R.id.item_stream_list ) ) ) );
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
            for( int i = 0 ; i <= this.getMaxIndexOfLineUpObject(); i++ ) {
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

            searResult.content(label + " > SongName",
                    () -> allOf(
                            withId( R.id.search_autocomplete_text ),
                            isDescendantOfA( UtaPassUtil.withIndex(
                                    this.getMatcherToCountMaxIndexOfWindow(),
                                    indexInWindow ) ) ) ) ;

            return searResult ;
        }
    }

    public class Internallist implements IContent {

        String labelSongName ;

        private LazyMatcher matcherSongName ;

        public void content( String label, LazyMatcher matcher ) {
            this.labelSongName = label;
            this.matcherSongName = matcher;
        }

        public LazyString content() {
            return new LazyString( this.labelSongName, this.matcherSongName ) ;
        }
    }
}
