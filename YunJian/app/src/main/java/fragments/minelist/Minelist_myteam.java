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

public class Minelist_myteam extends Fragment {
    ListView listView;
    public Minelist_mydeptment getInstance(){
        Minelist_mydeptment fragment = new Minelist_mydeptment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minelist_myteam,container,false);
        listView=view.findViewById(R.id.listview_minelist_myteam);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.minelist_myteam_item,getResources().getStringArray(R.array.myteam_list));
        listView.setAdapter(adapter);
        return view;
    }
}
