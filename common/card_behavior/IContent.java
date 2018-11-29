package com.kddi.android.UtaPass.sqa_espresso.common.card_behavior ;

import com.kddi.android.UtaPass.sqa_espresso.common.LazyMatcher;
import com.kddi.android.UtaPass.sqa_espresso.common.LazyString;

public interface IContent {
    void content( String label, LazyMatcher matcher ) ;
    LazyString content() ;
}




