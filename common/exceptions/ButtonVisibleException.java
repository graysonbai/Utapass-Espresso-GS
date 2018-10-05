package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class ButtonVisibleException extends RuntimeException {
    public ButtonVisibleException( String buttonName ) {
        super( buttonName ) ;

        UtaPassUtil.takeScreenshot( this.getClass().getSimpleName() ) ;
    }
}




