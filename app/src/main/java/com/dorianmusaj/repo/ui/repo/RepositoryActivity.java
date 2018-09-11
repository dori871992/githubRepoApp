package com.dorianmusaj.repo.ui.repo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.model.GithubRepository;
import com.dorianmusaj.repo.model.RepositoryDetails;
import com.dorianmusaj.repo.ui.basic.BasicActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryActivity extends BasicActivity implements  MvpRepoView {

    private RepoPresenter presenter;

    @BindView(R.id.details_icon)
    ImageView icon;
    @BindView(R.id.details_owner_name)
    TextView ownerNameTv;
    @BindView(R.id.details_owner_desc)
    TextView ownerDescTv;

    @BindView(R.id.details_watch)
    TextView watchTv;
    @BindView(R.id.details_star)
    TextView starTv;
    @BindView(R.id.details_fork)
    TextView forkTv;

    @BindView(R.id.details_branches_url)
    TextView branchesUrlTv;
    @BindView(R.id.details_forks_url)
    TextView forksUrlTv;
    @BindView(R.id.details_teams_url)
    TextView teamsUrlTv;
    @BindView(R.id.details_commits_url)
    TextView commitsUrlTv;
    @BindView(R.id.details_clone_url)
    TextView cloneUrlTv;
    @BindView(R.id.details_homepage)
    TextView homePageTv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        int repoId= getIntent().getExtras().getInt("repoId");
        presenter=new RepoPresenter(this, this);
        presenter.getRepoDetails(repoId);


    }

    @Override
    public void showRepoDetails(RepositoryDetails repository) {
        getSupportActionBar().setTitle(repository.getName());
        Uri uri = Uri.parse(repository.getOwner().getAvatar()).buildUpon()
                .build();
        Glide
                .with(this)
                .load(uri)
                .error(R.drawable.ic_splash_github)
                .into(icon);

        ownerNameTv.setText(repository.getOwner().getLogin());
        ownerDescTv.setText(repository.getDescription());

        watchTv.setText("watch: "+ repository.getWatchers_count());
        starTv.setText("star: "+ repository.getStargazers_count());
        forkTv.setText("fork: "+ repository.getForks_count());

        forksUrlTv.setText(repository.getForks_url());
        teamsUrlTv.setText(repository.getTeams_url());
        branchesUrlTv.setText(repository.getBranches_url());
        commitsUrlTv.setText(repository.getCommits_url());
        cloneUrlTv.setText(repository.getClone_url());
        homePageTv.setText(repository.getHomepage());




    }
}
