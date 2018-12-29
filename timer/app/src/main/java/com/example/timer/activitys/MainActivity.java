package com.example.timer.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.timer.R;

/**
 * create by daoao on 2018.12.27
 * app的主界面
 *
 * @author daodao
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText timeEditText;//设置倒计时控件
    private Button startButton;//开始计时按钮
    private Long mtime;//计时任务
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setClick();
    }

    /**
     * 初始化控件
     */
    public void initView()
    {
        timeEditText= (EditText) findViewById(R.id.et_main_time);
        startButton= (Button) findViewById(R.id.btn_main_start);
    }

    public void setData()
    {
         mtime= Long.valueOf(timeEditText.getText().toString());
    }
    /**
     * 给控件设置监听事件
     */
    public void setClick()
    {
        startButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
           switch (view.getId())
           {
               case R.id.btn_main_start:
               {
                   Intent intent=new Intent();
                   setData();
                   Bundle toTimerActivityBundle=new Bundle();
                   toTimerActivityBundle.putLong("time",mtime);
                   intent.putExtras(toTimerActivityBundle);
                   intent.setClass(this,TimerActivity.class);
                   startActivity(intent);
                   break;
               }
           }
    }

}
