package com.kddi.android.UtaPass.sqa_espresso.common ;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target( ElementType.METHOD )
@Retention( RUNTIME )
public @interface TestRailId {
    String[] value() default "" ;
}
