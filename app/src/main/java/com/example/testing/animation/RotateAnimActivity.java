package com.example.testing.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by 蛮大人 on 2017/3/26.
 */

public class RotateAnimActivity extends AppCompatActivity {
    private static final String TAG = "RotateAnimActivity";

    private ImageView iv_rotate;

    private int currAngle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_anim);

        iv_rotate = (ImageView) findViewById(R.id.iv_rotate);

    }

    public void xmlAnim(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        iv_rotate.startAnimation(animation);
    }

    public void javaPositiveAnim(View view) {
        Animation anim = new RotateAnimation(currAngle, currAngle + 180, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lir = new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(2500);
        anim.setFillAfter(true);
        currAngle -= 180;
        if (currAngle > 360) {
            currAngle = currAngle - 360;
        }
        iv_rotate.startAnimation(anim);

    }

    public void javaNegativeAnim(View view) {
        Animation anim=new RotateAnimation(currAngle,currAngle-180,Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        LinearInterpolator lir=new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(2500);
        anim.setFillAfter(true);
        currAngle-=180;
        if(currAngle<-360){
            currAngle=currAngle+360;
        }
        iv_rotate.startAnimation(anim);
    }


}
