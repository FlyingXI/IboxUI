package com.example.iboxui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class IboxLayout extends LinearLayout {

    private Context context;

    //四行父布局
    private RelativeLayout rl1;
    private RelativeLayout rl2;
    private RelativeLayout rl3;
    private RelativeLayout rl4;

    public IboxLayout(Context context) {
        super(context);
    }

    public IboxLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IboxLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public IboxLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.ibox_layout, null);

        rl1 = linearLayout.findViewById(R.id.rl1);
        rl2 = linearLayout.findViewById(R.id.rl2);
        rl3 = linearLayout.findViewById(R.id.rl3);
        rl4 = linearLayout.findViewById(R.id.rl4);
    }

    private void initRl1(){

    }


}
