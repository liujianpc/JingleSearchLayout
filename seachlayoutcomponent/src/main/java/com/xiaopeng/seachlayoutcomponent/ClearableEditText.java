package com.xiaopeng.seachlayoutcomponent;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Date: 2019/3/31
 * Created by LiuJian
 *
 * @author LiuJian
 */

public class ClearableEditText extends AppCompatEditText {


    private Drawable mSearchDrawable;
    private Drawable mClearDrawable;

    public ClearableEditText(Context context) {
        super(context);
        initView();

    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mSearchDrawable = getResources().getDrawable(R.drawable.search);
        mClearDrawable = getResources().getDrawable(R.drawable.clear);
        setCompoundDrawablesWithIntrinsicBounds(mSearchDrawable, null, null, null);

    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {

        if (hasFocus() && text.length() > 0) {
            setCompoundDrawablesWithIntrinsicBounds(mSearchDrawable, null, mClearDrawable, null);
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused && length() > 0) {
            setCompoundDrawablesWithIntrinsicBounds(mSearchDrawable, null, mClearDrawable, null);

        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (event.getX() <= getWidth() - getPaddingRight() && event.getX() >= getWidth() - getPaddingRight() - mClearDrawable.getBounds().width()) {
                    setText("");
                }
                break;

            default:
                break;
        }


        return super.onTouchEvent(event);
    }
}
