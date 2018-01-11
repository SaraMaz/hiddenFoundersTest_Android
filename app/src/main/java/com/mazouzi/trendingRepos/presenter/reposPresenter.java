package com.mazouzi.trendingRepos.presenter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mazouzi.trendingRepos.repos.Repos;


import java.util.ArrayList;


public class reposPresenter {

    public JSONObject reposArray(String url){
        // Creating new JSON Parser
        JsonParser jParser = new JsonParser();
        // Getting JSON from URL
        JSONObject json = jParser.getJSONFromUrl(url);
        return json;
    }


    public ArrayList<Repos> getReposArray(JSONObject jsonRepositories, String url) {
        ArrayList<Repos> repositories = new ArrayList<Repos>();

        //JSON Node Names
        final String TAG_NAME = "name";
        final String TAG_DESCRIPTION = "description";
        final String TAG_USERNAME = "login";
        final String TAG_AVATAR = "avatar_url";
        final String TAG_NUMBERSTARS = "stargazers_count";
        try {
            JSONArray reposArray=reposArray(url).getJSONArray("items");
            for (int i = 0; i < reposArray.length(); i++) {
                String repositoryName=reposArray.getJSONObject(i).getString(TAG_NAME);
                String repositoryDescription=reposArray.getJSONObject(i).getString(TAG_DESCRIPTION);
                String numbersStars=reposArray.getJSONObject(i).getString(TAG_NUMBERSTARS);;
                String username=reposArray.getJSONObject(i).getJSONArray(TAG_USERNAME).getJSONObject(0).getString(TAG_USERNAME);;
                String avatar=reposArray.getJSONObject(i).getJSONArray(TAG_AVATAR).getJSONObject(0).getString(TAG_AVATAR);;
                repositories.add(new Repos(repositoryDescription,numbersStars,repositoryName,username,avatar));

        }
            return repositories;

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        finally {
            return repositories;
        }
        }

    }
