package com.example.visantanna.bandasapp.com.lbd_project.BandaView.com.lbd_project.BandaView.TabFragments;

import android.support.v4.app.Fragment;

/**
 * Created by vis_a on 28-Apr-17.
 */

public class BaseFragment extends Fragment{
    Object argument;

    public void setArgument(Object argument){
        this.argument = argument;
    }
    public Object getArgument(){
        return argument;
    }
}
