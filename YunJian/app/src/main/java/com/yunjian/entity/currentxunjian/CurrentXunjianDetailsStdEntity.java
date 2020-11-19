package com.yunjian.entity.currentxunjian;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.currentxunjian
 * @date on 2020/11/14
 * @describe
 */
public class CurrentXunjianDetailsStdEntity implements Serializable {

    /**
     * inspStdContent : 检验标准内容
     * inspStdId : 1
     * stdLineName : [{"stdLineName":"标准线","stdLineSinglevalue":1.1},{"stdLineName":"标准线2","stdLineSinglevalue":1.3}]
     */

    private String inspStdContent;
    private int inspStdId;
    private List<CurrentXunjianDetailsStdLineEntity> stdLineName;

    public String getInspStdContent() {
        return inspStdContent;
    }

    public void setInspStdContent(String inspStdContent) {
        this.inspStdContent = inspStdContent;
    }

    public int getInspStdId() {
        return inspStdId;
    }

    public void setInspStdId(int inspStdId) {
        this.inspStdId = inspStdId;
    }

    public List<CurrentXunjianDetailsStdLineEntity> getStdLineName() {
        return stdLineName;
    }

    public void setStdLineName(List<CurrentXunjianDetailsStdLineEntity> stdLineName) {
        this.stdLineName = stdLineName;
    }

}
