package fragments;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.GenericTransitionOptions;
import com.google.android.material.tabs.TabLayout;
import com.yunjian.AddCheckActivity;
import com.yunjian.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 吴立柳
 * @package fragments
 * @date on 2020/9/6
 * @describe 诊断fragment
 */
public class BottomNavigationThirdfragment extends BaseFragment {
    /**
     * The Tab layout.
     */
    TabLayout tabLayout;
    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The Title.
     */
    String[] title = {"未处理项目","已处理项目","发起的项目"};
    /**
     * The Fragments.
     */
    List<Fragment> fragments;

    //Button btn_float;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_navigation_third,container,false);
        tabLayout = view.findViewById(R.id.third_tab);
        viewPager = view.findViewById(R.id.third_viewpager);
        //btn_float=view.findViewById(R.id.check_floatingActionButton);
        initFragments();
        viewPager.setAdapter(new ViewAdapter(getChildFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);



        /**
         * 浮动按钮点击事件
         * 数据请求应该在点击页面的时候就发生
         */
/*        btn_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),AddCheckActivity.class);
                startActivity(intent);
            }
        });*/
        return view;
    }

    /**
     * 初始化
     */
    private void initFragments(){
        fragments = new ArrayList<>();
        fragments.add(new ThirdFragment1());
        fragments.add(new ThirdFragment2());
        fragments.add(new ThirdFragment3());
    }

    /**
     * 适配器类
     */
    private class ViewAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        /**
         * Instantiates a new View adapter.
         *
         * @param fm   the fm
         * @param list the list
         */
        public ViewAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 进行关联
         * @param position
         * @return
         */
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
    /*public void add_check(View view){
        Intent intent =new Intent(getActivity(),AddCheckActivity.class);
        startActivity(intent);
    }*/
}
