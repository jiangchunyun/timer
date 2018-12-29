package com.example.timer.activitys;

import com.example.timer.presenter.TimeCounter;

/**
 * 状态模式：停止状态
 * Created by 上官刀刀 on 2018/12/29.
 *
 * @author daoao
 * @version 1.0
 */

public class CounterStopState extends CounterState {

    public CounterStopState(TimeCounter timeCounter) {
        super(timeCounter);
    }

    @Override
    public void action() {
        timeCounter.reStart();
    }
}
