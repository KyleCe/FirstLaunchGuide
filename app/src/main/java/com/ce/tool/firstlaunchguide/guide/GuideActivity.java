package com.ce.tool.firstlaunchguide.guide;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;

import com.ce.tool.firstlaunchguide.R;

public class GuideActivity extends Activity {

    GuideView mGuideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        FrameLayout root = (FrameLayout) findViewById(R.id.guide_whole_root);
        mGuideView= new GuideView(getApplicationContext());
        root.addView(mGuideView);

        mGuideView.assignButtonClick(new GuideView.ButtonClick() {
            @Override
            public void onClick() {
                sop("click");
            }
        });

        root.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0);
            }
        },3000);
    }

    Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    sop("start set clickable");
                    mGuideView.enableButtonAndClickable(true);
                    break;
                default:
                    break;
            }
        }
    };

    private void sop(String str){
        System.out.println(str);
    }
}
