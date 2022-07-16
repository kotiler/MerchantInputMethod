package com.hit.wi.t9.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyImageView extends ImageView {
    private Context context;
    public ValueAnimator itsAnimator;

    public ViewGroup.LayoutParams itsLayoutParams;

    public MyImageView(Context context) {
        super(context);
        this.context = context;
    }
}
