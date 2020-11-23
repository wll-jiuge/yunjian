package fragments.loginfomation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.adapters.LoginfoListAdapter;

import fragments.BaseFragment;
import utils.StringUtils;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 日志信息--日志列表页面
*/
public class LoginfomationFragment1 extends BaseFragment implements View.OnClickListener, SearchView.OnQueryTextListener {
    SearchView searchView;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loginfomation_1,container,false);
        init(view);
        //设置图标是否默认为自动缩小
        searchView.setIconifiedByDefault(false);
        //设置监听器
        searchView.setOnQueryTextListener(this);
        //设置垂直方向列表
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        LoginfoListAdapter loginfoListAdapter = new LoginfoListAdapter(getContext());
        recyclerView.setAdapter(loginfoListAdapter);
        return view;
    }


    private void init(View view){
        searchView=view.findViewById(R.id.searchview_loginfomation);
        recyclerView = view.findViewById(R.id.recyclerview_loginfon_list);
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 搜索框文本提交
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    /**
     * 搜索框文本改变
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

}
