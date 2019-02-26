package com.kddi.android.UtaPass.sqa_espresso.pages.stream.detail;

import android.support.test.espresso.ViewInteraction;

import com.kddi.android.UtaPass.R;
import com.kddi.android.UtaPass.sqa_espresso.common.BasicButton;
import com.kddi.android.UtaPass.sqa_espresso.pages.common.BasicPage;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class LiveDetailPage extends BasicPage {

    public LiveDetailPage(){
        this.label( "LiveDetailPage" );
    }

    public void _ready(){

    }

    private ViewInteraction getRecycleView( int position ) {
        return onView( withId( R.id.live_detail_recycler_view ) ).perform( scrollToPosition( position ));
    }

    public BasicButton onAirVideio() {
        this.getRecycleView(0);
        this.getRecycleView(3);
        this.getRecycleView(2);
        return new BasicButton(
                this.label() + "onAirVideio",
                () -> allOf(
                        withId(R.id.item_live_program_play),
                        isDescendantOfA(withId(R.id.item_live_preview_layout))));
    }
}
