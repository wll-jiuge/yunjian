package fragments.minelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yunjian.R;

/**
 *@package fragments.minelist
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 我的--个人账户信息
*/
public class Minelist_myaccount extends Fragment {

    /**
     * The List view.
     */
    ListView listView;

    /**
     * Get instance minelist myaccount.
     *
     * @return the minelist myaccount
     */
    public Minelist_myaccount getInstance(){
        Minelist_myaccount fragment = new Minelist_myaccount();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minelist_myaccount,container,false);
        listView = view.findViewById(R.id.listview_minelist_myaccount);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.minelist_myaccount_item,getResources().getStringArray(R.array.myaccount_list));
        listView.setAdapter(adapter);
        return view;
    }

}
