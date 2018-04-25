package com.danielhan.viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    private ViewFlipper flipper;
    private int[] resId = {R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        // 动态导入的方式为ViewFlipper加入子View
        for (int i = 0; i < resId.length; i++) {
            flipper.addView(getImageView(resId[i]));
        }
        // 为flipper设置动画效果
        flipper.setInAnimation(this, R.anim.left_in);
        flipper.setOutAnimation(this, R.anim.right_out);
        // 设定flipper视图切换的时间
        flipper.setFlipInterval(3000);
        // 开始播放动画
        flipper.startFlipping();
    }

    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(this);
        /*
         * //按图片原大小展示
         * image.setImageResource(resId);
         **/

        // 全屏显示图片
        image.setBackgroundResource(resId);
        return image;
    }
}
