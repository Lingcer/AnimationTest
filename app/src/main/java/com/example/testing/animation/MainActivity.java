package com.example.testing.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * android animation ：Property Animation and View Animation(FrameAnimation and TweenAnimation)
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Button btn_load;

    private ImageView iv_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_load = (Button) findViewById(R.id.btn_load);
        iv_loading = (ImageView) findViewById(R.id.iv_loading);

        btn_load.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load:
                //startFrameAnimationXml();
                startFrameAnimationJava();
                break;
            default:
                break;
        }
    }

    /**
     * 从xml读取帧动画
     */
    private void startFrameAnimationXml() {
        iv_loading.setImageResource(R.drawable.anim_loading_list);
        AnimationDrawable mAnimationDrawable = (AnimationDrawable) iv_loading.getDrawable();
        mAnimationDrawable.start();
    }

    /**
     * java代码实现帧动画
     */
    private void startFrameAnimationJava() {
        AnimationDrawable mAnimationDrawable = new AnimationDrawable();
        for (int i = 0; i < 12; i++) {
            String num;
            if (i < 9) {
                num = "0" + (i + 1);
            } else {
                num = "" + (i + 1);
            }
            int id = getResources().getIdentifier("market_loading_" + num, "drawable", getPackageName());
            Log.i(TAG, "startFrameAnimationJava: i="+i+",id="+id);
            Drawable drawable = ContextCompat.getDrawable(this, id);
            mAnimationDrawable.addFrame(drawable, 200);
        }
        mAnimationDrawable.setOneShot(false);
        iv_loading.setImageDrawable(mAnimationDrawable);
        mAnimationDrawable.start();
    }
}
