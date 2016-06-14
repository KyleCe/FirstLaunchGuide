package com.ce.tool.firstlaunchguide.guide;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.ce.tool.firstlaunchguide.R;

/**
 * Created by KyleCe on 2016/6/8.
 *
 * @author: KyleCe
 */
public class GuideView extends FrameLayout {
    private GuideSmoothViewPager mViewPager;
    private ButtonClick mButtonClick;

    public interface ButtonClick {
        void onClick();
    }

    public void assignButtonClick(ButtonClick click) {
        mButtonClick = click;
    }

    public GuideView(Context context) {
        this(context, null);
    }

    public GuideView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View base = LayoutInflater.from(context).inflate(R.layout.guide_view_layout, this);
        setViewPagerAndIndicator(base);

        base.findViewById(R.id.create_account_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonClick == null) return;
                mButtonClick.onClick();
            }
        });
    }

    private void setViewPagerAndIndicator(View v) {

        GuideImageAdapter adapter = new GuideImageAdapter(getContext());
        mViewPager = (GuideSmoothViewPager) v.findViewById(R.id.guide_view_pager);

        final RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.radiogroup);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.radioButton);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        break;
                    case 3:
                        radioGroup.check(R.id.radioButton4);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(adapter);
    }

}
