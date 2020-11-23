package fragments.resource;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yunjian.R;

/**
 *@package fragments
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 资源页面--文档页面
*/
public class ResourceFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resource_2,container,false);
        return view;
    }
}
