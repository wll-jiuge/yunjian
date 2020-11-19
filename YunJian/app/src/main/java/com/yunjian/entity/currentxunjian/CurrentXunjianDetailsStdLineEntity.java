package com.yunjian.entity.currentxunjian;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.currentxunjian
 * @date on 2020/11/14
 * @describe
 */
public class CurrentXunjianDetailsStdLineEntity implements Serializable {
    /**
     * stdLineName : 标准线
     * stdLineSinglevalue : 1.1
     */

    private String stdLineName;
    private double stdLineSinglevalue;

    public String getStdLineName() {
        return stdLineName;
    }

    public void setStdLineName(String stdLineName) {
        this.stdLineName = stdLineName;
    }

    public double getStdLineSinglevalue() {
        return stdLineSinglevalue;
    }

    public void setStdLineSinglevalue(double stdLineSinglevalue) {
        this.stdLineSinglevalue = stdLineSinglevalue;
    }
}
