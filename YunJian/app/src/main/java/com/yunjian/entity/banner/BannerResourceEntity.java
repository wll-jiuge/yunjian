package com.yunjian.entity.banner;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/10/12
 * @describe  轮播图片实体
 */
public class BannerResourceEntity implements Serializable {

    /**
     * graphId : 1
     * graphUrl : https://s1.ax1x.com/2020/10/12/02fjCd.jpg
     */

    private int graphId;
    private String graphUrl;

    public int getGraphId() {
        return graphId;
    }

    public void setGraphId(int graphId) {
        this.graphId = graphId;
    }

    public String getGraphUrl() {
        return graphUrl;
    }

    public void setGraphUrl(String graphUrl) {
        this.graphUrl = graphUrl;
    }
}
