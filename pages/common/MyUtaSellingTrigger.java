package com.kddi.android.UtaPass.sqa_espresso.pages.common;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

public class MyUtaSellingTrigger extends ViewObject {
    public MyUtaSellingTrigger(){
        this.label( "MyUtaSellingTrigger" );
    }

    public LazyString title(){
        return new LazyString( this.label() + " > Title",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "聴き放題プラン Myうたプラス" ) ) );
    }

    public LazyString subtitle(){
        return new LazyString( this.label() + " > Sub Title",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "初めてご利用の方は30日間無料！" ) ) );
    }

    public LazyString description(){
        return new LazyString( this.label() + " > Content Description",
                () -> allOf(
                        withClassName( endsWith( "TextView" ) ),
                        withText( "「Myうた」で聴き放題のプレイリストの中から、お好きな楽曲を毎月10曲保存して、いつでもどこでも聴くことができます。" ) ) );
    }

    public BasicButton detailButton(){
        return new BasicButton( this.label() + " > DetailButton",
                () -> allOf(
                        withId( R.id.myuta_ads_more ),
                        isDescendantOfA( withId( R.id.view_my_uta_selling_trigger_layout ) ) ) );
    }

    public BasicButton experienceButton(){
        return new BasicButton( this.label() + " > ExperienceButton",
                () -> allOf(
                        withId( R.id.myuta_ads_confirm ),
                        isDescendantOfA( withId( R.id.view_my_uta_selling_trigger_layout ) ) ) ){
            public LazyString text(){
                return new LazyString(
                        this.label(),
                        () -> allOf(
                                withId( R.id.myuta_ads_confirm_title ),
                                isDescendantOfA( withId(R.id.myuta_ads_confirm ) ) ) );
            }
        };
    }

    public BasicButton closeButton(){
        return new BasicButton( this.label() + " > CloseButton",
                () -> UtaPassUtil.withIndex( withId( R.id.myuta_ads_close ),0  ) );
    }
}
