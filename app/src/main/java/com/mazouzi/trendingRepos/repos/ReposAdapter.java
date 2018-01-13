package com.mazouzi.trendingRepos.repos;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;


public class ReposAdapter extends ArrayAdapter<Repos> {
    Context context;
    public ReposAdapter(Activity c, List<Repos> repos) {
        super(c, 0, repos);
        context=c.getApplicationContext();


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReposView reposView = (ReposView)convertView;
        // return an instance of reposView if we don’t have one to reuse.
        if (null == reposView)
            reposView = ReposView.inflate(parent);
        //populate the view with the data for the current repos using setRepos(Repos)
        reposView.setRepos(getItem(position));
        return reposView;
    }



}
