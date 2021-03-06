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

    private GuideImageAdapter mGuideImageAdapter;

    private View mBaseView;

    public interface ButtonClick {
        void onButtonClick();
    }

    public void veryFirstAssignButtonClickAndInit(ButtonClick click) {
        mButtonClick = click;
        setViewPagerAndIndicator(mBaseView);
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
        mBaseView = LayoutInflater.from(context).inflate(R.layout.guide_view_layout, this);
    }

    /**
     * @throws NullPointerException if not init callback first
     */
    public void enableButtonAndClickable(boolean clickable) {
        if (mGuideImageAdapter != null) mGuideImageAdapter.enableButtonAndClickable(clickable);
        else throw new NullPointerException(" init callback first");
    }

    private void setViewPagerAndIndicator(View v) {

        mGuideImageAdapter = new GuideImageAdapter(getContext(), mButtonClick);
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
        mViewPager.setAdapter(mGuideImageAdapter);
    }

}