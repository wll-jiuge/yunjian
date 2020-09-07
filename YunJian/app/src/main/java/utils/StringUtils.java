package utils;
/**
 *@package utils
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 字符串判断
*/
public class StringUtils {
    public static boolean isEmpty(String str){
        if(str == null || str.length()<=0){
            return true;
        }
        else{
            return false;
        }
    }
}
