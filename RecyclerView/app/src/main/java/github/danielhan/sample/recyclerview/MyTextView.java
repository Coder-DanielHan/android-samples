package github.danielhan.sample.recyclerview;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @author DanielHan
 * @date 2018/2/26
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            setText("w:" + getWidth() + ",h:" + getHeight());
        }
    }
}
