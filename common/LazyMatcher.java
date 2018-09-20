package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.view.View;

import org.hamcrest.Matcher;

public interface LazyMatcher {
    Matcher<View> execute() ;
}