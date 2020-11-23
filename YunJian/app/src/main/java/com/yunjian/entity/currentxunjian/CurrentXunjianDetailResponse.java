package com.yunjian.entity.currentxunjian;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/11/14
 * @describe
 */
public class CurrentXunjianDetailResponse implements Serializable {


    /**
     * code : 0
     * data : {"currentDailyTaskDetailsItemVos":[{"inspItemId":2,"inspItemName":"检验项目名称1","inspMethodContent":["检验方法内容","string","测试"],"inspStdContent":[{"inspStdContent":"检验标准内容","inspStdId":1,"stdLineName":[{"stdLineName":"标准线","stdLineSinglevalue":1.1},{"stdLineName":"标准线2","stdLineSinglevalue":1.3}]},{"inspStdContent":"检验标准内容2","inspStdId":2,"stdLineName":[{"stdLineName":"标准线3","stdLineSinglevalue":2.1},{"stdLineName":"标准线4","stdLineSinglevalue":3.4}]}]},{"inspItemId":3,"inspItemName":"检验项目名称2","inspMethodContent":["string","测试","0"],"inspStdContent":[{"inspStdContent":"检验标准内容","inspStdId":1,"stdLineName":[{"stdLineName":"标准线","stdLineSinglevalue":1.1},{"stdLineName":"标准线2","stdLineSinglevalue":1.3}]},{"inspStdContent":"检验标准内容2","inspStdId":2,"stdLineName":[{"stdLineName":"标准线3","stdLineSinglevalue":2.1},{"stdLineName":"标准线4","stdLineSinglevalue":3.4}]}]}],"taskName":"任务名称1"}
     */

    private int code;
    private CurrentXunjianDetailsEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CurrentXunjianDetailsEntity getData() {
        return data;
    }

    public void setData(CurrentXunjianDetailsEntity data) {
        this.data = data;
    }

}
