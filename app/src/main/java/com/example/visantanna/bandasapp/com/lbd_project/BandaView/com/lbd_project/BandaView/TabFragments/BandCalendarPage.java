package com.example.visantanna.bandasapp.com.lbd_project.BandaView.com.lbd_project.BandaView.TabFragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.example.visantanna.bandasapp.com.lbd_project.BandaView.Dialogs.DialogNotas;
import com.loopj.android.http.*;

/**
 * Created by vis_a on 28-Apr-17.
 */
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import cz.msebera.android.httpclient.Header;

import com.example.visantanna.bandasapp.R;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.Entity.BandEntity;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.Entity.ConcertDayEntity;
import com.loopj.android.http.RequestParams;
import com.squareup.timessquare.CalendarPickerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;

public class BandCalendarPage extends BaseFragment {

    CalendarPickerView calendario;
    Handler handle = new Handler();
    ArrayList<ConcertDayEntity> listaDias = new ArrayList<ConcertDayEntity>();

    public BandCalendarPage(){

    }
    public View OnCreateView(LayoutInflater inflater , ViewGroup container , Bundle SavedInstances){
        BandEntity banda = (BandEntity)getArgument();
        View viewCalendario = inflater.inflate( R.layout.fragment_calendar , container ,false);
        listaDias.addAll(getDatasDaBanda(banda.getIdUser()));

        calendario = (CalendarPickerView)viewCalendario.findViewById(R.id.calendar_view);
        Date date = new Date();
        calendario.scrollToDate(date);

        calendario.setOnTouchListener(new View.OnTouchListener( ) {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ConcertDayEntity diaDeShow = new ConcertDayEntity();
                        Date dia = calendario.getSelectedDate();
                        if (dia == null) {
                            return false;
                        }
                        diaDeShow.setBusyDay(dia);

                        if (handle.postDelayed(new Thread(), 3000)) {

                            if (listaDias.contains(diaDeShow)) {
                                ConcertDayEntity diaDeShowExistente = listaDias.stream().filter(s -> diaDeShow.equals(s)).findAny().orElse(null);
                                DialogNotas dialog = new DialogNotas(returnThis(), diaDeShowExistente);
                                dialog.show();

                            } else {
                                ConcertDayEntity novoDiaDeShow = new ConcertDayEntity();
                                novoDiaDeShow.setAtivo(false);
                                novoDiaDeShow.setId_User(banda.getIdUser());
                                novoDiaDeShow.setId_Calendar(getLastCalendarId() + 1);
                                DialogNotas dialog = new DialogNotas(returnThis(), novoDiaDeShow);
                                dialog.show();

                            }
                        } else {
                            if (listaDias.contains(diaDeShow)) {
                                ConcertDayEntity diaDeShowExistente = listaDias.stream()
                                        .filter(s -> diaDeShow.equals(s)).findAny().orElse(null);
                                diaDeShowExistente.setAtivo(!diaDeShowExistente.getAtivo());
                            } else {
                                ConcertDayEntity diaDeShowNovo = new ConcertDayEntity();
                                diaDeShowNovo.setAtivo(false);
                                listaDias.add(diaDeShowNovo);
                            }
                        }
                }
                return true;
            }
        });
        return viewCalendario;
    }


    public void saveDialogDay(ConcertDayEntity savedDay){
        if(listaDias.contains(savedDay)) {
            ConcertDayEntity diaDeShowExistente = listaDias.stream().filter(s -> savedDay.equals(s)).findAny().orElse(null);
            diaDeShowExistente.setDescription(savedDay.getDescription());
        }else{
            ConcertDayEntity diaDeShowNovo = new ConcertDayEntity();
            diaDeShowNovo.setDescription(savedDay.getDescription());
            listaDias.add(diaDeShowNovo);
        }
    }

    public int getLastCalendarId(){
        //SELECT TOP(1) FROM CONCERTDAYS
        int maiorId = 18;
        return maiorId;
    }
    private BandCalendarPage returnThis(){
        return this;
    }

    public ArrayList<ConcertDayEntity> getDatasDaBanda(int idUser){
        //SELECT idConcertDays , busyDay , idUsuario , DESCRIPTION , ATIVO
        //FROM CONCERTDAYS
        //WHERE idUsuario = idUsuario
        ArrayList<ConcertDayEntity> ListaDias = new ArrayList<ConcertDayEntity>();

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("idUsuario",idUser);

        final RequestHandle requestHandle = client.get("http://www.lbd.bravioseguros.com.br/??????", params, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                try {
                    int a = 0;

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
        return ListaDias;
    }



}

