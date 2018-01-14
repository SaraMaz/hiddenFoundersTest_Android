package com.mazouzi.trendingRepos.repos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mazouzi.trendingRepos.MyApp;
import com.mazouzi.trendingRepos.listitemviewdemo.R;
import com.squareup.picasso.Picasso;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


// ReposView acts as its own “holder” by using member variables to store references to its significant child views.
public class ReposView extends RelativeLayout {
    private TextView mrepositoryName;
    private TextView mrepositoryDescription;
    private TextView mnumbersStars;
    private TextView musername;
    private ImageView mavatar;

    // Create properly-configured the repos view (ReposViewHolder) by using the XML layout resource
    public static ReposView inflate(ViewGroup parent) {

        //get a Context from the parent argument and inflate the R.layout.item_view layout resource
        //returning the root ReposView found there
        //here we don't get the child views, its a constructor issue
        ReposView ReposView = (ReposView)LayoutInflater.from(parent.getContext()).inflate(R.layout.repos_view, parent, false);
        return ReposView;
    }

    public ReposView(Context c) {
        this(c, null);
    }
    public ReposView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //the constructor is used to inflate a secondary layout for the children view.
    public ReposView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.repos_view_children, this, true);
        setupChildren();
    }

    //Associating the child views with the appropriate member variables by calling findViewById(int).
    private void setupChildren() {
        mrepositoryName=(TextView)findViewById(R.id.reposName);
        mrepositoryDescription=(TextView)findViewById(R.id.reposDescription);
        mnumbersStars=(TextView)findViewById(R.id.numberStars);
        musername=(TextView)findViewById(R.id.reposOwnerName);
        mavatar=(ImageView)findViewById(R.id.avatar);
    }

    // getters end setters
    public TextView getMrepositoryDescription() {
        return mrepositoryDescription;
    }

    public TextView getMrepositoryName() {
        return mrepositoryName;
    }

    public TextView getMnumbersStars() {
        return mnumbersStars;
    }

    public TextView getMusername() {
        return musername;
    }

    public ImageView getMavatar() {
        return mavatar;
    }

    public void setRepos(Repos repos) {
        mrepositoryName.setText(repos.getRepositoryName());
        mrepositoryDescription.setText(repos.getRepositoryDescription());
        mnumbersStars.setText(repos.getNumbersStars());
        musername.setText(repos.getUsername());
        Picasso.with(MyApp.getContext())  //Here, this is context.
              .load(repos.getAvatar())  //Url of the image to load.
            .into(mavatar);

    }


}
