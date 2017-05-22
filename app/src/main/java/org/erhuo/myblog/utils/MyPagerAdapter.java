package org.erhuo.myblog.utils;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by erhuo on 2017/5/22.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<ImageView> mlist;
    public MyPagerAdapter(List<ImageView> list){
        this.mlist=list;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    /*
  * 初始化
  */
    @Override
    public Object instantiateItem(View container, int position)
    {
        ((ViewPager)container).addView(mlist.get(position),0);
        return mlist.get(position);

    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        // 将当前位置的View移除
        container.removeView(mlist.get(position));
    }
}
