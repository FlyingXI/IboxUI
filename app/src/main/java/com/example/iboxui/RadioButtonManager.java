package com.example.iboxui;

import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;
/* 类似RadioGroup管理在不同布局属于同一组的radioButton*/
public class RadioButtonManager {

    private List<RadioButton> radioButtons;
    private int checkedId;
    private OnCheckedChangeListener onCheckedChangeListener;

    public RadioButtonManager(){
        radioButtons = new ArrayList<>();
    }

    public RadioButtonManager(List<RadioButton> radioButtons){
        this();
        for(RadioButton rb : radioButtons){
            addRadioButton(rb);
        }

    }

    public RadioButtonManager(RadioButton radioButton){
        this();
        addRadioButton(radioButton);
    }

    public void addRadioButton(RadioButton radioButton){
        radioButtonRegistListener(radioButton);
        radioButtons.add(radioButton);
    }

    private void radioButtonRegistListener(final RadioButton radioButton){
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    List<RadioButton> list = getRadioButtons();
                    for (int i=0; i<list.size(); i++) {
                        RadioButton rb = list.get(i);
                        if (buttonView.getId() != rb.getId()) {
                            rb.setChecked(false);
                        } else {
                            setCheckedId(i);
                        }
                    }
                }
            }
        });
    }

    private List<RadioButton> getRadioButtons() {
        return radioButtons;
    }

    public void setRadioButtons(List<RadioButton> radioButtons) {
        this.radioButtons = radioButtons;
    }

    public int getCheckedId() {
        return checkedId;
    }

    private void setCheckedId(int checkedId) {
        if (checkedId == getCheckedId()){
            return;
        }
        this.checkedId = checkedId;
        if(onCheckedChangeListener != null){
            onCheckedChangeListener.onCheckedChanged(getRadioButtons(), getCheckedId());
        }
    }

    public interface OnCheckedChangeListener{
        public void onCheckedChanged(List<RadioButton> radioButtons, int checkedId);
    }
}
