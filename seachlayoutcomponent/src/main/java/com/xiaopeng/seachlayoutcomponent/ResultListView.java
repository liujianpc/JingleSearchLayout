package com.xiaopeng.seachlayoutcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Date: 2019/3/31
 * Created by LiuJian
 *
 * @author LiuJian
 */

class ResultListView extends ListView {
    public ResultListView(Context context) {
        super(context);
    }

    public ResultListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int enforceSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, enforceSpec);
    }
}
