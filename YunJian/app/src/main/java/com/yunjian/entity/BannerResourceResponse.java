package com.yunjian.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/10/12
 * @describe  轮播图响应
 */
public class BannerResourceResponse implements Serializable {

    /**
     * code : 0
     * data : [{"graphId":1,"graphUrl":"https://s1.ax1x.com/2020/10/12/02fjCd.jpg"},{"graphId":2,"graphUrl":"https://s1.ax1x.com/2020/10/12/02fO4H.jpg"},{"graphId":3,"graphUrl":"https://s1.ax1x.com/2020/10/12/02fqED.jpg"},{"graphId":4,"graphUrl":"https://s1.ax1x.com/2020/10/12/02fLUe.jpg"}]
     */

    private int code;
    private List<BannerResourceEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<BannerResourceEntity> getData() {
        return data;
    }

    public void setData(List<BannerResourceEntity> data) {
        this.data = data;
    }

}
