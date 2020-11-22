package fragments;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.yunjian.MainActivity;
import com.yunjian.Minelist_account_Activity;
import com.yunjian.Minelist_deptment_Activity;
import com.yunjian.Minelist_team_Activity;
import com.yunjian.R;
import com.yunjian.api.Api;
import com.yunjian.api.ApiConfig;
import com.yunjian.api.YJcallback;
import com.yunjian.entity.BasicResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 吴立柳
 * @package fragments
 * @date on 2020/9/6
 * @describe 我的fragment
 */
public class BottomNavigationLastfragment extends BaseFragment {
    //private PersonEntity personentity;
    /**
     * The List view.
     */
    ListView listView;
    /**
     * The Adapter.
     */
    SimpleAdapter adapter;
    /**
     * The Username.
     */
    TextView username, /**
     * The Role.
     */
    role, /**
     * The Project.
     */
    project;
    /**
     * The Res.
     */
    Button btn_exit;
    /*String res = "{" +
            "  \"msg\": \"ok\"," +
            "  \"code\": 0," +
            "  \"name\": \"不知名的路人甲\"," +
            "  \"sex\": \"男\"," +
            "  \"company\": \"中国建筑第六工程局\"," +
            "  \"role\": \"炮灰QAQ\"," +
            "  \"department\": \"部门A\"," +
            "  \"project\": \"项目A\"," +
            "  \"programs\": [\"项目A\",\"项目B\",\"项目C\"]" +
            "}";*/
    /**
     * The Mine list.
     */
    String[] Mine_list = new String[]{"个人信息", "我的部门", "我的班组", "关于软件", "上传日志"};
    /**
     * The Images.
     */
    int[] images = new int[]{R.drawable.mine_1, R.drawable.mine_2, R.drawable.mine_3,
            R.drawable.mine_4, R.drawable.mine_5};

    /**
     * Get instance bottom navigation lastfragment.
     *
     * @return the bottom navigation lastfragment
     */
    public BottomNavigationLastfragment getInstance(){
        BottomNavigationLastfragment fragment = new BottomNavigationLastfragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_navigation_last,container,false);
        listView = view.findViewById(R.id.listView);
        //personentity = new Gson().fromJson(res, PersonEntity.class);

        Api.configNoParams(ApiConfig.USER_BASIC).getRequestUseHeader(new YJcallback() {
            @Override
            public void onSuccess(String res) {
                BasicResponse basicResponse=new Gson().fromJson(res, BasicResponse.class);
                if(basicResponse.getCode()==0){
                    username=view.findViewById(R.id.Mine_username);
                    role = view.findViewById(R.id.Mine_userrole);
                    project = view.findViewById(R.id.Mine_userProject);
                    username.setText(getResources().getString(R.string.mine_username)+basicResponse.getData().getUserName());
                    role.setText(getResources().getString(R.string.mine_role)+basicResponse.getData().getRoleName());
                    project.setText(getResources().getString(R.string.mine_project)+basicResponse.getData().getPrjName());
                }

            }

            @Override
            public void onFailure(Exception e) {

            }
        });

        //数据请求成功
        /*if(personentity!=null&&()==0){
            init(view);
        }*/

        List<Map<String,Object>> list = new ArrayList<>();
        //往列表中添加数据
        for(int i=0;i<Mine_list.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name",Mine_list[i]);
            map.put("image",images[i]);
            list.add(map);
        }
        adapter = new SimpleAdapter(getActivity(),list,R.layout.mine_list,
                new String[]{"name","image"},new int[]{R.id.textView,R.id.imageView2});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:{
                        Intent intent = new Intent(getActivity(), Minelist_account_Activity.class);
                        intent.putExtra("position",i);
                        startActivity(intent);
                        break;
                    }
                    case 1:{
                        Intent intent = new Intent(getActivity(), Minelist_deptment_Activity.class);
                        intent.putExtra("position",i);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        Intent intent = new Intent(getActivity(), Minelist_team_Activity.class);
                        intent.putExtra("position",i);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        break;
                    }
                    case 4:{
                        break;
                    }
                }
            }
        });

        btn_exit =view.findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("退出");
                builder.setMessage("您确定退出程序吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.putExtra("returnMsg","001");
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        return view;
    }

    /**
     * 初始化
     * @param view
     */
    /*private void init(View view){
        username=view.findViewById(R.id.Mine_username);
        role = view.findViewById(R.id.Mine_userrole);
        project = view.findViewById(R.id.Mine_userProject);
        username.setText(getResources().getString(R.string.mine_username)+.getUserName());
        role.setText(getResources().getString(R.string.mine_role)+personentity.getRoleName());
        project.setText(getResources().getString(R.string.mine_project)+personentity.getPrjName());
    }*/


}
