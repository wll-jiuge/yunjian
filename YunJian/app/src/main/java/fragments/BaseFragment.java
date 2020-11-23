package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author 吴立柳
 * @package fragments
 * @date on 2020/9/7
 * @describe
 */
public class BaseFragment extends Fragment {
    /**
     *页面跳转
     * @param c1s
     */

    public void navigateTo(Class c1s){
        Intent intent = new Intent(getActivity(),c1s);
        startActivity(intent);
    }

    /**
     * Save stringto sp.
     * 存储token
     *
     * @param key   the key
     * @param value the value
     */

    protected void saveStringtoSp(String key,String value){
        SharedPreferences sp = getActivity().getSharedPreferences("sp_token",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.commit();
    }

    /**
     * 获取sp中的值
     * @param key
     * @return
     */
    protected String getStringFromSp(String key){
        SharedPreferences sp = getActivity().getSharedPreferences("sp_token", MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
