package com.kddi.android.UtaPass.sqa_espresso.common.card_behavior ;

import com.kddi.android.UtaPass.sqa_espresso.common.BasicImage;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;

public interface ICover {
    void cover( String label, LazyMatcher matcher ) ;
    BasicImage cover() ;
}




