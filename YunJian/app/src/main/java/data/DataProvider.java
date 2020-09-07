package data;

import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.yunjian.R;

import java.util.ArrayList;
import java.util.List;

/**
 *@package data
 *@date on 2020/9/6
 *@author 吴立柳
 *@describe 数据提供
*/
public class DataProvider {
    /**
     * 轮播图文字
     */
    public static String[] titles = new String[]{
            "AAAAAAA",
            "BBBBBBB",
            "CCCCCCC",
            "DDDDDDD",
            "EEEEEEE"
    };

    /**
     * 轮播图路径
     */
    public static String[] urls = new String[]{//640*360 360/640=0.5625
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1597331577&di=159ad972d08dcf09552b8c68480db1de&src=http://b.hiphotos.baidu.com/zhidao/pic/item/7aec54e736d12f2e08524bdf4ec2d5628535683e.jpg",//伪装者:胡歌演绎"痞子特工"
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597344422438&di=96bb39b9bcb6b1601e309c407c2cf359&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F8644ebf81a4c510f973523a36b59252dd52aa592.jpg",//无心法师:生死离别!月牙遭虐杀
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597344422438&di=dddb3479c2c516be7c3242fb63744777&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fc2cec3fdfc0392458d85a6868794a4c27d1e2502.jpg",//花千骨:尊上沦为花千骨
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597344422427&di=1d8fd2bfd25fb6a4408a7b9df754e0a4&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201307%2F25%2F20130725103054_rtaCt.jpeg",//综艺饭:胖轩偷看夏天洗澡掀波澜
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597344503812&di=12285650b343538053d812cae6ff5012&imgtype=0&src=http%3A%2F%2Fbbs.mzsky.cc%2Fdata%2Fattachment%2Fforum%2F201112%2F26%2F221609ok5x5oks53z7bzp3.jpg",//碟中谍4:阿汤哥高塔命悬一线,超越不可能
    };

    /**
     * Gets banner list.
     *
     * @return the banner list
     */
    public static List<BannerItem> getBannerList() {
        ArrayList<BannerItem> list = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            BannerItem item = new BannerItem();
            item.imgUrl = urls[i];
            item.title = titles[i];

            list.add(item);
        }

        return list;
    }
}
