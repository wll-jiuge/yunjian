package com.yunjian.entity.currentxunjian;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.currentxunjian
 * @date on 2020/11/14
 * @describe data类实体
 */
public class CurrentXunjianDetailsEntity implements Serializable {

    /**
     * currentDailyTaskDetailsItemVos : [{"inspItemId":2,"inspItemName":"检验项目名称1","inspMethodContent":["检验方法内容","string","测试"],"inspStdContent":[{"inspStdContent":"检验标准内容","inspStdId":1,"stdLineName":[{"stdLineName":"标准线","stdLineSinglevalue":1.1},{"stdLineName":"标准线2","stdLineSinglevalue":1.3}]},{"inspStdContent":"检验标准内容2","inspStdId":2,"stdLineName":[{"stdLineName":"标准线3","stdLineSinglevalue":2.1},{"stdLineName":"标准线4","stdLineSinglevalue":3.4}]}]},{"inspItemId":3,"inspItemName":"检验项目名称2","inspMethodContent":["string","测试","0"],"inspStdContent":[{"inspStdContent":"检验标准内容","inspStdId":1,"stdLineName":[{"stdLineName":"标准线","stdLineSinglevalue":1.1},{"stdLineName":"标准线2","stdLineSinglevalue":1.3}]},{"inspStdContent":"检验标准内容2","inspStdId":2,"stdLineName":[{"stdLineName":"标准线3","stdLineSinglevalue":2.1},{"stdLineName":"标准线4","stdLineSinglevalue":3.4}]}]}]
     * taskName : 任务名称1
     */

    private String taskName;
    private List<CurrentXunjianDetailsVosEntity> currentDailyTaskDetailsItemVos;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<CurrentXunjianDetailsVosEntity> getCurrentDailyTaskDetailsItemVos() {
        return currentDailyTaskDetailsItemVos;
    }

    public void setCurrentDailyTaskDetailsItemVos(List<CurrentXunjianDetailsVosEntity> currentDailyTaskDetailsItemVos) {
        this.currentDailyTaskDetailsItemVos = currentDailyTaskDetailsItemVos;
    }

}
