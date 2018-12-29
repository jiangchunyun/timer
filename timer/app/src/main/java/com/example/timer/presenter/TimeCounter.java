package com.example.timer.presenter;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;

/**
 * Created by 上官刀刀 on 2018/12/27.
 *
 * @author daodao
 * @version 1.0
 */

public class TimeCounter extends AsyncTask<Long,Long,Long>{
    private TimerTask mtimerTask;//执行的倒计时任务
    private TextView mcurrentTime;//显示倒计时
    private boolean isStop=false;//是否停止

    /**
     * 构造函数用来构造时间计时器
     * @param mtimerTask the TimerTask 客户端传递给计时器的倒计时任务
     * @param mcurrentTime thne TextView 用来显示倒计时
     */
    public TimeCounter(TimerTask mtimerTask,TextView mcurrentTime)
    {
        this.mtimerTask=mtimerTask;
        this.mcurrentTime=mcurrentTime;
    }

    @Override
    protected Long doInBackground(Long... times) {
        while(mtimerTask.getDx()>=0)
        {
            publishProgress(mtimerTask.getDx());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(isStop())
            {

            }
            else {
                mtimerTask.setDx(mtimerTask.getDx() - 1);
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        mcurrentTime.setText(String.valueOf(values[0]));
    }

    /**
     * 判断是否停止
     *
     * @return the boolean 停止标志
     */
    public boolean isStop() {
        return isStop;
    }

    /**
     * 停止倒计时
     */
    public void stop()
    {
        isStop=true;
    }

    /**
     * 重新开始
     */
    public void reStart()
    {
        isStop=false;
    }
}
