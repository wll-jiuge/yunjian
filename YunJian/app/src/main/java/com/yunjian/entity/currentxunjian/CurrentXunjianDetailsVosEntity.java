package com.yunjian.entity.currentxunjian;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.currentxunjian
 * @date on 2020/11/14
 * @describe vos类实体
 */
public class CurrentXunjianDetailsVosEntity implements Serializable {

    /**
     * inspItemId : 2
     * inspItemName : 检验项目名称1
     * inspMethodContent : ["检验方法内容","string","测试"]
     * inspStdContent : [{"inspStdContent":"检验标准内容","inspStdId":1,"stdLineName":[{"stdLineName":"标准线","stdLineSinglevalue":1.1},{"stdLineName":"标准线2","stdLineSinglevalue":1.3}]},{"inspStdContent":"检验标准内容2","inspStdId":2,"stdLineName":[{"stdLineName":"标准线3","stdLineSinglevalue":2.1},{"stdLineName":"标准线4","stdLineSinglevalue":3.4}]}]
     */

    private int inspItemId;
    private String inspItemName;
    private List<String> inspMethodContent;
    private List<CurrentXunjianDetailsStdEntity> inspStdContent;

    public int getInspItemId() {
        return inspItemId;
    }

    public void setInspItemId(int inspItemId) {
        this.inspItemId = inspItemId;
    }

    public String getInspItemName() {
        return inspItemName;
    }

    public void setInspItemName(String inspItemName) {
        this.inspItemName = inspItemName;
    }

    public List<String> getInspMethodContent() {
        return inspMethodContent;
    }

    public void setInspMethodContent(List<String> inspMethodContent) {
        this.inspMethodContent = inspMethodContent;
    }

    public List<CurrentXunjianDetailsStdEntity> getInspStdContent() {
        return inspStdContent;
    }

    public void setInspStdContent(List<CurrentXunjianDetailsStdEntity> inspStdContent) {
        this.inspStdContent = inspStdContent;
    }

}
