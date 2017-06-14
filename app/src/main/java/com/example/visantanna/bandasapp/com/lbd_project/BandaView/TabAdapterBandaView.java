package com.example.visantanna.bandasapp.com.lbd_project.BandaView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.visantanna.bandasapp.R;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.Entity.BandEntity;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.com.lbd_project.BandaView.TabFragments.BandAboutUsPage;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.com.lbd_project.BandaView.TabFragments.BandCalendarPage;
import com.example.visantanna.bandasapp.com.lbd_project.BandaView.com.lbd_project.BandaView.TabFragments.BandReviewsPage;

/**
 * Criado por Vinícius on 28-Apr-17.
 */

public class TabAdapterBandaView  extends FragmentPagerAdapter{

    Context context;
    BandEntity banda;

    public TabAdapterBandaView(FragmentManager fm, Context context, BandEntity banda){
        super(fm);
        this.context = context;
        this.banda = banda;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                BandAboutUsPage fragmentoAboutUs = new BandAboutUsPage();
                fragmentoAboutUs.setArgument(banda);
                return fragmentoAboutUs;
            case 1:
                BandCalendarPage fragmentoCalendar = new BandCalendarPage();
                fragmentoCalendar.setArgument(banda);
                return fragmentoCalendar;
            case 2:
                BandReviewsPage fragmentoReviews = new BandReviewsPage();
                fragmentoReviews.setArgument(banda);
                return fragmentoReviews;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.sobre_nos);
            case 1:
                return context.getString(R.string.calendario);
            case 2:
                return context.getString(R.string.avaliacoes);
            default:
                return "";
        }
    }
}
