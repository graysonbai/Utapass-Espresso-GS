package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class BasicSellingTrigger extends ViewObject {
    public BasicSellingTrigger(){
        this.label( "BasicSellingTrigger" );
    }

    public LazyString title(){
        return  new LazyString(this.label() + "",
                () -> allOf(
                        withId( R.id.view_lite_plan_selling_ads_title ),
                        withText( "聴き放題プラン\n" + "Myうたプラスで\n" + "うたパスを\n" + "もっと楽しめる"),
                        isDescendantOfA( withId( R.id.lite_plan_selling_ads_viewpager ) ) ) );
    }

    public LazyString subTitle(){
        return  new LazyString(this.label() + "",
                () -> allOf(
                        withId( R.id.view_lite_plan_selling_ads_content ),
                        withText( "初めてご利用の方は30日間無料！\n" + "アップグレードするとさらに\n" + "便利な機能が使えます。"),
                        isDescendantOfA( withId( R.id.lite_plan_selling_ads_viewpager ) ) ) );
    }

    public BasicButton upgradeButton(){
        return new BasicButton( this.label() + " > upgradeButton",
                () -> UtaPassUtil.withIndex( withId( R.id.lite_plan_selling_ads_confirm ), 0 ) ){
            public LazyString text() {
                return new LazyString( this.label(), () -> withId( R.id.lite_plan_selling_ads_confirm_title ) ) ;
            }
        };
    }

    public BasicButton closeButton(){
        return new BasicButton( this.label() + " > CloseButton",
                () -> UtaPassUtil.withIndex(
                        withId( R.id.lite_plan_selling_ads_close ), 0 ) );
    }

}
