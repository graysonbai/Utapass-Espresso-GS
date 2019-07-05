package com.kddi.android.UtaPass.sqa_espresso.pages.library.favorite;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

public class EmptyFavoritePage extends BasicPage {

    public EmptyFavoritePage(){
        this.label( "EmptyMyUtaPage" );
    }

    public LazyString title(){
        return new LazyString( this.label() + " > title",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.view_no_like_songs_title ), 0 ),
                        anyOf(
                                withText( "No Favorite Music" ),
                                withText( "お気に入りがありません" ) ),
                        isDescendantOfA( withId( R.id.view_no_like_songs_layout ) ) ) );
    }

    public LazyString content(){
        return new LazyString( this.label() + " > content",
                () -> allOf(
                        UtaPassUtil.withIndex( withId( R.id.view_no_like_songs_content ),0 ),
                        anyOf(
                                withText( "Discover music through Stream and add to favorite!" ),
                                withText( "聴き放題や再生画面からお気に入りの楽曲を登録しましょう！" ) ),
                        isDescendantOfA( withId( R.id.view_no_like_songs_layout ) ) ) );
    }
}
