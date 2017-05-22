package org.erhuo.myblog.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import org.erhuo.myblog.R;
import org.erhuo.myblog.utils.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FirstloadActivity extends Activity implements ViewPager.OnPageChangeListener{
    /**
     * ViewPager
     */
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    /**
     * 装ImageView数组
     */
    private ImageView[] mImageViews;
    /**
     * 图片资源id
     */
    public int[] imgIdArray ={R.drawable.firstload1,R.drawable.firstload2,R.drawable.firstload3};
    private List<ImageView> mlist;
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //无title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstload);


        mlist=new ArrayList<ImageView>(imgIdArray.length);
        for (int i=0;i<imgIdArray.length;i++){
            ImageView temp=new ImageView(this);
            temp.setImageResource(imgIdArray[i]);
            temp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mlist.add(temp);
        }


        viewPager= (ViewPager) findViewById(R.id.viewPager);
        myPagerAdapter=new MyPagerAdapter(mlist);
        viewPager.setAdapter(myPagerAdapter);

        viewPager.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(position==imgIdArray.length-1){
            Handler handler=new Handler();
            handler.postDelayed(new Runnable(){
                public void run(){
                    Intent intent=new Intent(FirstloadActivity.this,SplashActivity.class);
                    startActivity(intent);
                }
            }, 2000);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}