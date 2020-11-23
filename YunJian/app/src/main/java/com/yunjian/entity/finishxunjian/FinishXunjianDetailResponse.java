package com.yunjian.entity.finishxunjian;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.finishxunjian
 * @date on 2020/11/20
 * @describe 巡检已完成细节
 */
public class FinishXunjianDetailResponse implements Serializable {

    /**
     * code : 0
     * data : {"taskName":"任务名称1","taskResultDesc":"任务描述"}
     */

    private int code;
    private FinishXunjianDetailEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public FinishXunjianDetailEntity getData() {
        return data;
    }

    public void setData(FinishXunjianDetailEntity data) {
        this.data = data;
    }

}
