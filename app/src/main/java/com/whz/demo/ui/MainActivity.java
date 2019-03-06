package com.whz.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.whz.xposed.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String aTag = "ConfigUtil";

    private final String DEFAULT_VALUE = "默认消息";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_01:
                btn_01();
                break;
            case R.id.btn_02:
                btn_02(DEFAULT_VALUE, 100);
                break;
            default:
                break;
        }
    }


    public static void btn_04(String msg, int id) {
        Log.e(aTag, "btn_04:" + msg + "," + id);
    }

    public void btn_03() {
        Log.e(aTag, "btn_03:被调用了");
    }

    public void btn_02(String msg, int id) {
        Toast.makeText(this, msg + "," + id, Toast.LENGTH_SHORT).show();
    }

    private void btn_01() {
        Toast.makeText(this, getResult(), Toast.LENGTH_SHORT).show();
    }

    public String getResult() {
        return DEFAULT_VALUE;
    }

    /**
     * 初始化显示数据
     */
    private void initData() {
        mTextView = findViewById(R.id.tv_init);
        mTextView.setText(DEFAULT_VALUE);
    }

    /**
     * 初始化VIew
     */
    private void initView() {
        findByID(R.id.btn_01);
        findByID(R.id.btn_02);
    }

    /**
     * 查找资源ID
     */
    private void findByID(int id) {
        findViewById(id).setOnClickListener(this);
    }
}
