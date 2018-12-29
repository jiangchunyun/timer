package com.example.timer.activitys;

import com.example.timer.presenter.TimeCounter;

/**
 * 状态模式：运行状态
 * Created by 上官刀刀 on 2018/12/29.
 *
 * @author daodao
 * @version 1.0
 */

public class CounterRunningState extends CounterState {
    public CounterRunningState(TimeCounter timeCounter) {
        super(timeCounter);
    }

    @Override
    public void action() {
        timeCounter.stop();
    }
}
