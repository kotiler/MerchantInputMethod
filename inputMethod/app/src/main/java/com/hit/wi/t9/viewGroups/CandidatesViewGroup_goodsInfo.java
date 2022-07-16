package com.hit.wi.t9.viewGroups;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.hit.wi.application.MyApplication;
import com.hit.wi.jni.Kernel;
import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.entity.Goods;
import com.hit.wi.t9.Business.util.GoodsWordsHttpUtil;
import com.hit.wi.t9.Business.util.ImageUtils;
import com.hit.wi.t9.R;
import com.hit.wi.t9.values.Global;
import com.hit.wi.t9.view.MyImageView;
import com.hit.wi.t9.view.MyTextView;
import com.hit.wi.t9.view.QuickButton;
import com.hit.wi.util.DisplayUtil;
import com.hit.wi.util.ViewsUtil;

/**
 *现在保存candidatesViewGroup_goods2
 */
public class CandidatesViewGroup_goodsInfo extends goodsScrolledViewGroup {
    private final float TEXTSIZE_RATE = (float) 0.4;
    private final DisplayMetrics mMetrics = new DisplayMetrics();
    private int mTextColor;
    private int mBackColor;
    private int standardButtonHeight;
    private String image_base64;
    private String goods_name;
    private String goods_desc;
    private String goods_price;
    private LinearLayout goodsLayer;
    private LinearLayout.LayoutParams goodsLayerParams;

    LinearLayout.LayoutParams goodsAllParams;
    LinearLayout.LayoutParams goodsInfoParams;
    LinearLayout.LayoutParams goodsTextParams;
    LinearLayout.LayoutParams goodsButtonParams;

    public CandidatesViewGroup_goodsInfo() {
        mMetrics.setToDefaults();
        goodsLayerParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public void create(Context context) {
        super.create(context);
        mTextColor = softKeyboard.skinInfoManager.skinData.textcolor_candidate_t9;
        mBackColor = softKeyboard.skinInfoManager.skinData.backcolor_candidate_t9;
        standardButtonHeight = 0;
        scrollView.setOnTouchListener(scrollOnTouchListener);

        goodsName = new MyTextView(context);
        goodsDesc = new MyTextView(context);
        goodsPrice = new MyTextView(context);
        goodsImage = new MyImageView(context);
        buttonImage = new QuickButton(context);
        buttonDesc = new QuickButton(context);
        buttonName = new QuickButton(context);
        buttonWords = new QuickButton(context);

        goodsAll = new LinearLayout(context);
        goodsAll.setBackgroundResource(R.drawable.middle_text);
        goodsInfo = new LinearLayout(context);
        goodsText = new LinearLayout(context);
        goodsButton = new LinearLayout(context);

        emptyText1 = new MyTextView(context);
        emptyText2 = new MyTextView(context);
        emptyText3 = new MyTextView(context);

        emptyButton1 = new MyTextView(context);
        emptyButton2 = new MyTextView(context);
        emptyButton3 = new MyTextView(context);
        emptyButton4 = new MyTextView(context);
        emptyButton5 = new MyTextView(context);

        goodsLayer = new LinearLayout(context);
        goodsLayer.setOrientation(LinearLayout.VERTICAL);
        goodsLayer.setVisibility(View.VISIBLE);
        layoutforWrapGoods.addView(goodsLayer, goodsLayerParams);
    }

    // state machine
    public void refreshState(boolean hide, String type) {
        if (hide) {
            Kernel.cleanKernel();
            if (scrollView.isShown()) {
                hide();
            }
        } else {
            if (!scrollView.isShown()) {
                show();
            }
            if (Kernel.getWordsNumber() > 0) {
                displayCandidates();
            }
            scrollView.fullScroll(ScrollView.FOCUS_UP);
        }
    }

    @Override
    public void show() {
        goodsLayer.setVisibility(View.VISIBLE);
        clearAnimation();
        setVisibility(View.VISIBLE);
    }

    public void setSize(int width, int height) {
        super.setSize(width, height);
        standardButtonHeight = height;
        updateViewLayout();
    }


    public void displayCandidates() {
        displayCandidates(new Goods());
    }

    public void displayCandidates(Goods goods) {
        setCandidates(goods);
        scrollView.fullScroll(View.FOCUS_UP);//go to top
    }



    @SuppressLint("NewApi")
    public void setCandidates(Goods curGoods) {
        goodsLayer.removeAllViews();
        image_base64 = curGoods.getImage_base64();
        goods_name = curGoods.getName();
        goods_desc = curGoods.getDescription();
        goods_price = curGoods.getPrice();

        goodsText = addGoodsText();
        addGoodsName(goods_name);
        goodsText.addView(goodsName, goodsName.itsLayoutParams);
        addGoodsDesc(goods_desc);
        goodsText.addView(goodsDesc, goodsDesc.itsLayoutParams);
        addGoodsPrice(goods_price);
        goodsText.addView(goodsPrice, goodsPrice.itsLayoutParams);

        goodsInfo = addGoodsInfo();

        addGoodsImage(image_base64);
        goodsInfo.addView(goodsImage, goodsImage.itsLayoutParams);
        goodsInfo.addView(goodsText, goodsTextParams);

        addButtonImage("保存图片");
        addButtonDesc("发送描述");
        addButtonName("发送名称");
        addButtonWords("商品话术");
        /*btnImage.addView(buttonImage, buttonImage.itsLayoutParams);
        btnDesc.addView(buttonDesc, buttonDesc.itsLayoutParams);
        btnName.addView(buttonName, buttonName.itsLayoutParams);*/

        goodsButton = addGoodsButton();
        addEmptyButton("");
        goodsButton.addView(emptyButton1, emptyButton1.itsLayoutParams);
        goodsButton.addView(buttonImage, buttonImage.itsLayoutParams);
        goodsButton.addView(emptyButton2, emptyButton2.itsLayoutParams);
        goodsButton.addView(buttonDesc, buttonDesc.itsLayoutParams);
        goodsButton.addView(emptyButton3, emptyButton3.itsLayoutParams);
        goodsButton.addView(buttonName, buttonName.itsLayoutParams);
        goodsButton.addView(emptyButton4, emptyButton4.itsLayoutParams);
        goodsButton.addView(buttonWords, buttonWords.itsLayoutParams);
        goodsButton.addView(emptyButton5, emptyButton5.itsLayoutParams);

        goodsAll = addGoodsAll();
        addEmptyText("");
        goodsAll.addView(emptyText1, emptyText1.itsLayoutParams);
        goodsAll.addView(goodsInfo, goodsInfoParams);
        goodsAll.addView(emptyText2, emptyText2.itsLayoutParams);
        goodsAll.addView(goodsButton, goodsButtonParams);
        goodsAll.addView(emptyText3, emptyText3.itsLayoutParams);

        goodsLayer.addView(goodsAll);
        goodsLayer.setVisibility(View.VISIBLE);

    }

    public void updateSkin() {
        if (Global.currentKeyboard == Global.KEYBOARD_QK || Global.currentKeyboard == Global.KEYBOARD_EN) {
            mBackColor = softKeyboard.skinInfoManager.skinData.backcolor_candidate_qk;
            mTextColor = softKeyboard.skinInfoManager.skinData.textcolor_candidate_qk;
        } else {
            mBackColor = softKeyboard.skinInfoManager.skinData.backcolor_candidate_t9;
            mTextColor = softKeyboard.skinInfoManager.skinData.textcolor_candidate_t9;
        }
        super.updateButtonSkin(mTextColor, mBackColor);
        super.updateNameSkin(mTextColor, mBackColor);
        super.updateDescSkin(mTextColor, mBackColor);
        super.updatePriceSkin(mTextColor, mBackColor);
        super.updateImageSkin(mBackColor);
        super.updateBehindSkin(mBackColor);
    }

    public void largeTheCandidate() {
        softKeyboard.functionViewGroup.setVisibility(View.GONE);
        softKeyboard.mInputViewGG.setVisibility(View.GONE);
        softKeyboard.secondLayerLayout.setVisibility(View.GONE);
        int largeheight = softKeyboard.keyboardParams.height - softKeyboard.bottomBarViewGroup.getHeight() - softKeyboard.standardVerticalGapDistance;
        if (getHeight() != largeheight) {
            setHeight(largeheight);
        }
    }

    /**
     * Event listener for touching a candidate
     */
    private OnTouchListener savePicOnTouch = new OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                ImageUtils.saveMyBitmap(context, ImageUtils.base64ToBitmap(image_base64));
            }
            return true;
        }
    };

    private OnTouchListener sendDescOnTouch = new OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                String sendDescContext = goods_desc + '\n' + "仅售：" + goods_price + "元";
                softKeyboard.commitText(sendDescContext);
            }
            return true;
        }
    };

    private OnTouchListener sendNameOnTouch = new OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                softKeyboard.commitText(goods_name);
            }
            return true;
        }
    };

    private OnTouchListener getWordsOnTouch = new OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (Global.isInView(v, event)) {
                    Kernel.cleanKernel();

                    Final.goodsWords.clear();
                    Final.isFinishedGetWords = false;
                    GoodsWordsHttpUtil.GetRequest(context, "http://" + MyApplication.ip + ":" + MyApplication.port + "/goodswords/showGoodsWords", Final.u_email, goods_name);
                    while (true) {
                        if (Final.isFinishedGetWords)
                            break;
                    }
                    Final.isFinishedGetWords = false;

                    softKeyboard.candidatesViewGroup_goodsWords.displayCandidates(Global.SYMBOL, Final.goodsWords, Global.inLarge ? 200 : 9);
                    softKeyboard.bottomBarViewGroup.wordsType = 0;
                    softKeyboard.refreshDisplay_GoodsWords(true);
                    softKeyboard.candidatesViewGroup_goodsWords.largeTheCandidate();
                }
            }
            return true;
        }
    };


    private OnTouchListener scrollOnTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return scrollView.onTouchEvent(event);
        }
    };

    private LinearLayout addGoodsAll(){
        LinearLayout goodsAll = new LinearLayout(context);
        goodsAll.setVisibility(View.VISIBLE);
        goodsAll.setBackgroundResource(R.drawable.middle_text);
        goodsAll.setId((Global.generateViewId()));
        ViewsUtil.setBackgroundWithGradientDrawable(goodsAll, mBackColor);
        goodsAllParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        goodsAll.setLayoutParams(goodsAllParams); //设置宽和高
        goodsAll.clearAnimation();
        goodsAll.getBackground().setAlpha(Global.getCurrentAlpha());
        goodsAll.setAlpha(Global.getCurrentAlpha());
        goodsAll.setPressed(false);
        goodsAll.setOrientation(LinearLayout.VERTICAL);

        return goodsAll;
    }

    private LinearLayout addGoodsInfo(){
        LinearLayout goodsInfo = new LinearLayout(context);
        goodsInfo.setVisibility(View.VISIBLE);
        //goods.setBackgroundResource(R.drawable.middle_text);
        goodsInfo.setId((Global.generateViewId()));
        //ViewsUtil.setBackgroundWithGradientDrawable(goods, mBackColor);
        goodsInfoParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        int padding = DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f);
        goodsInfo.setPadding(padding, padding, padding, padding);

        goodsInfo.setLayoutParams(goodsInfoParams); //设置宽和高
        goodsInfo.clearAnimation();
        //goods.getBackground().setAlpha(Global.getCurrentAlpha());
        //goods.setAlpha(Global.getCurrentAlpha());
        goodsInfo.setPressed(false);
        goodsInfo.setOrientation(LinearLayout.HORIZONTAL);

        return goodsInfo;
    }

    private void addGoodsImage(String base64Data){
        goodsImage = super.addImage(mBackColor, base64Data);
        goodsImage.setVisibility(View.VISIBLE);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1
        );
        goodsImage.itsLayoutParams = params;
        goodsImage.setLayoutParams(params);
        goodsImage.setImageBitmap(ImageUtils.base64ToBitmap(base64Data));
        goodsImage.setAdjustViewBounds(true);
        goodsImage.clearAnimation();
        //goodsImage.getBackground().setAlpha(Global.getCurrentAlpha());
        goodsImage.setPressed(false);
    }

    private LinearLayout addGoodsText(){
        LinearLayout goodsText = new LinearLayout(context);
        goodsText.setVisibility(View.VISIBLE);
        //goodsText.setBackgroundResource(R.drawable.middle_text);
        goodsText.setId((Global.generateViewId()));

        //ViewsUtil.setBackgroundWithGradientDrawable(goodsText, mBackColor);
        goodsTextParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.MATCH_PARENT, 1
        );

        goodsText.setLayoutParams(goodsTextParams); //设置宽和高
        goodsText.clearAnimation();
        //goodsText.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsText.setAlpha(Global.getCurrentAlpha());
        goodsText.setPressed(false);
        goodsText.setOrientation(LinearLayout.VERTICAL);

        return goodsText;
    }

    private void addGoodsName(String text){
        goodsName = super.addName(mTextColor, mBackColor, text);
        goodsName.setVisibility(View.VISIBLE);
        //goodsName.setBackgroundResource(R.drawable.middle_text);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.5f
        );
        goodsName.itsLayoutParams = params;
        goodsName.setLayoutParams(params);

        goodsName.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        goodsName.setSingleLine(true);
        goodsName.setEllipsize(TextUtils.TruncateAt.END);
        goodsName.clearAnimation();
        //goodsName.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsName.setAlpha(Global.getCurrentAlpha());
        goodsName.setPressed(false);
        goodsName.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * TEXTSIZE_RATE));
        goodsName.setTypeface(typeface, Typeface.BOLD);
    }

    private void addGoodsDesc(String text){
        goodsDesc = super.addDesc(mTextColor, mBackColor, text);
        goodsDesc.setVisibility(View.VISIBLE);
        int padding = DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f);
        goodsText.setPadding(padding, 0, (int)(padding * 1.5f), 0);
        //goodsDesc.setBackgroundResource(R.drawable.middle_text);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 4
        );
        goodsDesc.itsLayoutParams = params;
        goodsDesc.setLayoutParams(params);
        goodsDesc.setMaxLines(5);
        goodsDesc.setEllipsize(TextUtils.TruncateAt.END);
        goodsDesc.clearAnimation();
        //goodsDesc.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsDesc.setAlpha(Global.getCurrentAlpha());
        goodsDesc.setPressed(false);
        goodsDesc.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.3f));
    }

    private void addGoodsPrice(String text){
        goodsPrice = super.addPrice(mTextColor, mBackColor, "￥" + text);
        goodsPrice.setVisibility(View.VISIBLE);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1
        );
        goodsPrice.itsLayoutParams = params;
        goodsPrice.setLayoutParams(params);
        goodsPrice.clearAnimation();
        goodsPrice.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        //goodsPrice.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsPrice.setAlpha(Global.getCurrentAlpha());
        goodsPrice.setPressed(false);
        goodsPrice.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.3f));
        goodsPrice.setTypeface(typeface, Typeface.BOLD);
    }

    private void addEmptyText(String text){
        emptyText1 = new MyTextView(context);
        emptyText2 = new MyTextView(context);
        emptyText3 = new MyTextView(context);

        emptyText1.setId(Global.generateViewId());
        emptyText1.setVisibility(View.VISIBLE);
        emptyText2.setId(Global.generateViewId());
        emptyText2.setVisibility(View.VISIBLE);
        emptyText3.setId(Global.generateViewId());
        emptyText3.setVisibility(View.VISIBLE);
        //goodsPrice.setBackgroundResource(R.drawable.middle_text);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1
        );
        emptyText1.itsLayoutParams = params;
        emptyText1.setLayoutParams(params);
        emptyText1.clearAnimation();
        emptyText2.itsLayoutParams = params;
        emptyText2.setLayoutParams(params);
        emptyText2.clearAnimation();
        emptyText3.itsLayoutParams = params;
        emptyText3.setLayoutParams(params);
        emptyText3.clearAnimation();
        //goodsPrice.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsPrice.setAlpha(Global.getCurrentAlpha());
        emptyText1.setPressed(false);
        emptyText1.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.2f));
        emptyText2.setPressed(false);
        emptyText2.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.2f));
        emptyText3.setPressed(false);
        emptyText3.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight));
    }

    private void addEmptyButton(String text){
        emptyButton1 = new MyTextView(context);
        emptyButton2 = new MyTextView(context);
        emptyButton3 = new MyTextView(context);
        emptyButton4 = new MyTextView(context);
        emptyButton5 = new MyTextView(context);

        emptyButton1.setId(Global.generateViewId());
        emptyButton1.setVisibility(View.VISIBLE);
        emptyButton2.setId(Global.generateViewId());
        emptyButton2.setVisibility(View.VISIBLE);
        emptyButton3.setId(Global.generateViewId());
        emptyButton3.setVisibility(View.VISIBLE);
        emptyButton4.setId(Global.generateViewId());
        emptyButton4.setVisibility(View.VISIBLE);
        emptyButton5.setId(Global.generateViewId());
        emptyButton5.setVisibility(View.VISIBLE);
        //goodsPrice.setBackgroundResource(R.drawable.middle_text);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 0.3f
        );
        emptyButton1.itsLayoutParams = params;
        emptyButton1.setLayoutParams(params);
        emptyButton1.clearAnimation();
        emptyButton2.itsLayoutParams = params;
        emptyButton2.setLayoutParams(params);
        emptyButton2.clearAnimation();
        emptyButton3.itsLayoutParams = params;
        emptyButton3.setLayoutParams(params);
        emptyButton3.clearAnimation();
        emptyButton4.itsLayoutParams = params;
        emptyButton4.setLayoutParams(params);
        emptyButton4.clearAnimation();
        emptyButton5.itsLayoutParams = params;
        emptyButton5.setLayoutParams(params);
        emptyButton5.clearAnimation();
        //goodsPrice.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsPrice.setAlpha(Global.getCurrentAlpha());
        emptyButton1.setPressed(false);
        emptyButton1.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        emptyButton2.setPressed(false);
        emptyButton2.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        emptyButton3.setPressed(false);
        emptyButton3.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        emptyButton4.setPressed(false);
        emptyButton4.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        emptyButton5.setPressed(false);
        emptyButton5.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
    }

    private LinearLayout addGoodsButton(){
        LinearLayout goodsButton = new LinearLayout(context);
        goodsButton.setVisibility(View.VISIBLE);
        //goodsButton.setBackgroundResource(R.drawable.middle_text);
        goodsButton.setId((Global.generateViewId()));
        //ViewsUtil.setBackgroundWithGradientDrawable(goodsButton, mBackColor);
        goodsButtonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        goodsButton.setLayoutParams(goodsButtonParams); //设置宽和高
        goodsButton.clearAnimation();
        //goodsButton.getBackground().setAlpha(Global.getCurrentAlpha());
        //goodsButton.setAlpha(Global.getCurrentAlpha());
        goodsButton.setPressed(false);
        goodsButton.setOrientation(LinearLayout.HORIZONTAL);

        return goodsButton;
    }


    private void addButtonImage(String text) {
        buttonImage = super.addButton(mBackColor, mTextColor, text);
        buttonImage.setVisibility(View.VISIBLE);
        buttonImage.setBackgroundResource(R.drawable.button_goods);

        buttonImage.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1
        );
        //buttonImage.setGravity(Gravity.TOP);
        buttonImage.itsLayoutParams = params;
        buttonImage.setLayoutParams(params);
        buttonImage.clearAnimation();
        buttonImage.setSingleLine(true);
        buttonImage.setEllipsize(TextUtils.TruncateAt.END);
        buttonImage.getBackground().setAlpha(Global.getCurrentAlpha());
        buttonImage.setAlpha(Global.getCurrentAlpha());
        buttonImage.setPressed(false);
        buttonImage.setOnTouchListener(savePicOnTouch);
        buttonImage.setMinimumWidth(0);
        buttonImage.setMinHeight(0);
        buttonImage.setMinimumHeight(0);
        buttonImage.setMinWidth(0);
    }


    private void addButtonDesc(String text) {
        buttonDesc = super.addButton(mBackColor, mTextColor, text);
        buttonDesc.setVisibility(View.VISIBLE);
        buttonDesc.setBackgroundResource(R.drawable.button_goods);

        buttonDesc.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1
        );
        buttonDesc.itsLayoutParams = params;
        buttonDesc.setLayoutParams(params);
        buttonDesc.clearAnimation();
        buttonDesc.setSingleLine(true);
        buttonDesc.setEllipsize(TextUtils.TruncateAt.END);
        buttonDesc.getBackground().setAlpha(Global.getCurrentAlpha());
        buttonDesc.setAlpha(Global.getCurrentAlpha());
        buttonDesc.setPressed(false);
        buttonDesc.setOnTouchListener(sendDescOnTouch);
        buttonDesc.setMinimumWidth(0);
        buttonDesc.setMinHeight(0);
        buttonDesc.setMinimumHeight(0);
        buttonDesc.setMinWidth(0);
    }

    private void addButtonName(String text) {
        buttonName = super.addButton(mBackColor, mTextColor, text);
        buttonName.setVisibility(View.VISIBLE);
        buttonName.setBackgroundResource(R.drawable.button_goods);
        buttonName.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1
        );
        buttonName.itsLayoutParams = params;
        buttonName.setLayoutParams(params);
        buttonName.clearAnimation();
        buttonName.setSingleLine(true);
        buttonName.setEllipsize(TextUtils.TruncateAt.END);
        buttonName.getBackground().setAlpha(Global.getCurrentAlpha());
        buttonName.setAlpha(Global.getCurrentAlpha());
        buttonName.setPressed(false);
        buttonName.setOnTouchListener(sendNameOnTouch);
        buttonName.setMinimumWidth(0);
        buttonName.setMinHeight(0);
        buttonName.setMinimumHeight(0);
        buttonName.setMinWidth(0);
    }

    private void addButtonWords(String text) {
        buttonWords = super.addButton(mBackColor, mTextColor, text);
        buttonWords.setVisibility(View.VISIBLE);
        buttonWords.setBackgroundResource(R.drawable.button_goods);
        buttonWords.setTextSize(DisplayUtil.px2sp(context, Global.textsizeFactor * standardButtonHeight * 0.25f));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1
        );
        buttonWords.itsLayoutParams = params;
        buttonWords.setLayoutParams(params);
        buttonWords.clearAnimation();
        buttonWords.setSingleLine(true);
        buttonWords.setEllipsize(TextUtils.TruncateAt.END);
        buttonWords.getBackground().setAlpha(Global.getCurrentAlpha());
        buttonWords.setAlpha(Global.getCurrentAlpha());
        buttonWords.setPressed(false);
        buttonWords.setOnTouchListener(getWordsOnTouch);
        buttonWords.setMinimumWidth(0);
        buttonWords.setMinHeight(0);
        buttonWords.setMinimumHeight(0);
        buttonWords.setMinWidth(0);
    }
}