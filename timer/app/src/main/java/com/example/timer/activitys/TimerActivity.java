package com.example.timer.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.timer.R;
import com.example.timer.presenter.TimeCounter;
import com.example.timer.presenter.TimerTask;

/**
 * Created by 上官刀刀 on 2018/12/28.
 *
 * @author daodao
 * @version 1.0
 */

public class TimerActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mcurrentTextView;//显示当前时间
    private TimerTask mtimerTask;//计时任务
    private TimeCounter mtimeCounter;//计时器
    private Button mbuttonStop;//停止按钮
    private Button mbuttonReset;//重新设置
    private Button mbuttonRestart;//重新开始
    private CounterState mcounterState;//计时器状态

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setClick();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTask();
    }

    /**
     * 初始化控件
     */
    public void initView()
    {
        setContentView(R.layout.activity_timer);
        mcurrentTextView = (TextView) findViewById(R.id.tv_timer_current);
        mbuttonStop = (Button) findViewById(R.id.btn_timer_stop);
        mbuttonReset = (Button) findViewById(R.id.btn_timer_reset);
        mbuttonRestart= (Button) findViewById(R.id.btn_timer_restart);
    }

    /**
     * 初始化数据
     */
    public void initData()
    {
        Bundle bundleFormMainActivity=getIntent().getExtras();
        Long time=bundleFormMainActivity.getLong("time");
        mtimerTask=new TimerTask(new Long(0),time);
    }

    /**
     *开始执行计时器任务
     */
    public void startTask()
    {
        mtimeCounter=new TimeCounter(mtimerTask, mcurrentTextView);
        mcounterState=new CounterRunningState(mtimeCounter);
        mtimeCounter.execute();
    }

    /**
     * 设置监听事件
     */
    public void setClick()
    {
        mbuttonReset.setOnClickListener(this);
        mbuttonStop.setOnClickListener(this);
        mbuttonRestart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_timer_stop:{
                mcounterState.action();
                mcounterState=new CounterStopState(mtimeCounter);
                break;
            }
            case R.id.btn_timer_reset:
            {
                finish();
                break;
            }
            case R.id.btn_timer_restart:
            {
                mcounterState.action();
                mcounterState=new CounterRunningState(mtimeCounter);
                break;
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mtimeCounter.cancel(true);
    }
}
