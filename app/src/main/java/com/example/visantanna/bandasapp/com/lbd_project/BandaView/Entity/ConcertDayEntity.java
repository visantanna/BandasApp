package com.example.visantanna.bandasapp.com.lbd_project.BandaView.Entity;

import java.util.Date;


/**
 * Created by vis_a on 15-Jun-17.
 */

public class ConcertDayEntity {
    int id_User;
    int id_Calendar;
    String description;
    Date busyDay ;
    Boolean ativo ;

    public int getId_Calendar() {
        return id_Calendar;
    }

    public void setId_Calendar(int id_Calendar) {
        this.id_Calendar = id_Calendar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBusyDay() {
        return busyDay;
    }

    public void setBusyDay(Date busyDay) {
        this.busyDay = busyDay;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()){
            return false;
        }else{
            ConcertDayEntity day= (ConcertDayEntity)obj;
            if(this.getBusyDay() == day.getBusyDay()){
                return true;
            }else{
                return false;
            }
        }
    }
}
