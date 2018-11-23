package com.kddi.android.UtaPass.sqa_espresso.common ;

import android.support.test.espresso.ViewInteraction;

@FunctionalInterface
public interface IMatcher {
    ViewInteraction execute() ;
}