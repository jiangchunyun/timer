package com.example.timer.presenter;

import java.sql.Time;

/**
 * Created by 上官刀刀 on 2018/12/27.
 * 是一个模型类，用来描述一个计时任务。
 *
 * @author daodao
 * @version 1.0
 */

public class TimerTask {
    private Long start;//任务的开始时间
    private Long current;//任务的当前时刻
    private Long end;//任务的结束时刻
    private Long dx;//时差

    /**
     * 构造函数，计算时间差
     * @param start the Time 开始时间
     * @param end the Time 结束时间
     */
    public TimerTask(Long start,Long end)
    {
        this.start=start;
        this.end=end;
        dx=this.end-this.start;
    }

    public Long getDx() {
        return dx;
    }

    public void setDx(Long dx) {
        this.dx = dx;
    }


    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

}
