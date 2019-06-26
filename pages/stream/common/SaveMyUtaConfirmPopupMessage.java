package com.kddi.android.UtaPass.sqa_espresso.pages.stream.common ;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;
import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;
import com.kddi.android.UtaPass.sqa_espresso.common.ViewObject;

import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class SaveMyUtaConfirmPopupMessage extends ViewObject {

    public SaveMyUtaConfirmPopupMessage(){
        this.label( "Save MyUta Confirm Popup Message" );
    }

    public void _ready(){
        this.messageTitle().isVisible();
    }

    public LazyString messageTitle(){
        return new LazyString( this.label() + " > message Title",
                () -> withText( "ライブラリに保存しました") );
    }

    public LazyString messageContent(){
        return new LazyString( this.label() + " > message Title",
                () -> withText( "再生ボタンを押すと、いま保存したMyうたをすぐに再生できます。\n" + "「ライブラリ」＞「Myうた保存した楽曲」より、あとで再生することもできます。") );
    }

    public BasicButton closeButton(){
        return new BasicButton( this.label() + " > message Title",
                () -> allOf(
                        withId( R.id.myuta_saved_confirm),
                        isDescendantOfA( withId( android.R.id.content ) ) ) ){
            public void tap(){
                super.tap();
                UtaPassUtil.sleep( 3, "Ensure stability");
            }
        };
    }
}
