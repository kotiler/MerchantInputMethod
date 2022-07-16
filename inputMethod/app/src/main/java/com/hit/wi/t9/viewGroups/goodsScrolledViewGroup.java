package com.hit.wi.t9.viewGroups;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.hit.wi.t9.Business.util.ImageUtils;
import com.hit.wi.t9.Business.util.ImageUtils;
import com.hit.wi.t9.R;
import com.hit.wi.t9.SoftKeyboard;
import com.hit.wi.t9.values.Global;
import com.hit.wi.t9.values.SkinInfoManager;
import com.hit.wi.t9.view.MyImageView;
import com.hit.wi.t9.view.MyTextView;
import com.hit.wi.t9.view.QuickButton;
import com.hit.wi.util.ViewsUtil;


/**
 * Created by Administrator on 2015/5/20.
 */
public class goodsScrolledViewGroup {
    protected ViewGroup parentViewGroup;
    protected Context context;
    protected SkinInfoManager skinInfoManager = SkinInfoManager.getSkinInfoManagerInstance();

    public ScrollView scrollView;
    public FrameLayout.LayoutParams innerLayoutParams;
    public LinearLayout.LayoutParams outerLayoutParams;
    protected LinearLayout layoutforWrapGoods;
    protected Resources res;
    protected int buttonpadding = 0;
    protected SoftKeyboard softKeyboard;
    protected Typeface typeface;
    protected MyTextView goodsName;
    protected MyTextView goodsDesc;
    protected MyTextView goodsPrice;
    protected MyImageView goodsImage;
    protected QuickButton buttonImage;
    protected QuickButton buttonDesc;
    protected QuickButton buttonName;
    protected QuickButton buttonWords;
    protected MyTextView emptyText1;
    protected MyTextView emptyText2;
    protected MyTextView emptyText3;
    protected MyTextView emptyButton1;
    protected MyTextView emptyButton2;
    protected MyTextView emptyButton3;
    protected MyTextView emptyButton4;
    protected MyTextView emptyButton5;

    protected LinearLayout goodsAll;
    protected LinearLayout goodsInfo;
    protected LinearLayout goodsText;
    protected LinearLayout goodsButton;

    protected int width;
    protected int height;

    public goodsScrolledViewGroup() {
        super();
    }

    public void setSoftKeyboard(SoftKeyboard softKeyboard8) {
        this.softKeyboard = softKeyboard8;
    }

    public void setButtonTextSize(float size) {
        buttonImage.getPaint().setTextSize(size);
        buttonDesc.getPaint().setTextSize(size);
        buttonName.getPaint().setTextSize(size);
        buttonWords.getPaint().setTextSize(size);
    }
    public void setNameTextSize(float size) {
        goodsName.getPaint().setTextSize(size);
    }
    public void setDescTextSize(float size) {
        goodsDesc.getPaint().setTextSize(size);
    }
    public void setPriceTextSize(float size) {
        goodsPrice.getPaint().setTextSize(size);
    }
    public void setEmptyTextTextSize(float size) {
         emptyText1.getPaint().setTextSize(size);
         emptyText2.getPaint().setTextSize(size);
         emptyText3.getPaint().setTextSize(size);
    }


    public void setButtonTextColor(int color) {
        buttonImage.setTextColor(color);
        buttonDesc.setTextColor(color);
        buttonName.setTextColor(color);
        buttonWords.setTextColor(color);
    }
    public void setNameTextColor(int color) {
        //goodsName.setTextColor(color);
    }
    public void setDescTextColor(int color) {
        //goodsDesc.setTextColor(color);
    }
    public void setPriceTextColor(int color) {
        //goodsPrice.setTextColor(color);
    }


    public void setButtonTypeface(Typeface typeface) {
        this.typeface = typeface;
        buttonImage.setTypeface(typeface);
        buttonDesc.setTypeface(typeface);
        buttonName.setTypeface(typeface);
        buttonWords.setTypeface(typeface);
    }
    public void setNameTypeface(Typeface typeface) {
        this.typeface = typeface;
        goodsName.setTypeface(typeface);
    }
    public void setDescTypeface(Typeface typeface) {
        this.typeface = typeface;
        goodsDesc.setTypeface(typeface);
    }
    public void setPriceTypeface(Typeface typeface) {
        this.typeface = typeface;
        goodsPrice.setTypeface(typeface);
    }


    public void setButtonBackgroundColor(int color) {
        ViewsUtil.setBackgroundWithGradientDrawable(buttonImage, color);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonDesc, color);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonName, color);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonWords, color);
    }
    public void setNameBackgroundColor(int color) {
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsName, color);
    }
    public void setDescBackgroundColor(int color) {
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsDesc, color);
    }
    public void setPriceBackgroundColor(int color) {
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsPrice, color);
    }
    public void setImageBackgroundColor(int color) {
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsImage, color);
    }

    public void setButtonBackgroundAlpha(int alpha) {
        buttonImage.getBackground().setAlpha(alpha);
        buttonDesc.getBackground().setAlpha(alpha);
        buttonName.getBackground().setAlpha(alpha);
        buttonWords.getBackground().setAlpha(alpha);
    }
    public void setNameBackgroundAlpha(int alpha) {
        //goodsName.getBackground().setAlpha(alpha);
    }
    public void setDescBackgroundAlpha(int alpha) {
        //goodsDesc.getBackground().setAlpha(alpha);
    }
    public void setPriceBackgroundAlpha(int alpha) {
        //goodsPrice.getBackground().setAlpha(alpha);
    }
    public void setImageBackgroundAlpha(int alpha) {
        //goodsImage.getBackground().setAlpha(alpha);
    }
    public void setBehindBackgroundAlpha(int alpha) {
        goodsAll.getBackground().setAlpha(alpha);
        //goods.getBackground().setAlpha(alpha);
        //goodsText.getBackground().setAlpha(alpha);
        //goodsButton.getBackground().setAlpha(alpha);
        //btnImage.getBackground().setAlpha(alpha);
        //btnDesc.getBackground().setAlpha(alpha);
        //btnName.getBackground().setAlpha(alpha);
    }

    public void setBackgroundAlpha(int alpha) {
        setButtonBackgroundAlpha(alpha);
        setNameBackgroundAlpha(alpha);
        setDescBackgroundAlpha(alpha);
        setPriceBackgroundAlpha(alpha);
        setImageBackgroundAlpha(alpha);
        setBehindBackgroundAlpha(alpha);
    }


    public void setButtonBackgroundResource(int resource) {
        buttonImage.setBackgroundResource(resource);
        buttonDesc.setBackgroundResource(resource);
        buttonName.setBackgroundResource(resource);
        buttonWords.setBackgroundResource(resource);
    }
    public void setNameBackgroundResource(int resource) {
        //goodsName.setBackgroundResource(resource);
    }
    public void setDescBackgroundResource(int resource) {
        //goodsDesc.setBackgroundResource(resource);
    }
    public void setPriceBackgroundResource(int resource) {
        //goodsPrice.setBackgroundResource(resource);
    }
    public void setImageBackgroundResource(int resource) {
        //goodsImage.setBackgroundResource(resource);
    }


    @SuppressLint("NewApi")
    public void setButtonAlpha(float alpha) {
        buttonImage.setAlpha(alpha);
        buttonDesc.setAlpha(alpha);
        buttonName.setAlpha(alpha);
        buttonWords.setAlpha(alpha);
    }
    @SuppressLint("NewApi")
    public void setNameAlpha(float alpha) {
        //goodsName.setAlpha(alpha);
    }
    @SuppressLint("NewApi")
    public void setDescAlpha(float alpha) {
        //goodsDesc.setAlpha(alpha);
    }
    @SuppressLint("NewApi")
    public void setPriceAlpha(float alpha) {
        //goodsPrice.setAlpha(alpha);
    }
    @SuppressLint("NewApi")
    public void setImageAlpha(float alpha) {
        //goodsImage.setAlpha(alpha);
    }
    @SuppressLint("NewApi")
    public void setBehindAlpha(float alpha) {
        goodsAll.setAlpha(alpha);
        //goods.setAlpha(alpha);
        //goodsText.setAlpha(alpha);
        //goodsButton.setAlpha(alpha);
        //btnImage.setAlpha(alpha);
        //btnDesc.setAlpha(alpha);
        //btnName.setAlpha(alpha);
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        outerLayoutParams.width = width;
        outerLayoutParams.height = height;
        innerLayoutParams.width = width;
        innerLayoutParams.height = height;
        updateViewLayout();
    }

    protected void updateButtonSkin(int textColor, int backgroundColor) {
        buttonImage.setTextColor(textColor);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonImage, backgroundColor);
        buttonImage.getBackground().setAlpha(Global.getCurrentAlpha());

        buttonDesc.setTextColor(textColor);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonDesc, backgroundColor);
        buttonDesc.getBackground().setAlpha(Global.getCurrentAlpha());

        buttonName.setTextColor(textColor);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonName, backgroundColor);
        buttonName.getBackground().setAlpha(Global.getCurrentAlpha());

        buttonWords.setTextColor(textColor);
        ViewsUtil.setBackgroundWithGradientDrawable(buttonWords, backgroundColor);
        buttonWords.getBackground().setAlpha(Global.getCurrentAlpha());
    }
    protected void updateNameSkin(int textColor, int backgroundColor) {
        goodsName.setTextColor(textColor);
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsName, backgroundColor);
        //goodsName.getBackground().setAlpha(Global.getCurrentAlpha());
    }
    protected void updateDescSkin(int textColor, int backgroundColor) {
        goodsDesc.setTextColor(textColor);
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsDesc, backgroundColor);
        //goodsDesc.getBackground().setAlpha(Global.getCurrentAlpha());
    }
    protected void updatePriceSkin(int textColor, int backgroundColor) {
        goodsPrice.setTextColor(textColor);
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsPrice, backgroundColor);
        //goodsPrice.getBackground().setAlpha(Global.getCurrentAlpha());
    }
    protected void updateImageSkin(int backgroundColor) {
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsImage, backgroundColor);
        //goodsImage.getBackground().setAlpha(Global.getCurrentAlpha());
    }
    protected void updateBehindSkin(int backgroundColor) {
        ViewsUtil.setBackgroundWithGradientDrawable(goodsAll, backgroundColor);
        goodsAll.getBackground().setAlpha(Global.getCurrentAlpha());

        /*ViewsUtil.setBackgroundWithGradientDrawable(goods, backgroundColor);
        goods.getBackground().setAlpha(Global.getCurrentAlpha());

        ViewsUtil.setBackgroundWithGradientDrawable(goodsText, backgroundColor);
        goodsText.getBackground().setAlpha(Global.getCurrentAlpha());

        ViewsUtil.setBackgroundWithGradientDrawable(goodsButton, backgroundColor);
        goodsButton.getBackground().setAlpha(Global.getCurrentAlpha());

        ViewsUtil.setBackgroundWithGradientDrawable(btnImage, backgroundColor);
        btnImage.getBackground().setAlpha(Global.getCurrentAlpha());

        ViewsUtil.setBackgroundWithGradientDrawable(btnDesc, backgroundColor);
        btnDesc.getBackground().setAlpha(Global.getCurrentAlpha());

        ViewsUtil.setBackgroundWithGradientDrawable(btnName, backgroundColor);
        btnName.getBackground().setAlpha(Global.getCurrentAlpha());*/
    }

    public void setHeight(int height) {
        this.height = height;
        outerLayoutParams.height = height;
        innerLayoutParams.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
        outerLayoutParams.width = width;
        innerLayoutParams.width = width;
        updateViewLayout();
    }

    public void setPosition(int x, int y) {
        outerLayoutParams.leftMargin = x;
        outerLayoutParams.topMargin = y;
    }

    public void addThisToView(ViewGroup viewGroup) {
        parentViewGroup = viewGroup;
        parentViewGroup.addView(scrollView, outerLayoutParams);
    }

    public void setVisibility(int visibility) {
        scrollView.setVisibility(visibility);
        buttonImage.clearAnimation();
        buttonImage.setVisibility(visibility);
        buttonDesc.clearAnimation();
        buttonDesc.setVisibility(visibility);
        buttonName.clearAnimation();
        buttonName.setVisibility(visibility);
        buttonWords.clearAnimation();
        buttonWords.setVisibility(visibility);
        layoutforWrapGoods.setVisibility(visibility);
        goodsName.clearAnimation();
        goodsName.setVisibility(visibility);
        emptyText1.clearAnimation();
        emptyText1.setVisibility(visibility);
        emptyText2.clearAnimation();
        emptyText2.setVisibility(visibility);
        emptyText3.clearAnimation();
        emptyText3.setVisibility(visibility);
        emptyButton1.clearAnimation();
        emptyButton1.setVisibility(visibility);
        emptyButton2.clearAnimation();
        emptyButton2.setVisibility(visibility);
        emptyButton3.clearAnimation();
        emptyButton3.setVisibility(visibility);
        emptyButton4.clearAnimation();
        emptyButton4.setVisibility(visibility);
        emptyButton5.clearAnimation();
        emptyButton5.setVisibility(visibility);
        goodsDesc.clearAnimation();
        goodsDesc.setVisibility(visibility);
        goodsPrice.clearAnimation();
        goodsPrice.setVisibility(visibility);
        goodsImage.clearAnimation();
        goodsImage.setVisibility(visibility);

        goodsAll.clearAnimation();
        goodsAll.setVisibility(visibility);
        goodsInfo.clearAnimation();
        goodsInfo.setVisibility(visibility);
        goodsText.clearAnimation();
        goodsText.setVisibility(visibility);
        goodsButton.clearAnimation();
        goodsButton.setVisibility(visibility);
        updateViewLayout();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void clearAnimation() {
        buttonImage.clearAnimation();
        buttonDesc.clearAnimation();
        buttonName.clearAnimation();
        buttonWords.clearAnimation();
        goodsName.clearAnimation();
        emptyText1.clearAnimation();
        emptyText2.clearAnimation();
        emptyText3.clearAnimation();
        emptyButton1.clearAnimation();
        emptyButton2.clearAnimation();
        emptyButton3.clearAnimation();
        emptyButton4.clearAnimation();
        emptyButton5.clearAnimation();
        goodsDesc.clearAnimation();
        goodsPrice.clearAnimation();
        goodsImage.clearAnimation();
        goodsAll.clearAnimation();
        goodsInfo.clearAnimation();
        goodsText.clearAnimation();
        goodsButton.clearAnimation();
    }

    private Animation.AnimationListener getClearAnimationListener(final View v) {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }


    public void startAnimation(Animation animation) {
        buttonImage.startAnimation(animation);
        buttonDesc.startAnimation(animation);
        buttonName.startAnimation(animation);
        buttonWords.startAnimation(animation);
        goodsName.startAnimation(animation);
        emptyText1.startAnimation(animation);
        emptyText2.startAnimation(animation);
        emptyText3.startAnimation(animation);
        emptyButton1.startAnimation(animation);
        emptyButton2.startAnimation(animation);
        emptyButton3.startAnimation(animation);
        emptyButton4.startAnimation(animation);
        emptyButton5.startAnimation(animation);
        goodsDesc.startAnimation(animation);
        goodsPrice.startAnimation(animation);
        goodsImage.startAnimation(animation);
        goodsAll.startAnimation(animation);
        goodsInfo.startAnimation(animation);
        goodsText.startAnimation(animation);
        goodsButton.startAnimation(animation);
    }

    public void startAnimation(int anim) {
        buttonImage.startAnimation(AnimationUtils.loadAnimation(context, anim));
        buttonDesc.startAnimation(AnimationUtils.loadAnimation(context, anim));
        buttonName.startAnimation(AnimationUtils.loadAnimation(context, anim));
        buttonWords.startAnimation(AnimationUtils.loadAnimation(context, anim));

        goodsName.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsDesc.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsPrice.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsImage.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsAll.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsInfo.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsText.startAnimation(AnimationUtils.loadAnimation(context, anim));
        goodsButton.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyText1.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyText2.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyText3.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyButton1.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyButton2.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyButton3.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyButton4.startAnimation(AnimationUtils.loadAnimation(context, anim));
        emptyButton5.startAnimation(AnimationUtils.loadAnimation(context, anim));
    }


    public boolean isShown() {
        boolean ans = false;
        ans |= buttonImage.isShown();
        ans |= buttonDesc.isShown();
        ans |= buttonName.isShown();
        ans |= buttonWords.isShown();

        ans |= goodsName.isShown();
        ans |= goodsDesc.isShown();
        ans |= goodsPrice.isShown();
        ans |= goodsImage.isShown();

        ans |= goodsAll.isShown();
        ans |= goodsInfo.isShown();
        ans |= goodsText.isShown();
        ans |= goodsButton.isShown();
        ans |= emptyText1.isShown();
        ans |= emptyText2.isShown();
        ans |= emptyText3.isShown();

        ans |= emptyButton1.isShown();
        ans |= emptyButton2.isShown();
        ans |= emptyButton3.isShown();
        ans |= emptyButton4.isShown();
        ans |= emptyButton5.isShown();
        return ans;
    }


    public void hide() {
        clearAnimation();
        setVisibility(View.GONE);
    }


    public void show() {
        clearAnimation();
        setVisibility(View.VISIBLE);
    }


    public void setButtonSize(int width, int height) {
        buttonImage.itsLayoutParams.height = height;
        buttonImage.itsLayoutParams.width = width;
        buttonDesc.itsLayoutParams.height = height;
        buttonDesc.itsLayoutParams.width = width;
        buttonName.itsLayoutParams.height = height;
        buttonName.itsLayoutParams.width = width;
        buttonWords.itsLayoutParams.height = height;
        buttonWords.itsLayoutParams.width = width;

        float textSize = 2 * Global.textsizeFactor * Math.min(width, height) / 5;
        setButtonTextSize(textSize);
    }
    public void setNameSize(int width, int height) {
        goodsName.itsLayoutParams.height = height;
        goodsName.itsLayoutParams.width = width;
        float textSize = 2 * Global.textsizeFactor * Math.min(width, height) / 5;
        setNameTextSize(textSize);
    }
    public void setDescSize(int width, int height) {
        goodsDesc.itsLayoutParams.height = height;
        goodsDesc.itsLayoutParams.width = width;
        float textSize = 2 * Global.textsizeFactor * Math.min(width, height) / 5;
        setDescTextSize(textSize);
    }
    public void setPriceSize(int width, int height) {
        goodsPrice.itsLayoutParams.height = height;
        goodsPrice.itsLayoutParams.width = width;
        float textSize = 2 * Global.textsizeFactor * Math.min(width, height) / 5;
        setPriceTextSize(textSize);
    }
    public void setImage(int width, int height) {
        goodsName.itsLayoutParams.height = height;
        goodsName.itsLayoutParams.width = width;
    }


    public void setButtonPadding(int padding) {
        buttonpadding = padding;
        ((LinearLayout.LayoutParams) buttonImage.itsLayoutParams).leftMargin = padding;
        ((LinearLayout.LayoutParams) buttonDesc.itsLayoutParams).leftMargin = padding;
        ((LinearLayout.LayoutParams) buttonName.itsLayoutParams).leftMargin = padding;
        ((LinearLayout.LayoutParams) buttonWords.itsLayoutParams).leftMargin = padding;
        ((LinearLayout.LayoutParams) buttonImage.itsLayoutParams).leftMargin = 0;
    }
    public void setNamePadding(int padding) {
        ((LinearLayout.LayoutParams) goodsName.itsLayoutParams).leftMargin = padding;
    }
    public void setDescPadding(int padding) {
        ((LinearLayout.LayoutParams) goodsDesc.itsLayoutParams).leftMargin = padding;
    }
    public void setPricePadding(int padding) {
        ((LinearLayout.LayoutParams) goodsPrice.itsLayoutParams).leftMargin = padding;
    }
    public void setImagePadding(int padding) {
        ((LinearLayout.LayoutParams) goodsImage.itsLayoutParams).leftMargin = padding;
    }


    public void setShadowLayer(int radius, int color) {
        if (Global.shadowSwitch){
            /*buttonImage.setShadowLayer(radius, 0, 0, color);
            buttonDesc.setShadowLayer(radius, 0, 0, color);
            buttonName.setShadowLayer(radius, 0, 0, color);*/
            goodsName.setShadowLayer(radius, 0, 0, color);
            goodsDesc.setShadowLayer(radius, 0, 0, color);
            goodsPrice.setShadowLayer(radius, 0, 0, color);
        }
    }

    protected QuickButton createButton(String text) {
        QuickButton button = new QuickButton(context);
        button.setGravity(Gravity.CENTER);
        button.setId(Global.generateViewId());
        button.setTypeface(typeface);
        button.setText(text);
        button.setVisibility(View.GONE);
        button.setBackgroundResource(R.drawable.button_goods);
        /*if (Global.shadowSwitch)
            button.setShadowLayer(Global.shadowRadius, 0, 0, skinInfoManager.skinData.shadow);*/

        return button;
    }
    protected MyTextView createName(String text) {
        MyTextView textView = new MyTextView(context);

        textView.setGravity(Gravity.LEFT);
        textView.setId(Global.generateViewId());
        textView.setTypeface(typeface);
        textView.setText(text);
        textView.setVisibility(View.GONE);
        //textView.setBackgroundResource(R.drawable.text_back_x);
        if (Global.shadowSwitch)
            textView.setShadowLayer(Global.shadowRadius, 0, 0, skinInfoManager.skinData.shadow);
        return textView;
    }
    protected MyTextView createDesc(String text) {
        MyTextView textView = new MyTextView(context);

        textView.setGravity(Gravity.LEFT);
        textView.setId(Global.generateViewId());
        textView.setTypeface(typeface);
        textView.setText(text);
        textView.setVisibility(View.GONE);
        //textView.setBackgroundResource(R.drawable.text_back_x);
        if (Global.shadowSwitch)
            textView.setShadowLayer(Global.shadowRadius, 0, 0, skinInfoManager.skinData.shadow);
        return textView;
    }
    protected MyTextView createPrice(String text) {
        MyTextView textView = new MyTextView(context);

        textView.setGravity(Gravity.LEFT);
        textView.setId(Global.generateViewId());
        textView.setTypeface(typeface);
        textView.setText(text);
        textView.setVisibility(View.GONE);
        //textView.setBackgroundResource(R.drawable.text_back_x);
        if (Global.shadowSwitch)
            textView.setShadowLayer(Global.shadowRadius, 0, 0, skinInfoManager.skinData.shadow);
        return textView;
    }
    protected MyImageView createImage(String base64Data) {

        MyImageView imageView = new MyImageView(context);
        imageView.setImageBitmap(ImageUtils.base64ToBitmap(base64Data));
        imageView.setId(Global.generateViewId());
        imageView.setVisibility(View.GONE);
        return imageView;
    }


    protected QuickButton addButton(int textColor, int backgroundColor, String text) {
        QuickButton button = createButton(text);
        button.setTextColor(textColor);
        ViewsUtil.setBackgroundWithGradientDrawable(button, backgroundColor);
        button.getBackground().setAlpha(Global.getCurrentAlpha());
        return button;
    }
    protected MyTextView addName(int textColor, int backgroundColor, String text) {
        MyTextView textView = createName(text);
        textView.setTextColor(textColor);
        //ViewsUtil.setBackgroundWithGradientDrawable(textView, backgroundColor);
        //textView.getBackground().setAlpha(Global.getCurrentAlpha());
        return textView;
    }
    protected MyTextView addDesc(int textColor, int backgroundColor, String text) {
        MyTextView textView = createDesc(text);
        textView.setTextColor(textColor);
        //ViewsUtil.setBackgroundWithGradientDrawable(textView, backgroundColor);
        //textView.getBackground().setAlpha(Global.getCurrentAlpha());
        return textView;
    }
    protected MyTextView addPrice(int textColor, int backgroundColor, String text) {
        MyTextView textView = createPrice(text);
        textView.setTextColor(textColor);
        //ViewsUtil.setBackgroundWithGradientDrawable(textView, backgroundColor);
        //textView.getBackground().setAlpha(Global.getCurrentAlpha());
        return textView;
    }
    protected MyImageView addImage(int backgroundColor, String base64Data) {
        MyImageView imageView = createImage(base64Data);
        //ViewsUtil.setBackgroundWithGradientDrawable(imageView, backgroundColor);
        //imageView.getBackground().setAlpha(Global.getCurrentAlpha());
        return imageView;
    }


    public void create(Context context) {
        this.context = context;
        outerLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        innerLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutforWrapGoods = new LinearLayout(context);
        res = context.getResources();
        scrollView = new ScrollView(context);
        scrollView.setSmoothScrollingEnabled(true);
        scrollView.setScrollbarFadingEnabled(false);
        layoutforWrapGoods.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(layoutforWrapGoods, innerLayoutParams);
    }

    public void updateViewLayout() {
        scrollView.updateViewLayout(layoutforWrapGoods, innerLayoutParams);
        parentViewGroup.updateViewLayout(scrollView, outerLayoutParams);
    }

    public void setButtonWidth(int buttonWidth) {
        buttonImage.itsLayoutParams.width = buttonWidth;
        buttonImage.itsLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        buttonDesc.itsLayoutParams.width = buttonWidth;
        buttonDesc.itsLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        buttonName.itsLayoutParams.width = buttonWidth;
        buttonName.itsLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        buttonWords.itsLayoutParams.width = buttonWidth;
        buttonWords.itsLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
    }
}
