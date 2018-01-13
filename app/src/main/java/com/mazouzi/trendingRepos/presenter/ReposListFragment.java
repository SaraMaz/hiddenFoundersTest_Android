package com.mazouzi.trendingRepos.presenter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mazouzi.trendingRepos.presenter.HttpHandler;
import com.mazouzi.trendingRepos.repos.Repos;
import com.mazouzi.trendingRepos.repos.ReposAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ReposListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        reposPresenter rP = new reposPresenter();
        rP.execute();
        return v;
    }

    //Get informations of the most starred github repositories from Jsonfile and display them
    private class reposPresenter extends AsyncTask<Void, Void, Void> {
        ArrayList<Repos> repositories = new ArrayList<Repos>();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url snd getting repositories
            String url = "https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc";
            String jsonStr = sh.makeServiceCall(url);

            //JSON Node Names (informations of repository)
            final String TAG_NAME = "name";
            final String TAG_DESCRIPTION = "description";
            final String TAG_USERNAME = "login";
            final String TAG_AVATAR = "avatar_url";
            final String TAG_NUMBERSTARS = "stargazers_count";

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray items = jsonObj.getJSONArray("items");
                    // looping through All items of Json file
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject c = items.getJSONObject(i);
                        JSONObject owner=c.getJSONObject("owner");
                        String repositoryName=c.getString(TAG_NAME);
                        String repositoryDescription=c.getString(TAG_DESCRIPTION);
                        String numbersStars=c.getString(TAG_NUMBERSTARS);
                        String username=owner.getString(TAG_USERNAME);
                        String avatar=owner.getString(TAG_AVATAR);

                        repositories.add(new Repos(repositoryDescription,numbersStars,repositoryName,username,avatar));
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            setListAdapter(new ReposAdapter(getActivity(), repositories));

        }
    }
}
