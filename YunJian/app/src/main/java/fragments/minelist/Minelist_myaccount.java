package fragments.minelist;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.load.engine.Resource;
import com.google.gson.Gson;
import com.yunjian.Minelist_account_Activity;
import com.yunjian.Minelist_team_Activity;
import com.yunjian.R;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.PersonEntity;
import com.yunjian.entity.PersonResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    static String[] account_content=new String[6];

    //private boolean isFirstVisible = true;
    //private boolean isViewCreated;
    private boolean isGetData=false;

    /**
     * Get instance minelist myaccount.
     *
     * @return the minelist myaccount
     */
    public Minelist_myaccount getInstance(){
        Minelist_myaccount fragment = new Minelist_myaccount();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        get_info();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.minelist_myaccount,container,false);
        listView = view.findViewById(R.id.listview_minelist_myaccount);
        //String[] account_content=new String[6];
        Resources resources=this.getResources();
        /*Api.configNoParams(ApiConfig.USER_ACCOUNT).getRequestUseHeader(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                PersonResponse personResponse=new Gson().fromJson(res,PersonResponse.class);
                if(personResponse.getCode()==0){
                    account_content[0]=personResponse.getData().getUserName();
                    account_content[1]=personResponse.getData().getUserSex();
                    account_content[2]=personResponse.getData().getRoleName();
                    account_content[3]=personResponse.getData().getCompanyName();
                    account_content[4]=personResponse.getData().getDeptName();
                    account_content[5]= String.valueOf(personResponse.getData().getPrjName());
                }
                View view = inflater.inflate(R.layout.minelist_myaccount,container,false);
                listView = view.findViewById(R.id.listview_minelist_myaccount);
                List<Map<String,Object>> listItems =new ArrayList<Map<String,Object>>();
                //Resources resources=this.getResources();
                String[] account_list=resources.getStringArray(R.array.myaccount_list);
                for(int i=0;i<account_list.length;i++){
                    Map<String,Object> listItem=new HashMap<String, Object>();
                    listItem.put("title",account_list[i]);
                    listItem.put("content",account_content[i]);
                    listItems.add(listItem);
                }
                SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),listItems,R.layout.minelist_myaccount_item,new String[]{"title","content"},new int[]{R.id.myaccount_title,R.id.myaccount_content});
                listView.setAdapter(simpleAdapter);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });*/
        //View view = inflater.inflate(R.layout.minelist_myaccount,container,false);
        //listView = view.findViewById(R.id.listview_minelist_myaccount);
        List<Map<String,Object>> listItems =new ArrayList<Map<String,Object>>();
        //Resources resources=this.getResources();
        String[] account_list=resources.getStringArray(R.array.myaccount_list);
        for(int i=0;i<account_list.length;i++){
            if(account_content[i]==null){
                get_info();
            }
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("title", account_list[i]);
            listItem.put("content", account_content[i]);
            listItems.add(listItem);
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.minelist_myaccount_item,getResources().getStringArray(R.array.myaccount_list));
        //listView.setAdapter(adapter);
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),listItems,R.layout.minelist_myaccount_item,new String[]{"title","content"},new int[]{R.id.myaccount_title,R.id.myaccount_content});
        listView.setAdapter(simpleAdapter);
        return view;
    }

    @Override
    public void onResume() {
        if(!isGetData){
            get_info();
            isGetData=true;
        }
        super.onResume();
    }

    private void get_info(){
        Api.configNoParams(ApiConfig.USER_ACCOUNT).getRequestUseHeader(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                PersonResponse personResponse=new Gson().fromJson(res,PersonResponse.class);
                if(personResponse.getCode()==0){
                    account_content[0]=String.valueOf(personResponse.getData().getUserName());
                    account_content[1]=String.valueOf(personResponse.getData().getUserSex());
                    account_content[2]=String.valueOf(personResponse.getData().getRoleName());
                    account_content[3]=String.valueOf(personResponse.getData().getCompanyName());
                    account_content[4]=String.valueOf(personResponse.getData().getDeptName());
                    account_content[5]= String.valueOf(personResponse.getData().getPrjName());
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
