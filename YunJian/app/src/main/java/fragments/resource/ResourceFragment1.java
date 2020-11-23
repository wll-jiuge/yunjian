package fragments.resource;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yunjian.R;
import com.yunjian.adapters.ResouceImageAdapter;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 资源页面--图片页面
*/
public class ResourceFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resource_1,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.resource1_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        
        ResouceImageAdapter adapter = new ResouceImageAdapter(getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
