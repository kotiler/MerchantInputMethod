package com.hit.wi.t9.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyTextView extends TextView {
    private Context context;
    public ValueAnimator itsAnimator;

    public ViewGroup.LayoutParams itsLayoutParams;

    public MyTextView(Context context) {
        super(context);
        this.context = context;
    }
}
