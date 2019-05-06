package com.kddi.android.UtaPass.sqa_espresso.pages.library.myuta;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anyOf;

public class EmptyMyUtaPage extends ViewObject {
    public EmptyMyUtaPage(){
        this.label( "EmptyMyUtaPage" );
    }

    public LazyString title(){
        return new LazyString( this.label() + " > title",
                () -> allOf(
                        withId( R.id.view_empty_myuta_title ),
                        anyOf(
                                withText( "No downloaded My Uta songs" ),
                                withText( "ダウンロードされた\n" + "Myうたがありません" ) ),
                        isDescendantOfA( withId( R.id.view_empty_myuta_layout ) ) ) );
    }

    public LazyString content(){
        return new LazyString( this.label() + " > content",
                () -> allOf(
                        withId( R.id.view_empty_myuta_content ),
                        anyOf(
                                withText( "Find music through Stream and save it to My Uta, or redownload from My Uta history"),
                                withText( "「聴き放題」または、「Myうた一覧」からダウンロードできます" ) ),
                        isDescendantOfA( withId( R.id.view_empty_myuta_layout ) ) ) );
    }
}
