package fragments;
/*
* 我的界面
*
* */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.yunjian.R;
import com.yunjian.entity.Personentity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bottom_navigation_lastfragment extends Fragment {
    private Personentity personentity;
    ListView listView;
    SimpleAdapter adapter;
    TextView username,role,project;
    String res = "{" +
            "  \"msg\": \"ok\"," +
            "  \"code\": 0," +
            "  \"name\": \"不知名的路人甲\"," +
            "  \"sex\": \"男\"," +
            "  \"company\": \"中国建筑第六工程局\"," +
            "  \"role\": \"炮灰QAQ\"," +
            "  \"department\": \"部门A\"," +
            "  \"project\": \"项目A\"," +
            "  \"programs\": [\"项目A\",\"项目B\",\"项目C\"]" +
            "}";
    String[] Mine_list = new String[]{"我的账户", "我的部门", "我的班组", "服务器配置", "上传日志", "关于", "退出系统"};
    int[] images = new int[]{R.drawable.mine_1, R.drawable.mine_2, R.drawable.mine_3,
            R.drawable.mine_4, R.drawable.mine_5, R.drawable.mine_6, R.drawable.mine_7};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_navigation_last,container,false);
        listView = view.findViewById(R.id.listView);
        personentity = new Gson().fromJson(res,Personentity.class);
//        请求成功
        if(personentity!=null&&personentity.getCode()==0){
            init(view);
        }
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
                Toast.makeText(getContext(),"你单击了选项",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void init(View view){
        username=view.findViewById(R.id.Mine_username);
        role = view.findViewById(R.id.Mine_userrole);
        project = view.findViewById(R.id.Mine_userProject);
        username.setText(getResources().getString(R.string.mine_username)+personentity.getName());
        role.setText(getResources().getString(R.string.mine_role)+personentity.getRole());
        project.setText(getResources().getString(R.string.mine_project)+personentity.getProject());
    }
}
