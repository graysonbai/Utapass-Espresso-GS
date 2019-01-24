package com.kddi.android.UtaPass.sqa_espresso.common.exceptions ;

import com.kddi.android.UtaPass.sqa_espresso.common.UtaPassUtil;

public class BasicException extends RuntimeException {
    public BasicException() {
    }

    public BasicException( String label ) {
        super( label ) ;

        UtaPassUtil.takeScreenshot(
                label.replace( " ", "" )
                     .replace( ">", "_" )
                     .replace( ":", "-" )
                     .replace( "(", "_" )
                     .replace( ")", "_" )
                     .replace( "=", "_" )
                     .replace( ",", "_" )
                     .replace( "'", "" )
                     .replaceAll( "[^\\w]", "_" )
                     .replaceAll( "[\\p{Katakana}]", "_" )
                     .replaceAll( "[\\p{Hiragana}]", "_" )
                     .replaceAll( "[\\p{sc=Han}]", "_" )
        ) ;
    }
}




