package fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.GenericTransitionOptions;
import com.google.android.material.tabs.TabLayout;
import com.yunjian.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 吴立柳
 * @package fragments
 * @date on 2020/9/6
 * @describe 诊所fragment
 */
public class BottomNavigationThirdfragment extends Fragment {
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_navigation_third,container,false);
        tabLayout = view.findViewById(R.id.third_tab);
        viewPager = view.findViewById(R.id.third_viewpager);
        initFragments();
        viewPager.setAdapter(new ViewAdapter(getChildFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    /**
     * 初始化
     */
    private void initFragments(){
        fragments = new ArrayList<>();
        fragments.add(new ThirdFragment1());
        fragments.add(new ThirdFragment1());
        fragments.add(new ThirdFragment1());
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
}
