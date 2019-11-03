package com.example.iboxui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;

public class IboxLayout extends LinearLayout {

    private Context context;

    //四行父布局
    private RelativeLayout rl1;
    private RelativeLayout rl2;
    private RelativeLayout rl3;
    private RelativeLayout rl4;

    //数据
    //第一行
    private RadioButtonManager radioButtonManager = new RadioButtonManager();
    private TextView currentSelected;
    private TextView rl1More;
    private ListView rl1MoreList;



    public IboxLayout(Context context) {
        super(context);
        init(context);
    }

    public IboxLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IboxLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public IboxLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.ibox_layout, null);

        rl1 = linearLayout.findViewById(R.id.rl1);

        initRl1();

        rl1More = linearLayout.findViewById(R.id.more_ibox);
        rl1MoreList = linearLayout.findViewById(R.id.more_ibox_list);
        currentSelected = linearLayout.findViewById(R.id.current_selected);

        String[] arr = new String[]{"ibox4", "ibox5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.item, arr);
        rl1MoreList.setAdapter(adapter);

        rl1MoreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("点击了" + position);
                rl1MoreList.setVisibility(GONE);

            }
        });

        rl1More.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rl1MoreList.getVisibility() == View.GONE){
                    rl1MoreList.setVisibility(View.VISIBLE);
                }else {
                    rl1MoreList.setVisibility(GONE);
                }
            }
        });

        rl2 = linearLayout.findViewById(R.id.rl2);
        rl3 = linearLayout.findViewById(R.id.rl3);
        rl4 = linearLayout.findViewById(R.id.rl4);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(linearLayout, params);
    }

    private void initRl1(){
        for(int i=0; i< rl1.getChildCount(); i++){
            if(rl1.getChildAt(i) instanceof RadioButton){
                radioButtonManager.addRadioButton((RadioButton) rl1.getChildAt(i));
            }
        }
    }



}
