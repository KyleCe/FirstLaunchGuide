package com.ce.tool.firstlaunchguide.guide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ce.tool.firstlaunchguide.R;

public class GuideActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        FrameLayout root = (FrameLayout) findViewById(R.id.guide_whole_root);

        root.addView(new GuideView(getApplicationContext()));
    }

}
