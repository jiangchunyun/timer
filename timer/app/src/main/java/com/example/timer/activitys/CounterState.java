package com.example.timer.activitys;

import com.example.timer.presenter.TimeCounter;

/**
 * 状态模式：基础停止状态类
 * Created by 上官刀刀 on 2018/12/29.
 *
 * @author daodao
 * @version 1.0
 */

public abstract class CounterState {
    public TimeCounter timeCounter;//计时器
    public CounterState(TimeCounter timeCounter)
    {
        this.timeCounter=timeCounter;
    }
    public abstract void action();
}
