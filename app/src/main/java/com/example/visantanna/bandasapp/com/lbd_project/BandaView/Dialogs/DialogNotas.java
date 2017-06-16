package com.example.visantanna.bandasapp.com.lbd_project.BandaView.Dialogs;

import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;


import com.example.visantanna.bandasapp.R;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.Entity.ConcertDayEntity;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.com.lbd_project.BandaView.TabFragments.BandCalendarPage;

/**
 * Created by vis_a on 15-Jun-17.
 */

public class DialogNotas extends Dialog implements View.OnClickListener{
    ConcertDayEntity day = new ConcertDayEntity();
    EditText etNotas;
    BandCalendarPage telaPai;

    public DialogNotas(BandCalendarPage telaPai , ConcertDayEntity day){
        super(new Activity());
        this.telaPai = telaPai;
        this.day = day;
    }
    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setTitle(day.getBusyDay().toString());
        etNotas = (EditText)findViewById(R.id.etNota);
        if(day.getDescription() != null && !day.getDescription().isEmpty()){
            etNotas.setText(day.getDescription());
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSalvar:
                day.setDescription(etNotas.getText().toString());
                telaPai.save


        }

    }

}
